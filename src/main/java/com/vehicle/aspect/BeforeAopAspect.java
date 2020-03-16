package com.vehicle.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class BeforeAopAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.vehicle.ccc.*.*(..))")
    public void before(JoinPoint joinPoint){
        logger.info(" Checking for Before Business Services Data");
        logger.info(" Allowed execution for {}", joinPoint);
    }
}
