package com.store.webstore.service;

import java.util.List;

import com.store.webstore.entity.District;

public interface IDistrictService {

    List<District> getByParent(String parent);

    String getNameByCode(String code);
}
