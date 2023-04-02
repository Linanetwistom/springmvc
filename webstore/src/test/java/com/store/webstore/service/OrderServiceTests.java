package com.store.webstore.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.store.webstore.entity.Order;

@SpringBootTest
//@RunWith(SpringRunner.class)
public class OrderServiceTests {
    @Autowired
    private IOrderService orderService;

    @Test
    public void create(){

        Integer[] cids={38,45};
        Order order=orderService.create(24, 3, "bbb", cids);
        System.out.println(order);

    }
    
}
