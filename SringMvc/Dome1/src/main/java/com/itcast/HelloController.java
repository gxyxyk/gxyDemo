package com.itcast;

import com.entity.Items;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * 控制器
 */
@Controller
public class HelloController {

    /**
     * 接受请求
     * @return
     */
    @RequestMapping(path = "/hello")
    public String sayHelloe(){
        System.out.println("Hello SpringMvc！！");
        return "success";
    }
    @RequestMapping("/itemList")
    public ModelAndView itemList(){
        List<Items> items = new ArrayList<>();
        Items items1 = new Items();
        Items items2 = new Items();
        Items items3 = new Items();
        items1.setName("联想笔记本_3");
        items1.setPrice(6000f);
        items1.setDetail("ThinkPad T430 联想笔记本电脑!");
        items2.setName("小米手机");
        items2.setPrice(500f);
        items2.setDetail("红米9");
        items3.setName("东芝硬盘");
        items3.setPrice(200f);
        items3.setDetail("500G机械硬盘");
        items.add(items1);
        items.add(items2);
        items.add(items3);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemList",items);
        modelAndView.setViewName("jsp/itemList");
        return modelAndView;
    }
}
