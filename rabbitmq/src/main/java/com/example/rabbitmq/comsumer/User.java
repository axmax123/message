package com.example.rabbitmq.comsumer;

import com.example.rabbitmq.config.MessagingConfig;
import com.example.rabbitmq.dto.FoodStatus;
import com.example.rabbitmq.dto.OrderStatus;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Component
public class User {

    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(OrderStatus orderStatus) {
        System.out.println("Message recieved from queue : " + orderStatus);
    }

    @RabbitListener(queues = MessagingConfig.QUEUE2)
    public void consumeMessageFromQueue2(FoodStatus foodStatus) {
        System.out.println("Message recieved from queue2 : " + foodStatus);
    }
}
