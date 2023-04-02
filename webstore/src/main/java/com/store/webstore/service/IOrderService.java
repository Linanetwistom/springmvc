package com.store.webstore.service;

import com.store.webstore.entity.Order;

public interface IOrderService {
    
    Order create(Integer aid,Integer uid,String username,Integer [] cids);

}
