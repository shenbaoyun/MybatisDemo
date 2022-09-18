package com.shenbaoyun.mybatis.mapper;

import com.shenbaoyun.mybatis.pojo.Dept;
import com.shenbaoyun.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author shenbaoyun
 * @create 2022-09-18 14:08
 */
public interface EmpMapper {

    /**
     * 通过分步查询查询部门以及部门中所有员工信息
     * 分步查询第二步，根据did查询员工信息
     */
    List<Emp> getDeptAndEmpByStepTwo(@Param("did") Integer did);


    /**
     * 通过分步查询查询员工以及员工所对应的部门信息
     * 分步查询第一步 查询员工信息
     */
    Emp getEmpAndDeptByStepOne(@Param("eid") Integer eid);


    /**
     * 查询员工以及员工所对应的部门信息
     */
    Emp getEmpAndDept(@Param("eid") Integer eid);

    /**
     * 查询所有的员工数据
     */
    List<Emp> getAllEmp();

}
