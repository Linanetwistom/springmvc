package com.store.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.webstore.entity.Order;
import com.store.webstore.service.IOrderService;
import com.store.webstore.util.JsonResult;

import jakarta.servlet.http.HttpSession;

@RequestMapping("order")
@RestController
public class OrderController extends BaseController {
    @Autowired
    private IOrderService orderService;

    @RequestMapping("create")
    public JsonResult<Order> create(Integer aid,HttpSession session,Integer[] cids){
        Integer uid=getuidFromSession(session);
        String username=getUsernameFromSession(session);
        Order data=orderService.create(aid, uid, username,cids);
        return new JsonResult<>(ok,data);

    }



}

