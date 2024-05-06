package com.dariom.timeit.aspect;

import lombok.experimental.UtilityClass;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

/**
 * Utility class for formatting time (expressed in nanoseconds) in the desired time unit.
 */
@UtilityClass
class TimeFormatter {

    /**
     * Format time from nanoseconds to the target time unit.
     * <p>
     * Examples:
     * <pre>{@code
     * formatTime(111_222_333L, MILLISECONDS) -> "111 ms"
     * formatTime(1_222_333_444L, SECONDS) -> "1 s"
     * }</pre>
     *
     * @param timeInNanos Time to format, in nanoseconds
     * @param targetUnit  Target time unit
     * @return {@code String} formatted in the target time unit, followed by its symbol, according to the International
     * System of Units
     */
    static String formatTime(long timeInNanos, TimeUnit targetUnit) {
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
