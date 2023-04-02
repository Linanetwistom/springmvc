package com.store.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.webstore.entity.Product;
import com.store.webstore.mapper.ProductMapper;
import com.store.webstore.service.IProductService;
import com.store.webstore.service.ex.ProductNotFoundException;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> findHotList() {

        List <Product> list=productMapper.findhotlist();
        for(Product product:list){
            product.setModifiedTime(null);
            product.setCreatedTime(null);
            product.setCreatedUser(null);
            product.setModifiedUser(null);
        }
        return list;


    }

    @Override
    public Product findById(Integer id) {
        Product product=productMapper.findById(id);

        if(product==null){
            throw new ProductNotFoundException("尝试访问的商品不存在");
        }
        product.setModifiedTime(null);
        product.setCreatedTime(null);
        product.setCreatedUser(null);
        product.setModifiedUser(null);

        return product;

    }    
}