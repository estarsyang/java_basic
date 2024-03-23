package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import com.itheima.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){

        log.info("emp is {}", emp);
        Emp e = empService.login(emp);

        if (e != null){
//            prepare userinfo
            Map<String, Object> claims = new HashMap<>();

            claims.put("id", e.getId());
            claims.put("name", e.getName());
            claims.put("username", e.getUsername());
//            generate jwt
            String jwt = JwtUtils.generateJwt(claims);

            return Result.success(jwt);

        }

        return Result.error("username or password error");
    }
}
