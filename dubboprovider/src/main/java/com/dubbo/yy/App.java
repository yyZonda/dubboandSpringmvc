package com.dubbo.yy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("ApplicationContext-dubbo.xml");
        ((ClassPathXmlApplicationContext) applicationContext).start();
        System.out.println( "Hello World!" );
        System.in.read();
    }
}
