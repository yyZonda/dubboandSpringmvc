package controller;

import Hibernate.HibernateT;
import RedisConfig.RedisConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/3")
public class MainController {
    //private HibernateT hibernateT=new HibernateT();
    @RequestMapping(method = RequestMethod.GET)
    // @ResponseBody
    //查询所有数据到页面显示
    public ModelAndView dataAll(){
        ApplicationContext context=new AnnotationConfigApplicationContext(RedisConfig.class);
        //调用Service层进行数据查找
        HibernateT hibernateT= (HibernateT) context.getBean("RedisDao");
        hibernateT.init();
        String message= hibernateT.testG();
        hibernateT.destory();
        ModelAndView view = new ModelAndView();
        view.addObject("message",message);
        view.setViewName("index");
        return view;
    }

    public String welcome() {
        return "index";
    }
}

