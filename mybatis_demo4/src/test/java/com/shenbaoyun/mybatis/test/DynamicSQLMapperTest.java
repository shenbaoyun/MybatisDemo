package com.shenbaoyun.mybatis.test;

import com.shenbaoyun.mybatis.mapper.DynamicSqlMapper;
import com.shenbaoyun.mybatis.pojo.Emp;
import com.shenbaoyun.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

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
 */
public class DynamicSQLMapperTest {
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
        List<Emp> list = mapper.getEmpByCondition(new Emp(null, null, 25, "", ""));
        System.out.println(list);
    }
}
