package com.example.rabbitmq.publisher;

import com.example.rabbitmq.config.MessagingConfig;
import com.example.rabbitmq.dto.FoodDTO;
import com.example.rabbitmq.dto.FoodStatus;
import com.example.rabbitmq.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("food")
public class FoodPublisher {
    private final RabbitTemplate template;

    public FoodPublisher(RabbitTemplate template) {
        this.template = template;}
    @PostMapping("/{food}")
    public String FoodOder(@RequestBody FoodDTO foodDTO, @PathVariable String food){
        foodDTO.setOrderID(UUID.randomUUID().toString());
        FoodStatus foodStatus = new FoodStatus(foodDTO, "Done", "Brand "+food );
        template.convertSendAndReceive(MessagingConfig.EXCHANGE2, MessagingConfig.ROUTING_KEY2, foodStatus);
        return "Oder food Status done";
    }
}
