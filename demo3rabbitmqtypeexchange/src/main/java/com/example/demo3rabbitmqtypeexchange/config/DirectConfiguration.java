package com.example.demo3rabbitmqtypeexchange.config;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.impl.AMQImpl;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectConfiguration {

	@Bean
	Queue primarystudentsQueue() {
		return new Queue("primarystudentsQueue", false);
	}

	@Bean
	Queue secondarystudentsQueue() {
		return new Queue("secondarystudentsQueue", false);
	}

	@Bean
	Queue collegestudentsQueue() {
		return new Queue("collegestudentsQueue", false);
	}



	@Bean
	DirectExchange exchange() {
		return new DirectExchange("direct-exchange");
	}

	@Bean
	Binding primarystudentsBinding(Queue primarystudentsQueue, DirectExchange exchange) {
		return BindingBuilder.bind(primarystudentsQueue).to(exchange).with("queue.primarystudents");
	}

	@Bean
	Binding secondarystudentsBinding(Queue secondarystudentsQueue, DirectExchange exchange) {
		return BindingBuilder.bind(secondarystudentsQueue).to(exchange).with("queue.secondarystudents");
	}

	@Bean
	Binding collegestudentsBinding(Queue collegestudentsQueue,DirectExchange exchange) {
		return BindingBuilder.bind(collegestudentsQueue).to(exchange).with("queue.collegestudents");
	}

	@Bean
	@JsonBackReference
	public MessageConverter converter(){
		return new Jackson2JsonMessageConverter();
	}

	//Advanced Message Queue Protocol(Amqp)
	public AmqpTemplate template(ConnectionFactory connectionFactory){
		final RabbitTemplate rabbitTemplate = new RabbitTemplate((org.springframework.amqp.rabbit.connection.ConnectionFactory) connectionFactory);
		rabbitTemplate.setMessageConverter(converter());
		return     rabbitTemplate;
	}

}
