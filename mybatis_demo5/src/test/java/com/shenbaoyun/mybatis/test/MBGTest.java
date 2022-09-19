package com.shenbaoyun.mybatis.test;

import com.github.pagehelper.PageHelper;
import com.shenbaoyun.mybatis.mapper.EmpMapper;
import com.shenbaoyun.mybatis.pojo.Emp;
import com.shenbaoyun.mybatis.pojo.EmpExample;
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
 * @create 2022-09-19 10:40
 */
public class MBGTest {
    @Test
    public void testMBG(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            /**
             * limit index.pagesize
             * index 当前页的起始索引
             * pageSize：每页显示的条数
             * pageNum 当前页的页码
             * index=(pageNum-1)*pageSize
             */

            PageHelper.startPage(2,4);
            List<Emp> li = mapper.selectByExample(null);
            li.forEach(list -> System.out.println(list));
            /*
            根据条件查询
             */
//            EmpExample empExample = new EmpExample();
//            empExample.createCriteria().andEmpNameLike("三");
//            System.out.println(mapper.selectByExample(empExample));


            /*
            查询所有数据
            List<Emp> emps = mapper.selectByExample(null);
            emps.forEach(list -> System.out.println(list));

             */
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
