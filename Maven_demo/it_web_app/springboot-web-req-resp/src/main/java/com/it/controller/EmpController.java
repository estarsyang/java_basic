package com.it.controller;

import com.it.pojo.Emp;
import com.it.pojo.Result;
import com.it.service.EmpService;
import com.it.service.impl.EmpServiceA;
import com.it.utils.XmlParserUtils;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {
//    @Qualifier("empServiceB")
//    @Autowired
    @Resource(name = "empServiceB")
    private EmpService empService;

    @RequestMapping("/listEmp")
    public Result list() {

        // 1. 2.  加载数据并处理
        List<Emp> empList = empService.listEmp();

        // 3. 返回响应
        return Result.success(empList);

        /*
        // 1. 加载数据
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);

        // 2. 处理数据
        empList.stream().forEach(emp -> {
            //  1: 男, 2: 女
            String gender = emp.getGender();
            if ("1".equals(gender)){
                emp.setGender("男");
            } else if ("2".equals(gender)) {
                emp.setGender("女");
            }

            // 1: 讲师, 2: 班主任 , 3: 就业指导
            String job = emp.getJob();
            if ("1".equals(job)){
                emp.setJob("讲师");
            } else if ("2".equals(job)) {
                emp.setJob("班主任");
            } else if ("3".equals(job)) {
                emp.setJob("就业指导");
            }

        });
         */
    }

}
