package com.store.webstore.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.webstore.entity.Cart;
import com.store.webstore.entity.Product;
import com.store.webstore.mapper.CartMapper;
import com.store.webstore.mapper.ProductMapper;
import com.store.webstore.service.ICartService;
import com.store.webstore.service.ex.AccessDeniedException;
import com.store.webstore.service.ex.CartNotFoundException;
import com.store.webstore.service.ex.InsertException;
import com.store.webstore.service.ex.UpdateExceptrion;
import com.store.webstore.vo.CartVo;

@Service
public class CartServiceImpl implements ICartService{
    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public void addToCart(Integer uid, Integer pid, Integer amount, String username) {

        Cart result=cartMapper.findByUidAndPid(uid, pid);
        Date date=new Date();
        if(result==null){
            Cart cart=new Cart();
            
            cart.setPid(pid);
            cart.setUid(uid);
            cart.setNum(amount);
            Product product=productMapper.findById(pid);
            cart.setPrice(product.getPrice());

            cart.setCreatedUser(username);
            cart.setModifiedUser(username);
            cart.setCreatedTime(date);
            cart.setModifiedTime(date);
            cartMapper.insert(cart);

            Integer rows=cartMapper.insert(cart);

            System.out.println(rows);

            if(rows!=1){
                throw new InsertException("插入数据时产生未知异常");
            }

        }else{

            Integer num=result.getNum()+amount;
            Integer rows=cartMapper.updateNumByCid(result.getCid(), num, username, date);
            if(rows!=1){
                throw new InsertException("更新数据时产生未知异常");
            }

        }

    }

    @Override
    public List<CartVo> getVoByUid(Integer uid) {
        return cartMapper.findVoByUid(uid);

    }

    @Override
    public Integer addNum(Integer cid, Integer uid, String username) {
        Cart result= cartMapper.findByCid(cid);

        if(result==null){
            throw new CartNotFoundException("数据不存在");
        }
        if(!result.getUid().equals(uid)){
            throw new AccessDeniedException("非法数据访问");
        }
        Integer num= result.getNum()+1;

        Integer rows=cartMapper.updateNumByCid(cid, num, username, new Date());

        if(rows!=1){
            throw new UpdateExceptrion("更新数据失败");
        }

        return num;

    }

    @Override
    public Integer reduceNum(Integer cid, Integer uid, String username) {
        Cart result= cartMapper.findByCid(cid);

        if(result==null){
            throw new CartNotFoundException("数据不存在");
        }
        if(!result.getUid().equals(uid)){
            throw new AccessDeniedException("非法数据访问");
        }
        Integer num= result.getNum()-1;

        if(num<0){
            num=0;
            
        }

        Integer rows=cartMapper.updateNumByCid(cid, num, username, new Date());

        if(rows!=1){
            throw new UpdateExceptrion("更新数据失败");
        }

        return num;

    }

    @Override
    public List<CartVo> getVoByCids(Integer[] cids, Integer uid) {

        List<CartVo> list=cartMapper.findVoByCids(cids);

        Iterator  <CartVo> it=list.iterator();

        while (it.hasNext()){
            CartVo cartVo=it.next();
            if(!cartVo.getUid().equals(uid)){
                list.remove(cartVo);
            }
        }

        return list;
    }


    
}