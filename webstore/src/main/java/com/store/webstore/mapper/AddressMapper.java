package com.store.webstore.mapper;

import java.util.Date;
import java.util.List;

import com.store.webstore.entity.Address;

public interface AddressMapper {

    Integer insert(Address address);

    Integer countByuid(Integer uid);

    List<Address> findByUid(Integer uid);

    Address findByAid(Integer aid);

    Integer updateNonDefault(Integer uid);

    Integer updateDefaultByAid(Integer aid,String modifiedUser,Date modifiedTime);

    Address findLastModified(Integer uid);

    Integer deleteByAid(Integer aid);
}
