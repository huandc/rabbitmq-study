package com.example.controller.fanout;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutCustomer {


    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, //临时队列
                    exchange = @Exchange(name = "logs", type = "fanout") //绑定的交换机
            )
    })
    public void receive1(String message) {
        System.out.println("消费者 1 message = " + message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, //临时队列
                    exchange = @Exchange(name = "logs", type = "fanout") //绑定的交换机
            )
    })
    public void receive2(String message) {
        System.out.println("消费者 2 message = " + message);
    }

}
