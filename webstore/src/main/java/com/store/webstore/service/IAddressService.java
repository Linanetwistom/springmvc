package com.store.webstore.service;

import java.util.List;

import com.store.webstore.entity.Address;

public interface IAddressService {
    void addNewAddress(Address address,Integer uid,String username);

    List<Address> getByUid(Integer uid);

    void setDefault(Integer uid,Integer aid,String username);

    void delete(Integer uid,Integer aid,String username);

    Address getByAid(Integer aid,Integer uid);
}

