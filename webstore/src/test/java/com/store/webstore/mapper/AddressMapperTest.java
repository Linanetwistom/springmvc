package com.store.webstore.mapper;


import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.store.webstore.entity.Address;

@SpringBootTest


public class AddressMapperTest{
    @Autowired
    private AddressMapper addressMapper;

    @Test
    public void insert(){
        Address address = new Address();
        address.setUid(1);
        address.setAddress("japan tokyo");
        address.setName("lisi");
        addressMapper.insert(address);
    }

    @Test
    public void countByuid(){
        Integer count=addressMapper.countByuid(1);
        System.out.println(count);
    }

    @Test
    public void findByUid(){
        List <Address> list=addressMapper.findByUid(3);
        for(Address l:list){
            System.out.println(l);
        }
    }

    @Test
    public void findByAid(){
        Address address=addressMapper.findByAid(1);
        System.out.println(address);
    }

    @Test
    public void updateNonDefault(){
        Integer count=addressMapper.updateNonDefault(3);
        System.out.println(count);
    }

    @Test
    public void updateDefaultByAid(){
        Integer count=addressMapper.updateDefaultByAid(23, "admin", new Date());
        System.out.println(count);
    }

    @Test
    public void findLastModified(){
        Address address=addressMapper.findLastModified(3);
        System.out.println(address);
    }

    @Test
    public void deleteByAid(){
        addressMapper.deleteByAid(12);
    }

}
