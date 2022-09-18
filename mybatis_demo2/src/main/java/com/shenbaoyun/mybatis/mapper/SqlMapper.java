package com.shenbaoyun.mybatis.mapper;

import com.shenbaoyun.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author shenbaoyun
 * @create 2022-09-18 12:59
 */
public interface SqlMapper {
    /**
     * 添加用户信息
     */
    void insertUser(User user);

    /**
     * 查询指定表中的数据
     */
    List<User> getUserByTableName(@Param("tablename") String tablename);
    /**
     * 根据批量删除
     */
    int deleteMore(@Param("ids") String ids);

    /**
     * 根据用户名模糊查询用户信息
     */
    List<User> getUserByLike(@Param("username") String username);
}
