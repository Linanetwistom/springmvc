package com.store.webstore.mapper;

import com.store.webstore.entity.Order;
import com.store.webstore.entity.OrderItem;

public interface OrderMapper {

    Integer insertOrder(Order order);

    Integer insertOrderItem(OrderItem orderItem);

}
