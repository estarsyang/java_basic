package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
public interface EmpService {
    public PageBean page(Integer page,
                         Integer pageSize,
                         String name,
                         Short gender,
                         LocalDate begin,
                         LocalDate end);

    void delete(List<Integer> ids);

    void save(Emp emp);

    /**
     * get emp by id
     * @param id
     * @return
     */
    Emp getById(Integer id);

    void update(Emp emp);


    /**
     * emp login
     * @param emp
     * @return
     */
    Emp login(Emp emp);
}
