package com.cj.dao;

import com.cj.utils.SpringJunitTestUtil;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by lanling on 2017/1/15.
 */
public class DeptDaoTest extends SpringJunitTestUtil {
    @Resource
    private DeptDao deptDao;

    @Test
    public void deleteByPrimaryKey() throws Exception {

    }

    @Test
    public void insert() throws Exception {

    }

    @Test
    public void insertSelective() throws Exception {

    }

    @Test
    public void selectByPrimaryKey() throws Exception {

    }

    @Test
    public void selectAll() throws Exception {
        System.out.println(deptDao.selectAll());
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {

    }

    @Test
    public void updateByPrimaryKey() throws Exception {

    }

}