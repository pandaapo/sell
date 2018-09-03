package com.panda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggerTest {

    private final  static Logger logger = LoggerFactory.getLogger(LoggerTest.class);
    @Test
    public void test1(){
        String name = "hello";
        String password = "hellopassword";
        logger.debug("debug...");
        logger.info("info...");
        logger.info("name:{}。password:{}", name,password);
        logger.error("error...");
    }
}
