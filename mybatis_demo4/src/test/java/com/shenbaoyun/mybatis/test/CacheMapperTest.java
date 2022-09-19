package com.shenbaoyun.mybatis.test;

import com.shenbaoyun.mybatis.mapper.CacheMapper;
import com.shenbaoyun.mybatis.pojo.Emp;
import com.shenbaoyun.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * mybatis 一级缓存 sqlSession级别
 * 在同一个SQLSession被查询出来的数据会被缓存
 * @author shenbaoyun
 * @create 2022-09-19 9:12
 */
public class CacheMapperTest {


    @Test
    public void testCache(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        long start = System.currentTimeMillis();
        Emp empByEid = mapper.getEmpByEid(1);
        long end = System.currentTimeMillis();
        System.out.println(empByEid);
        System.out.println("查询时间为:"+(end-start));
        System.out.println("****************************************");

        //执行查询操作，导致缓存失效
        mapper.insertEmp(new Emp(null,"神仙",99,"无","asdasds"));




        long start1 = System.currentTimeMillis();
        Emp empByEid1 = mapper.getEmpByEid(1);
        long end1 = System.currentTimeMillis();
        System.out.println(empByEid1);
        System.out.println("查询时间为:"+(end1-start1));
    }

    @Test
    public void teCache() {
        //1 加载核心配置文件,获取字节输入流
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            long start1 = System.currentTimeMillis();
            SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
            CacheMapper mapper = sqlSession1.getMapper(CacheMapper.class);
            Emp empByEid1 = mapper.getEmpByEid(5);
            long end1 = System.currentTimeMillis();
            System.out.println(empByEid1);
            sqlSession1.close();
            System.out.println("查询时间为:"+(end1-start1));

            System.out.println("*******************************************");

            long start2 = System.currentTimeMillis();
            SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
            CacheMapper mapper1 = sqlSession2.getMapper(CacheMapper.class);
            Emp empByEid2 = mapper1.getEmpByEid(5);
            System.out.println(empByEid2);
            sqlSession2.close();
            long end2 = System.currentTimeMillis();
            System.out.println("查询时间为:"+(end2-start2));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
