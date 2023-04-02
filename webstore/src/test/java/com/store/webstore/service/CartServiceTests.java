package com.store.webstore.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@RunWith(SpringRunner.class)
public class CartServiceTests {
    @Autowired
    private ICartService cartService;

    @Test
    public void addToCart(){
        cartService.addToCart(3, 10000010, 2, "bbb");

    }

    @Test 
    public void addNum(){
        cartService.addNum(38, 3, "bbb");
    }
    
    @Test 
    public void reduceNum(){
        cartService.reduceNum(38, 3, "bbb");
    }

    @Test 
    public void getVoByCids(){
        Integer[] cids={38,45,40};
        System.out.println(cartService.getVoByCids(cids,3));
    }
}
