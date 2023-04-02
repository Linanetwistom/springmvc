package com.store.webstore.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.store.webstore.entity.Address;

@SpringBootTest
//@RunWith(SpringRunner.class)
public class AddressServiceTests {
    @Autowired
    private IAddressService addressService;

    @Test
    public void addNewAddress(){
        Address address = new Address();
        address.setPhone("123455");
        address.setAddress("japan tokyo");
        address.setName("lisi");
        addressService.addNewAddress(address, 1, "lisi");
    }

    @Test
    public void setDefault(){
        addressService.setDefault(3, 23, "admin");

    }

    @Test
    public void delete(){
        addressService.delete(3, 19, "bbb");
    }




    
}
