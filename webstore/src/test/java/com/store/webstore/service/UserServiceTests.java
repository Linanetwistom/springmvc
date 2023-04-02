package com.store.webstore.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.store.webstore.entity.User;
import com.store.webstore.service.ex.ServiceException;

@SpringBootTest
//@RunWith(SpringRunner.class)
public class UserServiceTests {
    @Autowired
    private IUserService userService;

    @Test
    public void reg(){

        try {
            User user = new User();
            user.setUsername("yuanxin02");
            user.setPassword("123");
            userService.reg(user);
            System.out.println("ok");
        } catch (ServiceException e) {
            // TODO: handle exception
            System.out.print(e.getClass().getSimpleName());
            System.out.print(e.getMessage());
        }



    }
    @Test
    public void login(){
        User user=userService.login("yuanxin01","123" );
        System.out.println(user);
    }

    @Test
    public void changePassword(){
        userService.changePassword(2, "yuanxin02", "321", "123");
    }

    @Test
    public void findByuid(){
        System.out.println(userService.getByUid(2));
    }

    @Test
    public void changeInfor(){
        User user=new User();
        user.setEmail("hdskd@gmail.com");
        user.setPhone("1345345");
        user.setGender(0);
        userService.changeInfor(2, "yuanxin02", user);

    }

    @Test
    public void changeAvatar(){
        userService.changeAvatar(2, "/upload/avatar.jpg", "yuanxin02");
    }




    
}
