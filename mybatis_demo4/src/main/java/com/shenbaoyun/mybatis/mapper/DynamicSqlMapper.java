package com.shenbaoyun.mybatis.mapper;

import com.shenbaoyun.mybatis.pojo.Emp;

import java.util.List;

/**
 * @author shenbaoyun
 * @create 2022-09-18 16:36
 */
public interface DynamicSqlMapper {

    /**
     * 多条件查询
     */
    List<Emp>  getEmpByCondition(Emp emp);

    /**
     * 测试choose whern otherwise
     */
    List<Emp> getEmpByChoose(Emp emp);
}
