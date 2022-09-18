package com.shenbaoyun.mybatis.test;

import com.shenbaoyun.mybatis.mapper.ParameterMapper;
import com.shenbaoyun.mybatis.pojo.User;
import com.shenbaoyun.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shenbaoyun
 * @create 2022-09-18 10:11
 * Mybatis获取参数值的两种方式：${}    和   #{}
 * ${}  本质字符串拼接
 * #{}  占位符
 * mybatis获取参数值的各种情况
 * 1 mapper接口方法的参数为单个的字面量类型
 * 可以通过 ${}  和 #{}  以任意名称获取参数值，但是需要注意    ${} 的单引号问题
 * 2 mapper接口方法的参数为多个时
 * 此时mybatis会将这些参数放在一个map接货中，以两种方式进行存储
 * a--以arg0，agr1为键，以参数为值
 * b--以param1，param2为键，以参数为值
 * 3 若mapper接口方法的参数有多个时，可以手动将这些参数放入map集合中存储
 * 只需要通过 ${}  和 #{} 以键的方式访问即可
 * 4 如果mapper接口方法的参数是一个实体类类型的参数
 * 只需要通过    #{属性名}  以属性的方式访问属性值
 * 5 命名参数 使用@param注解命名参数
 * 此时mybatis会将这些参数放在一个map集合中，以两种方式进行存储
 * a--以@param注解的值为键，以参数为值
 * b--以param1，param2为键，以参数为值
 */
public class ParameterMapperTest {
    @Test
    public void testCheckLoginByParam(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLoginByParam("王八", "123456");
        System.out.println(user);
    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        int i = mapper.insertUser(new User(null, "王八", "123456", 18, "男", "wangba@163.com"));
        System.out.println(i);
    }

    @Test
    public void testCheckLoginByMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String ,Object> map = new HashMap<>();
        map.put("username","admin");
        map.put("password","123456");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }

    @Test
    public void testCheckLogin(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLogin("admin", "123456");
        System.out.println(user);
    }

    @Test
    public void testGetUserByUsername(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User userByUSerName = mapper.getUserByUSerName("admin");
        System.out.println(userByUSerName);
    }


    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> li = mapper.getAllUser();
        li.forEach(user -> System.out.println(user));


    }
}
