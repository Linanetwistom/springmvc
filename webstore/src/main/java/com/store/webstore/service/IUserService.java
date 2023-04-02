package com.store.webstore.service;

import com.store.webstore.entity.User;

public interface IUserService {
    void reg(User user);

    User login(String username,String password);

    void changePassword(Integer uid,String username,String oldpassword,String newpassword);

    User getByUid(Integer uid);

    void changeInfor(Integer uid,String username,User user);

    void changeAvatar(Integer uid, String avatar,String username);

}
