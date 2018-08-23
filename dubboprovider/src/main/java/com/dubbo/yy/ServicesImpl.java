package com.dubbo.yy;

import com.dubbo.yy.Hibernate.HibernateT;
import com.dubbo.yy.RedisConfig.RedisConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


public class ServicesImpl implements UserService {
    public String sayHello(){
       // System.out.println("hello world!!!");
       // ApplicationContext context=new ClassPathXmlApplicationContext("Spring.xml");
        ApplicationContext context=new AnnotationConfigApplicationContext(RedisConfig.class);
        //ApplicationContext context1= new ClassPathXmlApplicationContext();
        HibernateT hibernateT= (HibernateT) context.getBean("RedisDao");
        // StringRedisTemplate srt=(StringRedisTemplate) context.getBean("stringredistemplate");
        //HibernateT hibernateT=new HibernateT();
        hibernateT.init();
        long starttime=System.currentTimeMillis();
        String message=hibernateT.testG();
        //System.out.println(hibernateT.testG());
        long endtime=System.currentTimeMillis();
       // System.out.println("运行的时间为："+(endtime-starttime)+"ms");
        // hibernateT.testG();
        hibernateT.destory();
        return message;
    }
}
