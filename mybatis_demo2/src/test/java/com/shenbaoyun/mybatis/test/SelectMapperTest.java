package com.shenbaoyun.mybatis.test;

import com.shenbaoyun.mybatis.mapper.SelectMapper;
import com.shenbaoyun.mybatis.pojo.User;
import com.shenbaoyun.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author shenbaoyun
 * @create 2022-09-18 12:29
 *
 * mybatis的各种查询功能
 * 1 若查询出的数据只有一条，
 * a-->可以通过实体类对象接收
 * b-->可以通过list集合接收
 * c-->可以通过map集合接收
 * 2 若查询出的数据有多条，
 * a-->可以通过list集合接收
 * b-->可以通过map类型的list集合接收
 * c-->可以通过在mapper接口的方法上添加@mapKey()注解，就可以将每条数据转换为map集合作为值
 * 以某个字段的值作为键，放在同一个map集合里
 * 注意：一定不能通过实体类对象接收，会跑异常TooManyResultsException
 *
 *
 */
public class SelectMapperTest {
    @Test
    public void getUserMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserMap());
    }

    @Test
    public void getUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> userByIdToMap = mapper.getUserByIdToMap(6);
        System.out.println(userByIdToMap);
    }

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
