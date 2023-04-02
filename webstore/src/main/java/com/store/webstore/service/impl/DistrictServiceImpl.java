package com.store.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.webstore.entity.District;
import com.store.webstore.mapper.DistrictMapper;
import com.store.webstore.service.IDistrictService;

@Service
public class DistrictServiceImpl implements IDistrictService{
    @Autowired
    private DistrictMapper districtMapper;

    @Override
    public List<District> getByParent(String parent) {
        List<District> districts= districtMapper.findByParent(parent);

        for(District d:districts){
            d.setParent(null);
            d.setId(null);
        }

        return districts;

    }

    @Override
    public String getNameByCode(String code) {
        
        return districtMapper.findNameByCode(code);
    }
    
}