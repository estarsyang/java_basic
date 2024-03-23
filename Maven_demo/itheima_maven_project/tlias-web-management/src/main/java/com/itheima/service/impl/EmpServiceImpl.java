package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    /*
    @Override
    public PageBean page(Integer page, Integer pageSize) {

//        get count
        Long count = empMapper.count();

//        get List<Emp>
        Integer start = (page -1)*pageSize;
        List<Emp> empList =  empMapper.page(start, pageSize);

        return new PageBean(count, empList);
    }
     */

    //    using pageHelper
    @Override
    public PageBean page(Integer page,
                         Integer pageSize,
                         String name,
                         Short gender,
                         LocalDate begin,
                         LocalDate end) {

//        setting pagination params
        PageHelper.startPage(page, pageSize);

//        run query
        List<Emp> empList = empMapper.list(name,gender,begin,end);

//      查询数据
        Page<Emp> p = (Page<Emp>) empList;
        long total = p.getTotal();
        List<Emp> result = p.getResult();

        PageBean pageBean = new PageBean(total,result);


        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {

        empMapper.delete(ids);
    }

    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.insert(emp);
    }

    @Override
    public Emp getById(Integer id) {
        return empMapper.getById(id);
    }

    @Override
    public Emp login(Emp emp) {
        return empMapper.getByUsernameAndPassword(emp);

    }

    @Override
    public void update(Emp emp) {

        emp.setUpdateTime(LocalDateTime.now());

        empMapper.update(emp);

    }
}
