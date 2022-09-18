package com.shenbaoyun.mybatis.test;

import com.shenbaoyun.mybatis.mapper.SqlMapper;
import com.shenbaoyun.mybatis.pojo.User;
import com.shenbaoyun.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author shenbaoyun
 * @create 2022-09-18 13:02
 */
public class SqlMapperTest {
    @Test
    public void insertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SqlMapper mapper = sqlSession.getMapper(SqlMapper.class);
        User user = new User(null,"zhangsan","123456",22,"男","4399@163.com");
        mapper.insertUser(user);
        System.out.println(user);
    }
    @Test
    public void getUserByTableName(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SqlMapper mapper = sqlSession.getMapper(SqlMapper.class);
        System.out.println(mapper.getUserByTableName("t_user"));
    }
    @Test
    public void deleteMore(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SqlMapper mapper = sqlSession.getMapper(SqlMapper.class);
        int i = mapper.deleteMore("3,4");
        System.out.println(i);
    }

    @Test
    public void getUserByLike(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SqlMapper mapper = sqlSession.getMapper(SqlMapper.class);
        List<User> user = mapper.getUserByLike("a");
        user.forEach(user1 -> System.out.println(user1));
    }
}
