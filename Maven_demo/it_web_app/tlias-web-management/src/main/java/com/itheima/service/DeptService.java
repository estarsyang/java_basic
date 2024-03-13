package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {

    /**
     * 查询全部部门数据
     * @return
     */
    List<Dept> list();

    /**
     * 删除部门
     */
    void delete(Integer id);

    void add(Dept dept);

    void update(Dept dept);

    Dept deptById(Integer id);
}
