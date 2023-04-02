package com.store.webstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.webstore.service.ICartService;
import com.store.webstore.util.JsonResult;
import com.store.webstore.vo.CartVo;

import jakarta.servlet.http.HttpSession;

@RequestMapping("carts")
@RestController
public class CartController extends BaseController {
    @Autowired
    private ICartService cartService;

    @RequestMapping("add_to_cart")
    public JsonResult<Void> addToCart(Integer pid,Integer amount,HttpSession session){
        Integer uid=getuidFromSession(session);
        String username=getUsernameFromSession(session);
        cartService.addToCart(uid,pid,amount,username);
        return new JsonResult<>(ok);

    }

    @RequestMapping({"/",""})
    public JsonResult<List<CartVo>> getVoByUid(HttpSession session){
        List<CartVo> data=cartService.getVoByUid(getuidFromSession(session));

        return new JsonResult<>(ok,data);

    }

    @RequestMapping("{cid}/num/add")
    public JsonResult<Integer> addNum(@PathVariable("cid") Integer cid,HttpSession session){
        Integer data=cartService.addNum(cid,getuidFromSession(session),getUsernameFromSession(session));

        return new JsonResult<>(ok,data);

    }

    @RequestMapping("{cid}/num/reduce")
    public JsonResult<Integer> reduceNum(@PathVariable("cid") Integer cid,HttpSession session){
        Integer data=cartService.reduceNum(cid,getuidFromSession(session),getUsernameFromSession(session));

        return new JsonResult<>(ok,data);

    }

    @RequestMapping("list")
    public JsonResult<List<CartVo>> getVoByCids(Integer[] cids,HttpSession session){
        List<CartVo> data=cartService.getVoByCids(cids,getuidFromSession(session));

        return new JsonResult<>(ok,data);

    }



    

}

