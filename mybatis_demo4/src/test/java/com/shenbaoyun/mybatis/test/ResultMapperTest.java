package com.shenbaoyun.mybatis.test;


import com.shenbaoyun.mybatis.mapper.DeptMapper;
import com.shenbaoyun.mybatis.mapper.EmpMapper;
import com.shenbaoyun.mybatis.pojo.Dept;
import com.shenbaoyun.mybatis.pojo.Emp;
import com.shenbaoyun.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author shenbaoyun
 * @create 2022-09-18 14:34
 *
 * 处理多对一的映射关系
 * 1
 */
public class ResultMapperTest {

    @Test
    public void getDeptAndEmpByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpByStepOne(1);
        System.out.println(dept.getDeptName());

    }

    @Test
    public void getDeptAndEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmp(1);
        System.out.println(dept);

    }

    @Test
    public void getEmpAndDeptByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByStepOne(1);
        System.out.println(emp.getEmpName());
        System.out.println("*****************************************");
        System.out.println(emp.getDept());
    }

    /**
     * 处理多对一的映射关系
     * 1 级联属性赋值
     * 2 association
     * 3 分步查询
     */
    @Test
    public void getEmpAndDept(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDept(1);
        System.out.println(emp);
    }

    @Test
    public void getAllEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> list = mapper.getAllEmp();
        list.forEach(emp -> System.out.println(emp));
    }


}
