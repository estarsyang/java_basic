package com.it.dao.impl;

import com.it.dao.EmpDao;
import com.it.pojo.Emp;
import com.it.utils.XmlParserUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Component
public class EmpDaoA implements EmpDao {

    @Override
    public List<Emp> listEmp() {
        // 1. 加载数据
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);

        return empList;
    }
}
