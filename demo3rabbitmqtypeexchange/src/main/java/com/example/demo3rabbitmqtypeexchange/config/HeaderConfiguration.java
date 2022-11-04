//package com.example.demo3rabbitmqtypeexchange.config;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.HeadersExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.core.TopicExchange;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class HeaderConfiguration {
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
//
//
//	@Bean
//	HeadersExchange headerExchange() {
//		return new HeadersExchange("header-exchange");
//	}
//	@Bean
//	Binding primarystudentsBinding(Queue primarystudentsQueue, HeadersExchange exchange) {
//		return BindingBuilder.bind(primarystudentsQueue).to(exchange).where("students").matches("primarystudents");
//	}
//
//	@Bean
//	Binding secondarystudentsBinding(Queue secondarystudentsQueue,HeadersExchange exchange) {
//		return BindingBuilder.bind(secondarystudentsQueue).to(exchange).where("students").matches("secondarystudents");
//	}
//
//	@Bean
//	Binding collegestudentsBinding(Queue collegestudentsQueue, HeadersExchange exchange) {
//		return BindingBuilder.bind(collegestudentsQueue).to(exchange).where("students").matches("collegestudents");
//	}
//
//
//
//}
