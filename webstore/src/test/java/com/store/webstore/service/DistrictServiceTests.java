package com.store.webstore.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.store.webstore.entity.District;

@SpringBootTest
//@RunWith(SpringRunner.class)
public class DistrictServiceTests {
    @Autowired
    private IDistrictService districtService;

    @Test
    public void getByParent(){
       List<District> district= districtService.getByParent("210100");
       for(District d:district){
        System.out.println(d);
       }
    }

    
}
