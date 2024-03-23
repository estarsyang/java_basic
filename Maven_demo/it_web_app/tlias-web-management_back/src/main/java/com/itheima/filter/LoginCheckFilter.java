package com.itheima.filter;

import com.alibaba.fastjson.JSONObject;
import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;

@Slf4j
//@WebFilter("/*")
public class LoginCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

//        1. get url
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String url = request.getRequestURL().toString();
        log.info("url is {}", url);

//        2. check is login
        if (url.contains("login")){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

//        3. get jwt
        String jwt = request.getHeader("token");

//        4. check jwt is correct or not
        if (!StringUtils.hasLength(jwt)){
            log.info("header no token value");
            Result error = Result.error("Not_Login");
//            object to json, using fastJSON
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return;
        }

//        5. parse token
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) { // parse error
            Result error = Result.error("Not_Login");
//            object to json, using fastJSON
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return;

        }

//        6. pass request
        filterChain.doFilter(request,response);
    }
}
