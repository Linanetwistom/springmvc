package com.store.webstore.mapper;

import java.util.List;

import com.store.webstore.entity.Product;

public interface ProductMapper {

    List<Product> findhotlist();

    Product findById(Integer id);

}
