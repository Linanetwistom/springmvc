package com.store.webstore.mapper;

import java.util.Date;

import com.store.webstore.entity.User;


public interface UserMapper {

    Integer insert(User user);

    User findByUsername(String username);

    Integer updatePasswordByUid(Integer uid, String password,String modifiedUser,Date modifiedTime);

    User findByuid(Integer uid);

    Integer updateInforByUid(User user);

    Integer updataAvatarByUid(Integer uid, String avatar,String modifiedUser,Date modifiedTime);
}
