package com.dariom.timeit.util;

import lombok.experimental.UtilityClass;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

@UtilityClass
public class TimeFormatter {

    public static String formatTime(long timeInNanos, TimeUnit targetUnit) {
        return switch (targetUnit) {
            case NANOSECONDS -> timeInNanos + " ns";
            case MICROSECONDS -> MICROSECONDS.convert(timeInNanos, NANOSECONDS) + " μs";
            case MILLISECONDS -> MILLISECONDS.convert(timeInNanos, NANOSECONDS) + " ms";
            case SECONDS -> SECONDS.convert(timeInNanos, NANOSECONDS) + " s";
            case MINUTES -> MINUTES.convert(timeInNanos, NANOSECONDS) + " min";
            case HOURS -> HOURS.convert(timeInNanos, NANOSECONDS) + " h";
            case DAYS -> DAYS.convert(timeInNanos, NANOSECONDS) + " d";
        };
    }
}
