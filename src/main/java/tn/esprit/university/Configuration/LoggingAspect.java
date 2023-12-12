package tn.esprit.university.Configuration;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
    @Before("execution(* tn.esprit.university.Service.FoyerService.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Before method " + name + " : ");
    }
    @After("execution(* tn.esprit.university.Service.EtudiantService.*(..))")
    public void logMethodExit(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("After method " + name + " : ");
    }
    @Around("execution(* tn.esprit.university.Service.*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Method execution time: " + elapsedTime + " milliseconds.");
        return obj;
    }
    @AfterReturning("execution(* tn.esprit.university.Service.FoyerService.*(..))")
    public void logMethodAfterReturning(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info(" method " + name + " : ");
    }
    @AfterThrowing("execution(* tn.esprit.university.Service.FoyerService.*(..))")
    public void logMethodAfterThrowing(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info(" method " + name + " : ");
    }




}
