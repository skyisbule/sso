package com.skyisbule.sso.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface helloDao {

    @Select("select user_name from user where id=1")
    public String test();

}
