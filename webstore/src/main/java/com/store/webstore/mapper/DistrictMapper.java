package com.store.webstore.mapper;

import java.util.List;

import com.store.webstore.entity.District;

public interface DistrictMapper {
   List<District>  findByParent(String parent);
   
   String findNameByCode(String code);
}
