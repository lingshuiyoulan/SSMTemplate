package com.cj.dao;

import com.cj.domain.Dept;

import java.util.List;

public interface DeptDao {
    int deleteByPrimaryKey(Integer deptno);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer deptno);

    List<Dept> selectAll();

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
}