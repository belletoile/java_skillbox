package com.example.mod2.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {

    @Around("com.example.mod2.aop.aspects.MyPointcuts.allReturnMethods()")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку пытаются вернуть книгу");

        Object targetMethodresult= null;
        try {
            targetMethodresult = proceedingJoinPoint.proceed();

        }
        catch (Exception e) {
            System.out.println("aroundAllReturnMethodsLoggingAdvice: Logging exception " + e);
            throw e;
        }


        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку вернули книгу");
        return targetMethodresult;
    }
}
