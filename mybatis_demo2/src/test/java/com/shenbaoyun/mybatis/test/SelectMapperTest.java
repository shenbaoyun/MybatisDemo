package com.shenbaoyun.mybatis.test;

import com.shenbaoyun.mybatis.mapper.SelectMapper;
import com.shenbaoyun.mybatis.pojo.User;
import com.shenbaoyun.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author shenbaoyun
 * @create 2022-09-18 12:29
 *
 * mybatis的各种查询功能
 * 1 若查询出的数据只有一条，
 * a-->可以通过实体类对象接收
 * b-->可以通过list集合接收
 * c-->
 * 2 若查询出的数据有多条，
 *a-->可以通过list集合接收
 * b-->
 * 注意：一定不能通过实体类对象接收，会跑异常TooManyResultsException
 *
 *
 */
public class SelectMapperTest {
    @Test
    public void getCount(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer count = mapper.getCount();
        System.out.println(count);
    }
    @Test
    public void getAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(user -> System.out.println(user));
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> userById = mapper.getUserById(6);
        System.out.println(userById);
    }
}
