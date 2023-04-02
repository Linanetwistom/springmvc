package com.store.webstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.webstore.entity.District;
import com.store.webstore.service.IDistrictService;
import com.store.webstore.util.JsonResult;

@RequestMapping("districts")
@RestController
public class DistrictController extends BaseController {
    @Autowired
    private IDistrictService districtService;

@RequestMapping({"/",""})
    public JsonResult<List<District>> getByParent(String parent){
        List<District> data=districtService.getByParent(parent);
        return new JsonResult<>(ok,data);
    }


}

