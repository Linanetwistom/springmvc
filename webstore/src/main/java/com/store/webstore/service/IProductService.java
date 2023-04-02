package com.store.webstore.service;

import java.util.List;

import com.store.webstore.entity.Product;

public interface IProductService {

    List<Product> findHotList();

    Product findById(Integer id);

}
