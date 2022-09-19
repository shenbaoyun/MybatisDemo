package com.shenbaoyun.mybatis.test;

import com.shenbaoyun.mybatis.mapper.DynamicSqlMapper;
import com.shenbaoyun.mybatis.pojo.Emp;
import com.shenbaoyun.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shenbaoyun
 * @create 2022-09-18 16:43
 *
 * 动态SQL
 * 1 if 根据标签中的test属性所对应的表达式决定标签中的内容是否需要拼接到SQL中
 * 2 当where标签中有内容时，会自动生成where关键字，并且将内容前多余的and或or去掉，
 *   当where标签没有内容时，此时where标签不会生成where关键字
 * 3 trim
 * prefix|suffix  将trim标签中前面或后面添加指定内容
 * prefixOverrides|suffixOverrides  将trim标签中前面或后面去除指定内容
 * 4 choose whern otherwise 相当于java里的if else if
 * choose 父标签 whern otherwise都要在choose标签里面
 * 5 foreach
 * collection：设置需要循环的数组或集合
 * item：表示数组或集合中的每一个数据
 * separator：循环体之间的分隔符
 * open：foreach标签所循环的所有内容的开始符  一般情况下用 in
 * close：foreach标签所循环的所有内容的结束符
 * 6 sql标签
 */
public class DynamicSQLMapperTest {
    @Test
    public void testInsertMoreByList(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        Emp emp1 = new Emp(null,"王二麻子",29,"中","asdas@163.com");
        Emp emp2 = new Emp(null,"王san麻子",28,"中","asdas@163.com");
        Emp emp3 = new Emp(null,"王si麻子",27,"中","asdas@163.com");
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3);
        mapper.insertMoreByList(emps);
    }
    @Test
    public void testDeleteMoreByArray(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        int i = mapper.deleteMoreByArray(new Integer[]{7,8,9,10,11});
        System.out.println(i);
    }
    @Test
    public void testGetEmpByChoose(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        List<Emp> list = mapper.getEmpByChoose(new Emp(null, "n", 25, "男", ""));
        System.out.println(list);
    }

    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
        long start1 = System.currentTimeMillis();
        List<Emp> list1 = mapper.getEmpByCondition(new Emp(null, null, 25, "", ""));
        long end1 = System.currentTimeMillis();
        System.out.println(list1);
        System.out.println("查询时间为:"+(end1-start1));
        System.out.println("*************************");
        long start2 = System.currentTimeMillis();
        List<Emp> list2 = mapper.getEmpByCondition(new Emp(null, null, 25, "", ""));
        long end2 = System.currentTimeMillis();
        System.out.println("查询时间为:"+(end2-start2));
        System.out.println(list2);

    }
}
