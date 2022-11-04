package com.example.demo3rabbitmqtypeexchange.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/fanout/")
public class FanoutController {

	@Autowired
	private AmqpTemplate amqpTemplate;

	@GetMapping(value = "/sendmsg")
	public String producer(@RequestParam("exchange") String exchange,
			@RequestParam("msg") String msg) {

		amqpTemplate.convertAndSend(exchange, "", msg);

		return "Message sent to the RabbitMQ Fanout Exchange Successfully";
	}
}