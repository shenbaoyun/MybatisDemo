package com.shenbaoyun.mybatis.mapper;

import com.shenbaoyun.mybatis.pojo.User;

import java.util.List;

/**
 * 以功能划分表
 * @author shenbaoyun
 * @create 2022-09-18 10:02
 */
public interface ParameterMapper {
    /**
     * 查询所有的员工信息
     */
    List<User> getAllUser();
}
