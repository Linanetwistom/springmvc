package com.store.webstore.mapper;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.store.webstore.entity.Product;

@SpringBootTest


public class ProductMapperTest{
    @Autowired
    private ProductMapper productMapper;

    @Test
    public void findhotlist(){
        List<Product> product = productMapper.findhotlist();
        System.out.println(product);

    }

}
