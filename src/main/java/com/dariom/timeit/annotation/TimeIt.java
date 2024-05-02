package com.dariom.timeit.annotation;

import org.slf4j.event.Level;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.slf4j.event.Level.INFO;

/**
 * Annotation that logs the execution time of Spring Boot components.
 * <p>
 * Example usage:
 * <pre>{@code
 * @Service
 * public class MyService {
 *
 *      @TimeIt
 *      public void run() {
 *          // my code
 *      }
 * }
 * }</pre>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TimeIt {

    /**
     * @return Time unit in which the execution time is expressed.
     * <p>
     * Default: {@link TimeUnit#MILLISECONDS}.
     */
    TimeUnit unit() default MILLISECONDS;

    /**
     * @return Level in which the execution time is logged.
     * <p>
     * Default: {@link Level#INFO}.
     */
    Level logLevel() default INFO;
}
