package com.skyisbule.sso.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by skyisbule on 2017/11/23.
 * 用于处理登录的数据库层
 */
@Mapper
public interface LoginDao {

    //返回手机号对应的密码
    @Select("select passwd from user where telnum=#{tel} limit 1")
    public String getPasswdByTel(@Param("tel") String tel);


}
