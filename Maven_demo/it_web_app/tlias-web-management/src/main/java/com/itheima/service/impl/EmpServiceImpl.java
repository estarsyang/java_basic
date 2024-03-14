package com.itheima.service.impl;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    @Override
    public PageBean page(Integer page, Integer pageSize) {

//        get count
        Long count = empMapper.count();

//        get List<Emp>
        Integer start = (page -1)*pageSize;
        List<Emp> empList =  empMapper.page(start, pageSize);

        return new PageBean(count, empList);
    }
}
