package com.store.webstore.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.store.webstore.controller.ex.FileEmptyException;
import com.store.webstore.controller.ex.FileSizeException;
import com.store.webstore.controller.ex.FileStatusException;
import com.store.webstore.controller.ex.FileUploadException;
import com.store.webstore.controller.ex.FileUploadIoException;
import com.store.webstore.service.ex.AccessDeniedException;
import com.store.webstore.service.ex.AddressCountLimitException;
import com.store.webstore.service.ex.AddressNotFoundException;
import com.store.webstore.service.ex.CartNotFoundException;
import com.store.webstore.service.ex.DeleteExceptrion;
import com.store.webstore.service.ex.InsertException;
import com.store.webstore.service.ex.PasswordNotMatchException;
import com.store.webstore.service.ex.ProductNotFoundException;
import com.store.webstore.service.ex.ServiceException;
import com.store.webstore.service.ex.UpdateExceptrion;
import com.store.webstore.service.ex.UserNotFoundException;
import com.store.webstore.service.ex.UsernameDuplicatedServiceExceptionn;
import com.store.webstore.util.JsonResult;

import jakarta.servlet.http.HttpSession;

public class BaseController {

    public static final int ok= 200;

    @ExceptionHandler({ServiceException.class,FileUploadException.class})
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result =new JsonResult<> (e);
        if (e instanceof UsernameDuplicatedServiceExceptionn){
            result.setState(4000);
            result.setMessage("用户名被占用");
    
        }else if(e instanceof InsertException){
            result.setState(5000);
            result.setMessage("注册异常");
        }else if(e instanceof UserNotFoundException){
            result.setState(5001);
            result.setMessage("用户名未找到");
        }else if(e instanceof PasswordNotMatchException){
            result.setState(5002);
            result.setMessage("密码错误");
        }else if(e instanceof UpdateExceptrion){
            result.setState(5003);
            result.setMessage("更新时异常");
        }else if(e instanceof FileUploadException){
            result.setState(6000);
            result.setMessage("文件上传时产生异常");
        }else if(e instanceof FileEmptyException){
            result.setState(6002);
            result.setMessage("文件为空");
        }else if(e instanceof FileSizeException){
            result.setState(6003);
            result.setMessage("文件大小异常");
        }else if(e instanceof FileStatusException){
            result.setState(6004);
            result.setMessage("文件状态异常");
        }else if(e instanceof FileUploadIoException){
            result.setState(6001);
            result.setMessage("文件上传时Io异常");
        }else if(e instanceof AddressCountLimitException){
            result.setState(7001);
            result.setMessage("用户收货地址超出上限的异常");
        }else if(e instanceof AccessDeniedException){
            result.setState(8001);
            result.setMessage("非法数据访问");
        }else if(e instanceof AddressNotFoundException){
            result.setState(8002);
            result.setMessage("用户收货地址不存在");
        }else if(e instanceof CartNotFoundException){
            result.setState(8003);
            result.setMessage("购物车数据不存在");
        }else if(e instanceof DeleteExceptrion){
            result.setState(9002);
            result.setMessage("删除用户收货地址异常");
        }else if(e instanceof ProductNotFoundException){
            result.setState(9002);
            result.setMessage("商品数据不存在的异常");
        }
        
        return result;
    }

    protected final Integer getuidFromSession(HttpSession session){
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    protected final String getUsernameFromSession(HttpSession session){
        return session.getAttribute("username").toString();
    }

}
