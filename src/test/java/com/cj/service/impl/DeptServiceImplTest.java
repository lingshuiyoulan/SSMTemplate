package com.cj.service.impl;

import com.cj.service.DeptService;
import com.cj.utils.SpringJunitTestUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by lanling on 2017/1/15.
 */
public class DeptServiceImplTest extends SpringJunitTestUtil{

    @Autowired
    private DeptService deptService;

    @Test
    public void findAllDepts() throws Exception {
        System.out.println(deptService.findAllDepts());
    }
}