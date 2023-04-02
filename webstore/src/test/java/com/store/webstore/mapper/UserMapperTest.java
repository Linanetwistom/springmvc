package com.store.webstore.mapper;


import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.store.webstore.entity.User;

@SpringBootTest


public class UserMapperTest{

    @Autowired
    private UserMapper userMapper;
    
    @Test
    public void insert(){
        User user = new User();
        user.setUsername("tomm");
        user.setPassword("123");
        Integer rows=userMapper.insert(user);
        System.out.print(rows);

    }

    @Test
    public void findByUsername(){
        User user = userMapper.findByUsername("aaa");
        System.out.println(user);
    }

    @Test
    public void updatePasswordByUid(){
        userMapper.updatePasswordByUid(1, "32123","admin" , new Date());
    }

    @Test
    public void findByuid(){
        System.out.print(userMapper.findByuid(1));

    }

    @Test
    public void updateInforByUid(){
        User user= new User();
        user.setUid(1);
        user.setEmail("hdusi@yahu.com");
        user.setPhone("123455");
        user.setGender(1);
        userMapper.updateInforByUid(user);
    }

    @Test
    public void updataAvatarByUid(){
        userMapper.updataAvatarByUid(2,        
        "/upload/avatar.png","admin", new Date());


    }


}
