package com.example.demorabbitmqexchange.controller;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/header/")
public class HeaderController {
    private AmqpTemplate amqpTemplate;

    @GetMapping(value = "/sendmsg")
    public String producer(@RequestParam("exchange") String exchange, @RequestParam("students") String students,
                           @RequestParam("msg") String msg) {

        MessageProperties msgProperties = new MessageProperties();
        msgProperties.setHeader("students", students);
        MessageConverter messageConverter = new SimpleMessageConverter();
        Message message = messageConverter.toMessage(msg, msgProperties);
        amqpTemplate.send(exchange, "", message);

        return "Message Successfully sent---- Method used Header Exchange";
    }
}