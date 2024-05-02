package com.dariom.timeit;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DemoTest {

    @Resource
    private DemoService demoService;

    @Test
    void test() {
        demoService.sleep(10);
    }
}
