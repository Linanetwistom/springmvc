package com.store.webstore.mapper;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.store.webstore.entity.District;

@SpringBootTest


public class DistrictMapperTest{
    @Autowired
    private DistrictMapper districtMapper;

    @Test
    public void findByParent(){
        List<District> list=districtMapper.findByParent("210100");
        for(District d:list){
            System.out.println(d);
        }

    }
    @Test
    public void findNameByCode(){
        System.out.println(districtMapper.findByParent("210100"));
    }




}
