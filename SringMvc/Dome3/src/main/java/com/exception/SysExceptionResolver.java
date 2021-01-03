package com.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SysExceptionResolver implements HandlerExceptionResolver {
    /**
     * 跳转到矩替的错误页面的方法
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {
       //捕获异常
        ex.printStackTrace();
        SysException exception = null;
        //获取到异常对象
        if (ex instanceof  SysException){
            exception=(SysException) ex;
        }else{
            exception = new SysException("请联系管理员！");
        }
        ModelAndView mv = new ModelAndView();
        //存入错误的提示信息
        mv.addObject("message", exception.getMessage());
        //跳转的Jsp页面
        mv.setViewName("error");
        return mv;
    }
}
