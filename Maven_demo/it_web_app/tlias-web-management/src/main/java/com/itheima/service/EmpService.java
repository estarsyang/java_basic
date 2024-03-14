package com.itheima.service;

import com.itheima.pojo.PageBean;

/**
 * 员工管理
 */
public interface EmpService {
    public PageBean page(Integer page, Integer pageSize);
}
