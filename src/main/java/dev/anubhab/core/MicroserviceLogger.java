package dev.anubhab.core;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class MicroserviceLogger {
    private static final Logger logger = LoggerFactory.getLogger(MicroserviceLogger.class);


    public void msInfo(String message) {
//        String msMessage = String.format("[%s][%s] INFO: %s", sourceName, className, message);
        logger.info(message);
    }

    @Pointcut("execution(* dev.anubhab.*.controller.*.*(..))")
    public void controllerMethods() {
        System.out.println("Controller method pointcut initialized");
    }

    @Pointcut("execution(* dev.anubhab.*.service.*.*(..))")
    public void serviceMethods() {
        System.out.println("Service method pointcut initialized");
    }

    @Before("controllerMethods() || serviceMethods()")
    public void logMethodEntry(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        Object[] args = joinPoint.getArgs();

        logger.info("[ENTRY] {}.{} | Args: {}", className, methodName, Arrays.toString(args));
    }

    @After("controllerMethods() || serviceMethods()")
    public void logMethodExit(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();

        logger.info("[EXIT] {}.{}", className, methodName);
    }

    @AfterThrowing(pointcut = "controllerMethods() || serviceMethods()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();

        logger.error("[EXCEPTION] {}.{} | Error: {}", className, methodName, exception.getMessage(), exception);
    }

    @Around("controllerMethods() || serviceMethods()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long duration = System.currentTimeMillis() - startTime;

        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();

        logger.info("[TIMING] {}.{} | Duration: {}ms", className, methodName, duration);
        return result;
    }
}

