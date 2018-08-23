package com.dubbo.yy;

import com.dubbo.yy.Hibernate.HibernateT;
import com.dubbo.yy.RedisConfig.RedisConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;

public class testrun {
    public static void main( String[] args )
    {
        ApplicationContext context=new AnnotationConfigApplicationContext(RedisConfig.class);
        HibernateT hibernateT= (HibernateT) context.getBean("RedisDao");
       // StringRedisTemplate srt=(StringRedisTemplate) context.getBean("stringredistemplate");
        //HibernateT hibernateT=new HibernateT();
        hibernateT.init();
        long starttime=System.currentTimeMillis();
        System.out.println(hibernateT.testG());
        long endtime=System.currentTimeMillis();
        System.out.println("运行的时间为："+(endtime-starttime)+"ms");
        // hibernateT.testG();
        hibernateT.destory();
    }
}
