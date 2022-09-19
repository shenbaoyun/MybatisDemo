package com.shenbaoyun.mybatis.mapper;

import com.shenbaoyun.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * 缓存只对查询有效
 * @author shenbaoyun
 * @create 2022-09-19 9:09
 */
public interface CacheMapper {
    Emp getEmpByEid(@Param("eid") Integer eid);

    void insertEmp(Emp emp);
}
