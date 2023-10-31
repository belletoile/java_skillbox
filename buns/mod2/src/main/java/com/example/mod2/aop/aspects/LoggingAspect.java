package com.example.mod2.aop.aspects;

import com.example.mod2.aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {


    @Before("com.example.mod2.aop.aspects.MyPointcuts.allMethods()")
    public void beforeAllMethodsAdvice(JoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature.getMethod = " + methodSignature.getMethod());

        if (methodSignature.getName().equals("getBook")) {
            Object[] arg = joinPoint.getArgs();
            for (Object obj: arg) {
                if (obj instanceof Book myBook) {
                    System.out.println("Информация о книге: название - " + myBook.getName() +
                            ", автор - " + myBook.getAuthor() +
                            ", год издания - " + myBook.getYearOfPublication());
                }
            }
        }
        System.out.println("beforeAllMethodsAdvice");
        System.out.println("-----------------------");
    }
}



