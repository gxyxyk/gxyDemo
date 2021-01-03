package com.controller;

import com.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("account")
public class AccountController {
    @Autowired
    private IAccountService accountService;
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        System.out.println("表现层查找所有用户！");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",accountService.fineAll());
        modelAndView.setViewName("list");
        return modelAndView;
    }
}
