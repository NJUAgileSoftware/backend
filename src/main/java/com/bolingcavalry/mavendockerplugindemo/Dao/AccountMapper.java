package com.bolingcavalry.mavendockerplugindemo.Dao;

import com.bolingcavalry.mavendockerplugindemo.PO.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountMapper {
    User getUserByName(@Param("username") String username);

    User getUserById(@Param("id")long id);

}
