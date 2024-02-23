package com.it.service.impl;

import com.it.dao.EmpDao;
import com.it.dao.impl.EmpDaoA;
import com.it.pojo.Emp;
import com.it.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

//@Primary
@Service
public class EmpServiceA implements EmpService {

    @Autowired
    private EmpDao empDao;

    @Override
    public List<Emp> listEmp() {
        // 1. 调用dao，获取数据
        List<Emp> empList = empDao.listEmp();

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

        return empList;
    }
}
