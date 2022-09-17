package com.shenbaoyun.mybatis.mapper;

/**
 * @author shenbaoyun
 * @create 2022-09-17 14:21
 */

import com.shenbaoyun.mybatis.pojo.User;

import java.util.List;

/**
 * Myabtis面向接口编程的两个一致
 * 1 Mapper接口要与映射文件的namespace名称一致
 * 2 映射文件中 SQL语句的id要与mapper接口中的方法名一致
 *
 * 表---实体类----Mapper接口----映射文件
 */
public interface UserMapper {
    /**
     * 添加用户信息
     */
    int insertUser();

    /**
     * 修改用户信息
     */
    void updateUser();
    /**
     * 删除用户信息
     */
    void delUser();
    /**
     * 根据id查询用户信
     */
    User getUserById();
    /**
     * 查询所有结果集
     */
    List<User> getUser();

}
