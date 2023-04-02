package com.store.webstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.webstore.entity.Address;
import com.store.webstore.service.IAddressService;
import com.store.webstore.util.JsonResult;

import jakarta.servlet.http.HttpSession;

@RequestMapping("addresses")
@RestController
public class AddressController extends BaseController {
    @Autowired
    private IAddressService addressService;

    @RequestMapping("add_new_address")
    public JsonResult<Void> addNewService(Address address,HttpSession session){
        Integer uid=getuidFromSession(session);
        String username=getUsernameFromSession(session);
        addressService.addNewAddress(address, uid, username);
        return new JsonResult<>(ok);

    }

    @RequestMapping({"/",""})
    public JsonResult<List<Address>> getByUid(HttpSession session){
        Integer uid= getuidFromSession(session);
        List<Address> data=addressService.getByUid(uid);
        return new JsonResult<>(ok,data);
    }

    @RequestMapping("{aid}/set_default")
    public  JsonResult<Void> setDefault(@PathVariable("aid") Integer aid,HttpSession session){
        Integer uid= getuidFromSession(session);
        String username= getUsernameFromSession(session);
        addressService.setDefault(uid, aid, username);
        return new JsonResult<>(ok);

    }

    @RequestMapping("{aid}/delete")
    public  JsonResult<Void> delete(@PathVariable("aid") Integer aid,HttpSession session){
        Integer uid= getuidFromSession(session);
        String username= getUsernameFromSession(session);
        addressService.delete(uid, aid, username);
        return new JsonResult<>(ok);

    }


}

