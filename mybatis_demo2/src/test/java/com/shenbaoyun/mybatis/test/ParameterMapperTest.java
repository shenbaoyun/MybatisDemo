package com.shenbaoyun.mybatis.test;

import com.shenbaoyun.mybatis.mapper.ParameterMapper;
import com.shenbaoyun.mybatis.pojo.User;
import com.shenbaoyun.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author shenbaoyun
 * @create 2022-09-18 10:11
 */
public class ParameterMapperTest {
    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> li = mapper.getAllUser();
        li.forEach(user -> System.out.println(user));


    }
}
