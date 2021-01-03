package com.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 */
public class MyInterceptor2 implements HandlerInterceptor {
    /**
     * 可以使用转发或者重定向直接跳转到指定的页面
     * @param request true放行
     * @param response false拦截
     * @return
     * 可以使用转发或者重定向直接跳转到指定的页面
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        System.out.println("拦截器执行了1....");
        return true;
    }
}
