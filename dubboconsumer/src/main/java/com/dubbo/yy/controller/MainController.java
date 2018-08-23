package com.dubbo.yy.controller;

import com.dubbo.yy.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/3")
public class MainController {
//@RequestMapping(value = "/4")
@RequestMapping(method = RequestMethod.GET)
    public ModelAndView dataAll(){
    ApplicationContext applicationContext=new ClassPathXmlApplicationContext("consumer.xml");
    ((ClassPathXmlApplicationContext) applicationContext).start();
    UserService userService= (UserService) applicationContext.getBean("permissionService",UserService.class);
    ModelAndView view=new ModelAndView();
    view.addObject("yys",userService.sayHello());
    view.setViewName("index");
    return view;
    }
}

