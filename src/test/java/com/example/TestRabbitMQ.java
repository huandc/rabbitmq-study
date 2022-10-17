package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest(classes = RabbitmqSpringbootApplication.class)
@RunWith(SpringRunner.class)
public class TestRabbitMQ {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    //routing 广播形式
    @Test
    public void testRouting() {
        for (int i = 0; i < 10; i++) {
            String key = "info";
            if (i % 2 == 0)
                key = "error";
            rabbitTemplate.convertAndSend("service", key, "routing model msg" + key +"  " + i);
        }
    }

    //fanout 广播形式
    @Test
    public void testFanout() {
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("logs", "", "fanout model msg" + i);
        }
    }


    // work queue
    @Test
    public void testWork() {
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work", "this work model msg " + i);
        }
    }

    //hello world model
    @Test
    public void testHello() {
        rabbitTemplate.convertAndSend("hello", "this is hello world model message");
    }
}
