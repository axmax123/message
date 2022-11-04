//package com.example.demo3rabbitmqtypeexchange.config;

//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.core.TopicExchange;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class TopicConfiguration {
//
//	@Bean
//	Queue primarystudentsQueue() {
//		return new Queue("primarystudentsQueue", false);
//	}
//
//	@Bean
//	Queue secondarystudentsQueue() {
//		return new Queue("secondarystudentsQueue", false);
//	}
//
//	@Bean
//	Queue collegestudentsQueue() {
//		return new Queue("collegestudentsQueue", false);
//	}
//
//	@Bean
//	Queue totalQueue() {
//		return new Queue("totalQueue", false);
//	}
//
//	@Bean
//	TopicExchange topicExchange() {
//		return new TopicExchange("topic-exchange");
//	}
//	
//	@Bean
//	Binding primarystudentsBinding(Queue primarystudentsQueue, TopicExchange topicExchange) {
//		return BindingBuilder.bind(primarystudentsQueue).to(topicExchange).with("queue.primarystudents");
//	}
//	
//	@Bean
//	Binding secondarystudentsBinding(Queue secondarystudentsQueue, TopicExchange topicExchange) {
//		return BindingBuilder.bind(secondarystudentsQueue).to(topicExchange).with("queue.secondarystudents");
//	}
//	
//	@Bean
//	Binding collegestudentsBinding(Queue collegestudentsQueue, TopicExchange topicExchange) {
//		return BindingBuilder.bind(collegestudentsQueue).to(topicExchange).with("queue.collegestudents");
//	}
//	
//	@Bean
//	Binding allBinding(Queue totalQueue, TopicExchange topicExchange) {
//		return BindingBuilder.bind(totalQueue).to(topicExchange).with("queue.*");
//	}
//
//}
