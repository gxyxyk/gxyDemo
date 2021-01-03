package com.controller;


import com.pojo.Address;
import com.pojo.User;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/testString")
    public String testString(Model model){
        User user = new User();
        user.setAge(11);
        user.setName("张三");
        user.setUid(2);
        model.addAttribute("user",user);
        return "aa";
    }
    @RequestMapping("/initAdd")
    public void initAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("请求转发或者重定向");
        //请求转发
        //request.getRequestDispatcher("/WEB-INF/pages/add.jsp").forward(request response)
        //重定向
        //response.setdRedirect(request.getContextPath()+"/add2.jsp");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //直接响应数据
        response.getWriter().print("你好");
    }
    @RequestMapping("/initAdd1")
    public void initAdd1(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("请求转发");
//        请求转发
        request.getRequestDispatcher("/WEB-INF/page/add.jsp").forward(request,response);
        //重定向
        //response.setdRedirect(request.getContextPath()+"/add2.jsp");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //直接响应数据
//        response.getWriter().print("你好");
    }
    @RequestMapping("/initAdd2")
    public void initAdd2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("请求重定向");
        //请求转发
        //request.getRequestDispatcher("/WEB-INF/pages/add.jsp").forward(request response)
        //重定向
        response.sendRedirect(request.getContextPath()+"/add2.jsp");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //直接响应数据
//        response.getWriter().print("你好");
    }
    @RequestMapping(value = "findAll")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        //跳转到list.jsp
        mv.setViewName("aa");
        //模拟从数据库中查询所有的用户信息User
        User user = new User();
        user.setAge(11);
        user.setName("张三");
        user.setUid(2);
        mv.addObject("user",user);
        return mv;
    }


    /**
     *使用forward关键字进行请求转发
     *"forward:转发的JSP路径"，不走视图解析器了，所以需要编写完整的路径
     *@return
     *@throws Exception
     */
    @RequestMapping("/delete")
    public String delete()throws Exception{
        System.out.println("delete方法执行了。。。");
        return "forward:/user/findAll";
    }
    @RequestMapping("/count")
    public String count()throws Exception{
        System.out.println("count方法执行了...");
        return "redirect:page/add.jsp";
    }

    /**
     * 获取请求体数据
     * @param
     */
    @RequestMapping("/testJson")
    public @ResponseBody Address testJson(@RequestBody Address address) throws Exception{
        System.out.println(address.toString());
        address.setAddressName("上海！");
        return address;
    }

    /**
     * springMvc方式的文件上传
     * @param request
     * @param upload
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/fileupload")
    public String fileuplosd2(HttpServletRequest request, MultipartFile upload)throws Exception{
        System.out.println("SpringMVC方式的文件上传！");
        //先获取到要上传的文件目录
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        //创建File对象，一会向该路径下上传文件
        File file = new File(path);
        //判断路劲是否存在，如果不存在，创建路劲
        if (!file.exists()){
            file.mkdirs();
        }
        //获取上传文件的名称
        //文件在apache-tomcat-8.5.31\webapps\ROOT
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replaceAll("-","").toUpperCase();
        System.out.println(uuid);
        upload.transferTo(new File(file,filename));
        return "success";
    }
    @RequestMapping("/excption")
    public ModelAndView excptionTest(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("excption");
        Address address = new Address();
        address.setAddressNum(0);
//        int a = 2/0;
        modelAndView.addObject("address",address);
        return modelAndView;
    }
}
