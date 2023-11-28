package com.example.demojenkins;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoJenkinsApplicationTests {

    @Test
    void contextLoads() {
        HelloController var = new HelloController();
        Assert.assertEquals("hello Spring Boot", var.show());
        Assert.assertNotEquals("hello World", var.show());
    }

}
