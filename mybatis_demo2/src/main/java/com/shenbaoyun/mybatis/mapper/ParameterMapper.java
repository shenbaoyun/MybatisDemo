package com.shenbaoyun.mybatis.mapper;

import com.shenbaoyun.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;

/**
 * 以功能划分表
 * @author shenbaoyun
 * @create 2022-09-18 10:02
 */
public interface ParameterMapper {


    /**
     * 验证登录(使用@param)
     */
    User checkLoginByParam(@Param("username") String usermane, @Param("password") String password);

    /**
     * 添加一个用户信息
     */
    int insertUser(User user);
    /**
     * 验证登录(参数为map)
     */
    User checkLoginByMap(Map<String,Object> map);

    /**
     * 验证登录（通过用户名和密码）
     */
    User checkLogin(String username,String password);

    /**
     * 根据用户名查询用户信息
     */
    User getUserByUSerName(String username);


    /**
     * 查询所有的员工信息
     */
    List<User> getAllUser();
}
