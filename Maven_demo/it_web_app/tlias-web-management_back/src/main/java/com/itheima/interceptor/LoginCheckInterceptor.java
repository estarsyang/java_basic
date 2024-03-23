package com.itheima.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle ....");

        //        1. get url
        String url = request.getRequestURL().toString();
        log.info("url is {}", url);

//        2. check is login
        if (url.contains("login")){
            return true;
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
            return false;
        }

//        5. parse token
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) { // parse error
            Result error = Result.error("Not_Login");
//            object to json, using fastJSON
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;

        }

//        6. pass request
        return true;
    }
}
