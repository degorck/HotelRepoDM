package com.example.demo.utils.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

import static com.example.demo.utils.Constants.BLANK_SPACE;
import static com.example.demo.utils.Constants.EXECUTED_IN_LABEL;
import static com.example.demo.utils.Constants.METHOD_LABEL;
import static com.example.demo.utils.Constants.MS_LABEL;

@Aspect
@Component
@Slf4j
@ConditionalOnExpression("${aspect.enabled:true}")
public class ExecutionTimeAdvice {
    @Around("@annotation(TrackExecutionTime)")
    public Object executionTime(ProceedingJoinPoint point) throws Throwable{
        long startTime = System.currentTimeMillis();
        Object object = point.proceed();
        long executionTime = System.currentTimeMillis()-startTime;
        String stringExecutionTime = Long.toString(executionTime);
        log.info(METHOD_LABEL.concat(point.getSignature().getName()).concat(EXECUTED_IN_LABEL).concat(stringExecutionTime).concat(BLANK_SPACE).concat(MS_LABEL));
        return object;
    }
}
