package com.store.webstore.service;

import java.util.List;

import com.store.webstore.vo.CartVo;

public interface ICartService {

    void addToCart(Integer uid,Integer pid,Integer amount,String username);

    List<CartVo> getVoByUid(Integer uid);

    Integer addNum(Integer cid,Integer uid,String username);

    Integer reduceNum(Integer cid,Integer uid,String username);

    List<CartVo> getVoByCids(Integer[] cids,Integer uid);

}
