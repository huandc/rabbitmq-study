package com.example.controller.work;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class WorkCustomer {

    //一个消费者
    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive1(String message){

        try {
            Thread.sleep(10);
            System.out.println("work 1 message = " + message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //一个消费者
    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive2(String message){
        System.out.println("work 2 message = " + message);
    }
}
