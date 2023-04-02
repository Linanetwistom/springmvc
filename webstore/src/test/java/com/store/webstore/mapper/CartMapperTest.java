package com.store.webstore.mapper;


import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.store.webstore.entity.Cart;

@SpringBootTest


public class CartMapperTest{
    @Autowired
    private CartMapper cartMapper;

    @Test
    public void insert(){
        Cart cart = new Cart();
        cart.setUid(3);
        cart.setPid(10000017);
        cart.setNum(2);
        cart.setPrice(1000l);
        cartMapper.insert(cart);
    }

    @Test
    public void updateNumByCid(){
        cartMapper.updateNumByCid(27, 4, "admin", new Date());

    }

    @Test
    public void findByUidAndPid(){
        Cart cart=cartMapper.findByUidAndPid(3, 10000017);
        System.out.println(cart);
    }

    @Test
    public void findVoByUid(){
        
        System.out.println(cartMapper.findVoByUid(3));
    }

    @Test
    public void findByCid(){
        System.out.println(cartMapper.findByCid(38));
    }

    @Test
    public void findVoByCids(){
        Integer[] cids={38,45,40};
        System.out.println(cartMapper.findVoByCids(cids));
    }


}
