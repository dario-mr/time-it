package com.dariom.timeit.aspect;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static java.util.concurrent.TimeUnit.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TimeFormatterTest {

    @MethodSource("formatTimeData")
    @ParameterizedTest
    void formatTime(long timeInNanos, TimeUnit targetUnit, String expected) {
        var actual = TimeFormatter.formatTime(timeInNanos, targetUnit);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> formatTimeData() {
        return Stream.of(
                Arguments.of(111L, NANOSECONDS, "111 ns"),
                Arguments.of(111_222L, MICROSECONDS, "111 μs"),
                Arguments.of(111_222_333L, MILLISECONDS, "111 ms"),
                Arguments.of(1_222_333_444L, SECONDS, "1 s"),
                Arguments.of(61_111_222_333L, MINUTES, "1 min"),
                Arguments.of(3_912_111_222_333L, HOURS, "1 h"),
                Arguments.of(90_123_111_222_333L, DAYS, "1 d")
        );
    }
}
