//package com.example.demo3rabbitmqtypeexchange.config;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.FanoutExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class FanoutConfiguration {
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
//	FanoutExchange exchange() {
//		return new FanoutExchange("fanout-exchange");
//	}
//
//	@Bean
//	Binding primarystudentsBinding(Queue primarystudentsQueue, FanoutExchange fanoutExchange) {
//		return BindingBuilder.bind(primarystudentsQueue).to(fanoutExchange);
//	}
//
//	@Bean
//	Binding secondarystudentsBinding(Queue secondarystudentsQueue, FanoutExchange fanoutExchange) {
//		return BindingBuilder.bind(secondarystudentsQueue).to(fanoutExchange);
//	}
//
//	@Bean
//	Binding collegestudentsBinding(Queue collegestudentsQueue, FanoutExchange fanoutExchange) {
//		return BindingBuilder.bind(collegestudentsQueue).to(fanoutExchange);
//	}
//
//
//}
