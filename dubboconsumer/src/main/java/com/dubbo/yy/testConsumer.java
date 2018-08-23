package com.dubbo.yy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testConsumer {
    public static void main( String[] args )
    {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("consumer.xml");
        ((ClassPathXmlApplicationContext) applicationContext).start();
        UserService userService= (UserService) applicationContext.getBean("permissionService",UserService.class);
        System.out.println(userService.sayHello());
    }
}
