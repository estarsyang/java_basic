package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理Controller
 */
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

//    引入 service
    @Autowired
    private DeptService deptService;

    /**
     * query all depts
     * @return Result
     */
    @GetMapping()
    public Result list(){

        log.info("查询部门所有数据");

//        调用service查询部门数据
        List<Dept> deptList =  deptService.list();

        return Result.success(deptList);
    }


    @GetMapping("/{id}")
    public Result deptById(@PathVariable Integer id){

        Dept dept = deptService.deptById(id);

        return Result.success(dept);
    }
    /**
     * 删除 部门
     * @param id id
     * @return Result
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){

        log.info("id is: {}", id);
        deptService.delete(id);

        return Result.success();
    }

    /**
     * add new dept
     * @param dept
     * @return
     */
    @PostMapping()
    public Result add(@RequestBody Dept dept){
        log.info("新增部门:{}", dept);

        deptService.add(dept);
        return Result.success();
    }

    /**
     * update dept
     * @param dept
     * @return Result
     */
    @PutMapping()
    public Result update(@RequestBody Dept dept){

        deptService.update(dept);

        return Result.success();

    }
}
