package com.store.webstore.mapper;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.store.webstore.entity.Order;
import com.store.webstore.entity.OrderItem;

@SpringBootTest


public class OrderMapperTest{
    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void insertOrder(){
        Order order = new Order();
        order.setUid(1);
        order.setAid(1);
        order.setRecvName("bbb");
        order.setRecvPhone("1234567");
        System.out.println(orderMapper.insertOrder(order));
    }

    @Test
    public void insertOrderItem(){
        OrderItem orderItem = new OrderItem();
        orderItem.setOid(1);
        orderItem.setPid(45);
        orderItem.setTitle("得力（deli）1548A商务办公桌面计算器 太阳能双电源");
        orderItem.setImage("/images/portal/002calculator1548A/");
        System.out.println(orderMapper.insertOrderItem(orderItem));
    }


}
