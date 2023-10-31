package com.example.mod2.aop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {
    @Pointcut("execution(* get*())")
    public void allAddMethods(){}

    @Pointcut("execution(* com.example.mod2.aop.UniLibrary.get*(..))")
    public void allGetMethods(){}

    @Pointcut("execution(* com.example.mod2.aop.UniLibrary.return*(..))")
    public void allReturnMethods(){}

    @Pointcut("allGetMethods() && !allReturnMethods()")
    public void allMethods(){}
}
