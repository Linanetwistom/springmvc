package com.store.webstore.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.store.webstore.entity.Product;

@SpringBootTest
//@RunWith(SpringRunner.class)
public class ProductServiceTests {
    @Autowired
    private IProductService productService;

    @Test
    public void findHotList(){
        List<Product> list=productService.findHotList();
        System.out.println(list);

    }






    
}
