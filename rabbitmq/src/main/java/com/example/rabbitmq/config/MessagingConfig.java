package com.example.rabbitmq.config;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {
//    queue
    public static final String QUEUE = "car_queue";
    public static final String QUEUE2 = "food_queue";
    public static final String HEADER_QUEUE = "header_queue";

//    exchange
    public static final String EXCHANGE = "test_exchange";
    public static final String EXCHANGE2 = "test2_exchange";
    public static final String HEADER_EXCHANGE = "test_header_exchange";


//    routing key
    public static final String ROUTING_KEY = "test_routingKey";
    public static final String ROUTING_KEY2 = "test_routingKey2";
    public static final String HEADER_ROUTING_KEY = "test_routingKey";

//    Queue: Buffer that stores messages.
    @Bean
    public Queue queue(){return new Queue(QUEUE, true);}

    @Bean
    public Queue queue2(){
        return new Queue(QUEUE2);
    }
    @Bean
    public Queue header_queue(){
        return new Queue(HEADER_QUEUE);
    }

//    Exchange: Receives messages from producers and pushes them to queues depending on rules defined by the exchange type.
//    To receive messages, a queue needs to be bound to at least one exchange.
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(EXCHANGE);
    }
    @Bean
    public TopicExchange exchange2(){
        return new TopicExchange(EXCHANGE2);
    }
    @Bean
    public HeadersExchange headersExchange(){return new HeadersExchange(HEADER_EXCHANGE);}

//    Binding: A binding is a link between a queue and an exchange.
    @Bean
    public Binding binding(Queue queue, TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);}
    @Bean
    public Binding binding2(Queue queue2, TopicExchange exchange2){
        return BindingBuilder.bind(queue2).to(exchange2).with(ROUTING_KEY2);}
    @Bean
    public BindingBuilder.HeadersExchangeMapConfigurer.HeadersExchangeSingleValueBindingCreator binding3(Queue header_queue, HeadersExchange headersExchange){
        return BindingBuilder.bind(header_queue).to(headersExchange).where(HEADER_ROUTING_KEY);}

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
