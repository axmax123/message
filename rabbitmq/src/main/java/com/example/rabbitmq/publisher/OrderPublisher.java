package com.example.rabbitmq.publisher;

import com.example.rabbitmq.config.MessagingConfig;
import com.example.rabbitmq.dto.FoodDTO;
import com.example.rabbitmq.dto.FoodStatus;
import com.example.rabbitmq.dto.OrderDTO;
import com.example.rabbitmq.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("order")

public class OrderPublisher {

        private final RabbitTemplate template;
        private final MessagingConfig messagingConfig;

        public OrderPublisher(RabbitTemplate template, MessagingConfig messagingConfig) {
        this.template = template;
        this.messagingConfig = messagingConfig;
        }
    @PostMapping("/car/{car}")
    public String CarOder(@RequestBody OrderDTO orderDTO, @PathVariable String car){
        orderDTO.setOrderID(UUID.randomUUID().toString());
            OrderStatus orderStatus = new OrderStatus(orderDTO, "PROCESS", "Brand "+car );
            template.convertSendAndReceive(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, orderStatus);
            return "Send brand order car success";
        }
    @PostMapping("/food/{food}")
    public FoodStatus FoodOder(@RequestBody FoodDTO foodDTO, @PathVariable String food){
        foodDTO.setOrderID(UUID.randomUUID().toString());
        FoodStatus foodStatus = new FoodStatus(foodDTO, "Done", "Type "+food );
        template.convertSendAndReceive(MessagingConfig.EXCHANGE2, MessagingConfig.ROUTING_KEY2, foodStatus);
        FoodStatus c = foodStatus;
        return c ;
    }
    @PostMapping("/new/{food}")
    public FoodStatus FoodOder1(@RequestBody FoodDTO foodDTO, @PathVariable String food){
        foodDTO.setOrderID(UUID.randomUUID().toString());
        FoodStatus foodStatus = new FoodStatus(foodDTO, "Done", "Type "+food );
        template.convertSendAndReceive(MessagingConfig.HEADER_EXCHANGE, MessagingConfig.HEADER_ROUTING_KEY, foodStatus);
        FoodStatus c = foodStatus;
        return c ;
    }


}
