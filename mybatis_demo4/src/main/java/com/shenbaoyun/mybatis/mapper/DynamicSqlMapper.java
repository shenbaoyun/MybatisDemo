package com.shenbaoyun.mybatis.mapper;

import com.shenbaoyun.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 通过数组实现批量删除
     */
    int deleteMoreByArray(@Param("eids") Integer[] eids);

    /**
     * 通过list集合实现批量添加
     */
    int insertMoreByList(@Param("emps") List<Emp> emps);
}
