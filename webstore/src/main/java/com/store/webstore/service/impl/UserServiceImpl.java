package com.store.webstore.service.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.store.webstore.entity.User;
import com.store.webstore.mapper.UserMapper;
import com.store.webstore.service.IUserService;
import com.store.webstore.service.ex.PasswordNotMatchException;
import com.store.webstore.service.ex.UpdateExceptrion;
import com.store.webstore.service.ex.UserNotFoundException;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void reg(User user) {

        String username=user.getUsername();

        User result=userMapper.findByUsername(username);

        if(result!=null){
            throw new UnsupportedOperationException("用户名已存在");
        }

        String oldPassword=user.getPassword();
        String salt=UUID.randomUUID().toString().toUpperCase();
        user.setSalt(salt);
        String md5Password=getMD5password(oldPassword,salt);
        user.setPassword(md5Password);


        user.setIsDelete(0);
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());

        Date date= new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);

        Integer rows= userMapper.insert(user);
        if(rows!=1){
            throw new UnsupportedOperationException("注册异常");
        }


        // TODO Auto-generated method stub
        
    }

    private String getMD5password(String password,String salt){
        for(int i=0;i<3;i++){
            password=DigestUtils.md5DigestAsHex((salt+password+salt).getBytes()).toUpperCase();
        }
        return password;

    }

    @Override
    public User login(String username, String password) {
        // TODO Auto-generated method stub
        User result= userMapper.findByUsername(username);
        if (result==null){
            throw new UnsupportedOperationException("用户名不存在");          
        }

        String oldPassword=result.getPassword();

        String salt = result.getSalt();

        String newpassword=getMD5password(password, salt);

        if(!oldPassword.equals(newpassword)){
            throw new PasswordNotMatchException("用户密码错误");
        }

        if(result.getIsDelete()==1){
            throw new UserNotFoundException("用户名已被删除");
        }

        User user = new User();
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());
        user.setAvatar(result.getAvatar());

        return user;
    }

    @Override
    public void changePassword(Integer uid, String username, String oldpassword, String newpassword) {
 
        User  result= userMapper.findByuid(uid);

        if (result==null || result.getIsDelete()==1){
            throw new UserNotFoundException("用户不存在");
        }

        String oldMd5Password=getMD5password(oldpassword, result.getSalt());

        if(!oldMd5Password.equals(result.getPassword())){
            throw new PasswordNotMatchException("密码错误");

        }

        String newMd5Password = getMD5password(newpassword, result.getSalt());

        Integer rows =  userMapper.updatePasswordByUid(uid,newMd5Password,username, new Date());

        if(rows!=1){
            throw new UpdateExceptrion("更新数据产生未知异常");
        }
    }

    @Override
    public User getByUid(Integer uid) {
        User result = userMapper.findByuid(uid);
        if(result==null ||result.getIsDelete()==1){
            throw new UserNotFoundException("用户数据不存在");     
        }
        User user=new User();
        user.setEmail(result.getEmail());
        user.setPhone(result.getPhone());
        user.setUsername(result.getUsername());
        user.setGender(result.getGender());

        return user;
    }

    @Override
    public void changeInfor(Integer uid, String username, User user) {
        User result = userMapper.findByuid(uid);
        if(result==null ||result.getIsDelete()==1){
            throw new UserNotFoundException("用户数据不存在");     
        }

        user.setUid(uid);
        user.setModifiedUser(username);
        user.setModifiedTime(new Date());

        Integer rows=userMapper.updateInforByUid(user);

        if (rows!=1){
            throw new UpdateExceptrion("更新数据时产生异常");
        }
    }
    @Override
    public void changeAvatar(Integer uid, String avatar, String username) {
        User result = userMapper.findByuid(uid);
        if(result==null ||result.getIsDelete()==1){
            throw new UserNotFoundException("用户数据不存在");     
        }
        Integer rows=userMapper.updataAvatarByUid(uid, avatar, username, new Date());

        if (rows!=1){
            throw new UpdateExceptrion("更新数据时产生异常");
        }

    }
}
