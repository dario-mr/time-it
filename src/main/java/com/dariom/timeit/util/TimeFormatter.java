package com.dariom.timeit.util;

import lombok.experimental.UtilityClass;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

@UtilityClass
public class TimeFormatter {

    public static String formatTime(long executionTimeInNanos, TimeUnit targetUnit) {
        return switch (targetUnit) {
            case NANOSECONDS -> executionTimeInNanos + " ns";
            case MICROSECONDS -> MICROSECONDS.convert(executionTimeInNanos, NANOSECONDS) + " μs";
            case MILLISECONDS -> MILLISECONDS.convert(executionTimeInNanos, NANOSECONDS) + " ms";
            case SECONDS -> SECONDS.convert(executionTimeInNanos, NANOSECONDS) + " s";
            case MINUTES -> MINUTES.convert(executionTimeInNanos, NANOSECONDS) + " min";
            case HOURS -> HOURS.convert(executionTimeInNanos, NANOSECONDS) + " h";
            case DAYS -> DAYS.convert(executionTimeInNanos, NANOSECONDS) + " d";
        };
    }
}
