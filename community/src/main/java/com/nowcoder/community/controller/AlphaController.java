package com.nowcoder.community.controller;

import com.nowcoder.community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/alpha")
public class AlphaController {
    @Autowired
    private AlphaService alphaService;
    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "Hello Spring!";
    }

    @RequestMapping("/Data")
    @ResponseBody
    public String getData(){
        return alphaService.find();
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        //获取请求数据
        System.out.println("httpServletRequest: "+httpServletRequest.toString());
        System.out.println("getMethod:"+httpServletRequest.getMethod());
        Enumeration<String> enumeration = httpServletRequest.getHeaderNames();
        while(enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = httpServletRequest.getHeader(name);
            System.out.println(name+" "+value);
        }
        System.out.println("code: "+httpServletRequest.getParameter("code"));
        //返回响应数据
        httpServletResponse.setContentType("text/html:charset=utf-8");
        try(PrintWriter printWriter = httpServletResponse.getWriter()){
            printWriter.write("Hello");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //GET请求
    @RequestMapping(path = "/students",method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(
            @RequestParam(name = "current",required = false,defaultValue = "1")int current,
            @RequestParam(name = "limit",required = false,defaultValue = "10")int limit
    ){
        System.out.println("current:"+current);
        System.out.println("limit:"+limit);
        return "Some students";
    }
    //GET请求
    @RequestMapping(path = "/student/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String getStudentsId(
            @PathVariable("id") int id
    ){
        System.out.println(id);
        return "studentId";
    }
    //POST请求
    @RequestMapping(path = "/student",method = RequestMethod.POST)
    @ResponseBody
    public String getStudent(String name,int age){
        System.out.println(name);
        System.out.println(age);
        return "a student";
    }
    //响应数据
    @RequestMapping(path = "/teacher",method = RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","CarJ");
        modelAndView.addObject("age","age");
        modelAndView.setViewName("demo/view");
        return modelAndView;
    }

    @RequestMapping(path = "/school",method = RequestMethod.GET)
    public String getSchool(Model model){
        model.addAttribute("name","中山大学");
        model.addAttribute("age","80");
        return "demo/view";
    }


    @RequestMapping(path = "/emp",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getEmp(){
        Map<String,Object> emp = new HashMap<>();
        emp.put("name","CarJ");
        emp.put("age:",24);
        return emp;
    }

}
