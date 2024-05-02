package com.dariom.timeit;

import com.dariom.timeit.annotation.TimeIt;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @TimeIt
    @SneakyThrows
    public void run(long sleepMs) {
        Thread.sleep(sleepMs);
    }
}
