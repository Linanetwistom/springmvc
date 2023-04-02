package com.store.webstore.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.store.webstore.entity.Address;
import com.store.webstore.mapper.AddressMapper;
import com.store.webstore.service.IAddressService;
import com.store.webstore.service.IDistrictService;
import com.store.webstore.service.ex.AccessDeniedException;
import com.store.webstore.service.ex.AddressCountLimitException;
import com.store.webstore.service.ex.AddressNotFoundException;
import com.store.webstore.service.ex.DeleteExceptrion;
import com.store.webstore.service.ex.InsertException;
import com.store.webstore.service.ex.UpdateExceptrion;

@Service
public class AddressServiceImpl implements IAddressService{
    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private IDistrictService districtService;

    @Value("${user.address.max-count}")
    private Integer maxCount;

    @Override
    public void addNewAddress(Address address, Integer uid, String username) {

        Integer count= addressMapper.countByuid(uid);
        if(count>=maxCount){
            throw new AddressCountLimitException("用户收货地址超出上限");
        }

        String ProvinceName=districtService.getNameByCode(address.getProvinceCode());
        String cityName=districtService.getNameByCode(address.getCityCode());
        String areaName=districtService.getNameByCode(address.getAreaCode());

        address.setProvinceName(ProvinceName);
        address.setCityName(cityName);
        address.setAreaName(areaName);

        address.setUid(uid);
        Integer isDefault=count==0? 1:0;
        address.setIsDefault(isDefault);

        address.setCreatedUser(username);
        address.setModifiedUser(username);
        address.setCreatedTime(new Date());
        address.setModifiedTime(new Date());

        Integer rows= addressMapper.insert(address);
        if(rows!=1){
            throw new InsertException("插入用户收货地址时产生异常");
        }
    }

    @Override
    public List<Address> getByUid(Integer uid) {
        List<Address> list=addressMapper.findByUid(uid);
        for(Address address:list){
            address.setProvinceCode(null);
            address.setCityCode(null);
            address.setAreaCode(null);
            address.setCreatedTime(null);
            address.setCreatedUser(null);
            address.setModifiedTime(null);
            address.setModifiedUser(null);

        }
        return list;
    }

    @Override
    public void setDefault(Integer uid, Integer aid, String username) {
        Address result=addressMapper.findByAid(aid);
        if(result==null){
            throw new AddressNotFoundException("收货地址不存在");
        }
        if(!result.getAid().equals(aid)){
            throw new AccessDeniedException("非法数据访问");
        }

        Integer rows = addressMapper.updateNonDefault(uid);
        if(rows<1){
            throw new UpdateExceptrion("更新数据时产生未知异常");
        }

        rows=addressMapper.updateDefaultByAid(aid, username, new Date());
        if(rows!=1){
            throw new UpdateExceptrion("更新数据时产生未知异常");
        }

    }

    @Override
    public void delete(Integer uid, Integer aid, String username) {
        Address result=addressMapper.findByAid(aid);
        if(result==null){
            throw new AddressNotFoundException("收货地址不存在");
        }
        if(!result.getAid().equals(aid)){
            throw new AccessDeniedException("非法数据访问");
        }

        Integer rows=addressMapper.deleteByAid(aid);
        if(rows!=1){
            throw new DeleteExceptrion("删除数据时产生异常");
        }

        if(result.getIsDefault()==0){
            return;
        }

        Integer count=addressMapper.countByuid(uid);
        if(count==0){ 
            return;           
        }

        Address address = addressMapper.findLastModified(uid);
        rows=addressMapper.updateDefaultByAid(address.getAid(), username, new Date());


        if(rows!=1){
            throw new UpdateExceptrion("更新数据时产生未知异常");
        }

    }

    @Override
    public Address getByAid(Integer aid,Integer uid) {

        Address address = addressMapper.findByAid(aid);

        if(address==null){
            throw new AddressNotFoundException("收货地址不存在");
        }

        if(!address.getUid().equals(uid)){
            throw new AccessDeniedException("非法数据访问");
        }

        address.setAreaCode(null);
        address.setCityCode(null);
        address.setProvinceCode(null);
        address.setCreatedTime(null);
        address.setCreatedUser(null);
        address.setModifiedTime(null);
        address.setModifiedUser(null);    

        return address;

    }
    
}