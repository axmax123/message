package com.demo.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final ProducerMessage producerMessage;

    @GetMapping(value = "/send-message")
    public String sendSMSToKafka() {
        System.out.println("----------------START SEND-----------");
        String mes = "Sending message to kafka topic:" + new Random().nextInt(100);
        producerMessage.sendMessageNoKey(mes);
        System.out.println("----------------END SEND-------------");
        return "OK";
    }

    @GetMapping(value = "/send-message-key")
    public String sendSMSKeyToKafka(
            @RequestParam String key) {
        System.out.println("----------------START SEND-----------");
        String mes = "Sending message to kafka topic:" + new Random().nextInt(100);
        producerMessage.sendMessageDefineKey(mes, key);
        System.out.println("----------------END SEND-------------");
        return "OK";
    }

    @GetMapping(value = "/send-message-partition")
    public String sendSMSWithPartitionToKafka() {
        System.out.println("----------------START SEND-----------");
        String mes = "Sending message to kafka topic:" + new Random().nextInt(100);
        producerMessage.sendMessageDefinePartition(mes);
        System.out.println("----------------END SEND-------------");
        return "OK";
    }

}
