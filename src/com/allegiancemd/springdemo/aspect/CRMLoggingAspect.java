package com.allegiancemd.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    //    Setup Logger
    Logger logger = Logger.getLogger(getClass().getName());

    //    Setup pointcut declarations
    @Pointcut("execution(* com.allegiancemd.springdemo.controller.*.*(..))")
    private void forControllerPackage() {
    }

    @Pointcut("execution(* com.allegiancemd.springdemo.dao.*.*(..))")
    private void forDaoPackage() {
    }

    @Pointcut("execution(* com.allegiancemd.springdemo.service.*.*(..))")
    private void forServicePackage() {
    }

    @Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
    private void forAppFlow() {
    }

    //    Add @Before advice
    @Before("forAppFlow()")
    private void beforeMethod(JoinPoint joinPoint) {
        logger.info("============> Running in " + joinPoint.getSignature().toShortString() + " method =======");
    }

//    Add @AfterRetuning advice

}
