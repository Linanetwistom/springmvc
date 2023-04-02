package com.store.webstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.webstore.entity.Product;
import com.store.webstore.service.IProductService;
import com.store.webstore.util.JsonResult;

@RequestMapping("products")
@RestController
public class ProductController extends BaseController {
    @Autowired
    private IProductService productService;

    @RequestMapping("hot_list")
    public JsonResult<List<Product>> getHotList(){
        List <Product> data=productService.findHotList();

        return new JsonResult<List<Product>>(ok,data);

    }

    @GetMapping("{id}/details")
    public JsonResult<Product> getById(@PathVariable("id") Integer id){
        Product data=productService.findById(id);

        return new JsonResult<Product>(ok,data);

    }

    
}

