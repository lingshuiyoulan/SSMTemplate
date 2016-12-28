package com.cj.service.impl;

import com.cj.dao.DeptDao;
import com.cj.domain.Dept;
import com.cj.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    public List<Dept> findAllDepts() {
        return deptDao.selectAll();
    }
}
