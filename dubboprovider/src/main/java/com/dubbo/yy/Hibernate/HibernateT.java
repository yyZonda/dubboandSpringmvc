package com.dubbo.yy.Hibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("RedisDao")
public class HibernateT {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    public void init(){
        Configuration configuration=new Configuration().configure();
        sessionFactory=configuration.buildSessionFactory();
        session=sessionFactory.openSession();
        transaction=session.beginTransaction();
    }
    public void destory(){
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
    @Cacheable(value = "girlfriend",key="'yname'")
    public String testG() {
        String hql="FROM HibernateentityEntity";
        Query query=session.createQuery(hql);
        List<HibernateentityEntity> results=query.list();
        System.out.println("查询数据库ing");
        String name="come in";
        return results.get(1).getName();
        // HibernateentityEntity goods = new HibernateentityEntity(2, "ly", 2333.33);
        //保存对象进数据库
        // session.save(goods);
    }
}

