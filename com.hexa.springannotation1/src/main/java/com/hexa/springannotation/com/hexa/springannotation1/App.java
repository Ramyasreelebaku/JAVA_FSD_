package com.hexa.springannotation.com.hexa.springannotation1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext anno=new AnnotationConfigApplicationContext(StudentConfig.class);
    	Student s=(Student)anno.getBean("stud1");
    	Result r=s.getRes();
        System.out.println(s.toString());
        anno.close();
 
    }
}
