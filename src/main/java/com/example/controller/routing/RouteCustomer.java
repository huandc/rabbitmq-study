package com.example.controller.routing;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RouteCustomer {


    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(name = "service", type = "direct"),
                    key = {"info", "error"}
            ),
    })
    public void receive1(String message) {

        System.out.println("info message = " + message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(name = "service", type = "direct"),
                    key = {"error"}
            ),
    })
    public void receive2(String message) {

        System.out.println("error message = " + message);
    }
}
