package com.store.webstore.mapper;



import java.util.Date;
import java.util.List;

import com.store.webstore.entity.Cart;
import com.store.webstore.vo.CartVo;

public interface CartMapper {

    Integer insert(Cart cart);

    Integer updateNumByCid(Integer cid,Integer num,String modifiedUser,Date modifiedTime);

    Cart findByUidAndPid(Integer uid,Integer pid);

    List<CartVo> findVoByUid(Integer uid);

    Cart findByCid(Integer cid);

    List<CartVo> findVoByCids(Integer[] cids);

}
