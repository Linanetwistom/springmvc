package com.store.webstore.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.store.webstore.controller.ex.FileEmptyException;
import com.store.webstore.controller.ex.FileSizeException;
import com.store.webstore.controller.ex.FileStatusException;
import com.store.webstore.controller.ex.FileTypeException;
import com.store.webstore.controller.ex.FileUploadIoException;
import com.store.webstore.entity.User;
import com.store.webstore.service.IUserService;
import com.store.webstore.util.JsonResult;

import jakarta.servlet.http.HttpSession;


@RestController
@RequestMapping("users")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    @RequestMapping("reg")
    //@ResponseBody
    public JsonResult<Void> reg(User user){
        userService.reg(user);
        return new JsonResult<>(ok);
        
    }
    
    
    @RequestMapping("login")
    public JsonResult<User> login(String username,String password, HttpSession session){
        User data= userService.login(username,password);
        session.setAttribute("uid", data.getUid());
        session.setAttribute("username", data.getUsername());

        System.out.println(getuidFromSession(session));
        System.out.println(getUsernameFromSession(session));
        return new JsonResult<User>(ok,data);

    }

    @RequestMapping("change_password")
    public JsonResult<Void> changePassword(String oldPassword, String newPassword,HttpSession session){
        Integer uid=getuidFromSession(session);
        String username=getUsernameFromSession(session);
        userService.changePassword(uid, username, oldPassword, newPassword);
        return new JsonResult<>(ok);
    }

    @RequestMapping("get_by_uid")
    public JsonResult<User> getByUid(HttpSession session){
        User data=userService.getByUid(getuidFromSession(session));
        return new JsonResult<>(ok,data);
    }

    @RequestMapping("change_info")
    public JsonResult<User> changeInfor(User user,HttpSession session){
        Integer uid=getuidFromSession(session);
        String username=getUsernameFromSession(session);

        userService.changeInfor(uid, username, user);
        return new JsonResult<>(ok);

    }

    public static final int AVATAR_MAX_SIZE=10*1024*1024;

    public static final List<String> AVATAR_TYPE=new ArrayList<>();

    static{
        AVATAR_TYPE.add("image/jpeg");
        AVATAR_TYPE.add("image/png");
        AVATAR_TYPE.add("image/bmp");
        AVATAR_TYPE.add("image/gif");
    }


    @RequestMapping("change_avatar")
    public JsonResult<String> changeAvatar(HttpSession session,MultipartFile file){
        if(file.isEmpty()){
            throw new FileEmptyException("文件为空");
        }
        if(file.getSize()>AVATAR_MAX_SIZE){
            throw new FileSizeException("文件大小超出限制");
        }

        String contentType=file.getContentType();
        System.out.println(contentType);

        if(!AVATAR_TYPE.contains(contentType)){
            throw new FileTypeException("文件类型不支持");
        }

        String parent=session.getServletContext().getRealPath("upload");

        File dir= new File(parent);
        if(!dir.exists()){
            dir.mkdirs();
        }
        String originalFilename=file.getOriginalFilename();
        System.out.println("originalFilename"+originalFilename);
        int index=originalFilename.lastIndexOf(".");
        String suffix=originalFilename.substring(index);
        String filename=UUID.randomUUID().toString().toUpperCase()+suffix;
        File dest=new File(dir,filename);
        try {
            file.transferTo(dest);
        } catch(FileStatusException e){
                throw new FileStatusException("文件状态异常");

        }
        catch (IOException e) {
            throw new FileUploadIoException("文件读写异常");
        }

        Integer uid = getuidFromSession(session);
        String username=getUsernameFromSession(session);

        String avatar="/upload/" + filename;
        userService.changeAvatar(uid, avatar, username);  

        //TODOlist
        return new JsonResult<>(ok,avatar);


    }


}
