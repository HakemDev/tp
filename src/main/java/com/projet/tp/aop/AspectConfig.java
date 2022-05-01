package com.projet.tp.aop;


import com.projet.tp.handler.TaskException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ResponseStatusException;





@Aspect
@Configuration
public class AspectConfig {

    /* Logging + Exception Handling + Time */

    private static Logger log = LoggerFactory.getLogger(AspectConfig.class);
@Before(value= "execution(* com.projet.tp.rest.*.*(..))")
    public void logStatementBefore (JoinPoint exec)
    {
        log.info("Executing{}",exec);   //traitement avant
    }
    @After(value = "execution(* com.projet.tp.rest.*.*(..))") //Zone API
    public void logStatementAfter(JoinPoint joinPoint) {
        log.info("Complete exceution of {}",joinPoint);   //traitement apres
    }
    @Around(value = "execution(* com.projet.tp.rest.*.*(..))")

    public Object taskHandler(ProceedingJoinPoint joinPoint) throws Throwable {

        try {
            Object obj=joinPoint.proceed();      //LOG EXCEPTIONS
            return obj;
        }
        catch(TaskException e) {    //TaskException est une sous exception personalise de RuntimeException
            log.info(" TaskException StatusCode {}",e.getHttpStatus().value());
            log.info("TaskException Message {}",e.getMessage());
            throw new ResponseStatusException(e.getHttpStatus(), e.getMessage());
        }
    }

    @Around(value = "execution(* com.projet.tp.rest.*.*(..))")
    public Object timeTracker(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime=System.currentTimeMillis();

        try {               //LOG TEMPS
            Object obj=joinPoint.proceed();
            long timeTaken=System.currentTimeMillis()-startTime;
            log.info("Time taken by {} is {}",joinPoint,timeTaken);
            return obj;
        }
        catch(TaskException e) {
            log.info(" TaskException StatusCode {}",e.getHttpStatus().value());
            log.info("TaskException Message {}",e.getMessage());
            throw new ResponseStatusException(e.getHttpStatus(), e.getMessage());
        }
    }
    public static void main(String[] args) {
        //(same location as ClassOne.class)

        log.info("Program started.... "); //Whenever you want to write something to the log text file use logger.info("Log Message")

    }


}
