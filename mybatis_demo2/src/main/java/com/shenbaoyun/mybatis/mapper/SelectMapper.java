package com.shenbaoyun.mybatis.mapper;

import com.shenbaoyun.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author shenbaoyun
 * @create 2022-09-18 12:25
 */
public interface SelectMapper {
    /**
     * 查询所有用户信息为map集合
     */
    //List<Map<String ,Object>> getUserMap();
    @MapKey("id")
    Map<String ,Object> getUserMap();

    /**
     * 根据id查询用户信息为一个map集合
     */
    Map<String ,Object> getUserByIdToMap(@Param("id") Integer id);
    /**
     * 查询用户信息的总记录数
     */
    Integer getCount();
    /**
     * 查询一个实体类对象
     */
    List<User> getUserById(@Param("id") Integer id);

    /**
     * 查询所有用户信息
     */
    List<User> getAllUser();
}
