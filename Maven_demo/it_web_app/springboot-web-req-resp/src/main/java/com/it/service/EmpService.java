package com.it.service;

import com.it.pojo.Emp;
import org.springframework.stereotype.Component;

import java.util.List;

public interface EmpService {
    public List<Emp> listEmp();
}
