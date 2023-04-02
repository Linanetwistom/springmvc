package com.store.webstore.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.webstore.entity.Address;
import com.store.webstore.entity.Order;
import com.store.webstore.entity.OrderItem;
import com.store.webstore.mapper.OrderMapper;
import com.store.webstore.service.IAddressService;
import com.store.webstore.service.ICartService;
import com.store.webstore.service.IOrderService;
import com.store.webstore.service.ex.UpdateExceptrion;
import com.store.webstore.vo.CartVo;

@Service
public class OrderServiceImpl implements IOrderService{
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private IAddressService addressService;

    @Autowired
    private ICartService cartService;

    @Override
    public Order create(Integer aid, Integer uid, String username, Integer[] cids) {

        Address address=addressService.getByAid(aid, uid);

        Order order=new Order();
        order.setUid(uid);
        order.setAid(address.getAid());
        order.setRecvName(address.getName());
        order.setRecvProvince(address.getProvinceName());
        order.setRecvCity(address.getCityName());
        order.setRecvArea(address.getAreaName());
        order.setRecvPhone(address.getPhone());

        List<CartVo> list=cartService.getVoByCids(cids, uid);

        Long totalPrice=0L;

        for(CartVo c:list){
            totalPrice+=c.getRealPrice()*c.getNum();
        }

        order.setTotalPrice(totalPrice);
        order.setCreatedUser(username);
        order.setCreatedTime(new Date());
        order.setModifiedTime(new Date());
        order.setModifiedUser(username);
        order.setOrderTime(new Date());
        order.setStatus(0);

        Integer rows= orderMapper.insertOrder(order);
        if(rows!=1){
            throw new UpdateExceptrion("数据更新失败");
        }

        for(CartVo c:list){
            OrderItem orderItem=new OrderItem();
            orderItem.setImage(c.getImage());
            orderItem.setTitle(c.getTitle());
            orderItem.setOid(order.getOid());
            orderItem.setNum(c.getNum());
            orderItem.setPrice(c.getRealPrice());
            orderItem.setPid(c.getPid());
            
            orderItem.setCreatedUser(username);
            orderItem.setCreatedTime(new Date());
            orderItem.setModifiedTime(new Date());
            orderItem.setModifiedUser(username);

            Integer row=orderMapper.insertOrderItem(orderItem);
            if(row!=1){
                throw new UpdateExceptrion("插入数据异常");
            }

            
        }


        return order;
        

    }



    
}