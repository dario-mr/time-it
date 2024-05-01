package com.dariom.timeit.aspect;

import com.dariom.timeit.annotation.TimeIt;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import static com.dariom.timeit.aspect.TimeFormatter.formatTime;

@Slf4j
@Aspect
@Component
class TimeItAspect {

    @Around("@annotation(timeIt)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint, TimeIt timeIt) throws Throwable {
        var startTime = System.nanoTime();
        var result = joinPoint.proceed();
        var executionTimeInNanos = System.nanoTime() - startTime;

        var formattedExecutionTime = formatTime(executionTimeInNanos, timeIt.unit());

        var logger = log.makeLoggingEventBuilder(timeIt.logLevel());
        logger.log("{} execution time: {}", joinPoint.getSignature().toShortString(), formattedExecutionTime);

        return result;
    }
}
