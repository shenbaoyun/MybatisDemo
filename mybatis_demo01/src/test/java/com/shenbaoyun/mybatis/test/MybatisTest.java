package com.shenbaoyun.mybatis.test;

import com.shenbaoyun.mybatis.mapper.UserMapper;
import com.shenbaoyun.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author shenbaoyun
 * @create 2022-09-17 14:35
 */
public class MybatisTest {

    @Test
    public void testMybatisCRUD() throws IOException {
        //1 加载核心配置文件----指定配置文件名
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //2 获取sqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //3 获取sqlSession工厂类对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //4 获取mybatis的sqlsession     sqlSessionFactory.openSession(true)自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //5 获取Mapper接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //6 测试功能
/*
        //修改功能
        mapper.updateUser();
        //删除功能
        mapper.delUser();
        //增加功能
        int result = mapper.insertUser();
        System.out.println("result:"+result);

        User user = mapper.getUserById();
        System.out.println(user);
*/
        List<User> user = mapper.getUser();
        System.out.println(user);
        user.forEach(user1 -> System.out.println(user1));

    }

    /**
     * sqlsession默认不自动提交事务，如果自动提交
     * 可以使用sqlSessionFactory.openSession(true)
     * @throws IOException
     */
    @Test
    public void testMybatis() throws IOException {
        //1 加载核心配置文件----指定配置文件名
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //2 获取sqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //3 获取sqlSession工厂类对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //4 获取mybatis的sqlsession     sqlSessionFactory.openSession(true)自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //5 获取Mapper接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //6 测试功能

        //7 提交事务
        //sqlSession.commit();



    }
}
