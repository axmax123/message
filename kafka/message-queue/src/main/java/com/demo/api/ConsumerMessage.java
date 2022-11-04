package com.demo.api;

import com.demo.utils.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumerMessage {
    @KafkaListener(topics = Constants.KAFKA.TOPIC_SEND_MESSAGE, groupId = Constants.KAFKA.GROUP_ID)
    public void consume(String jsonData, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        log.info(String.format("#### -> Consumed message-> %s, with partition: %s", jsonData, partition));
    }

    @KafkaListener(topicPartitions = @TopicPartition(topic = Constants.KAFKA.KAFKA_TOPIC,
            partitions = {"1", "3"}))
    public void consumeReceiveWithPartition(@Payload String jsonData, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        log.info(String.format("#### -> Consumed message-> %s, with partition: %s", jsonData, partition));
    }

    @KafkaListener(topics = Constants.KAFKA.TOPIC_SEND_MESSAGE, groupId = Constants.KAFKA.GROUP_ID)
    public void consume2(String jsonData, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        log.info(String.format("#### -> Consumed message1-> %s, with partition: %s", jsonData, partition));
    }

    @KafkaListener(topics = Constants.KAFKA.TOPIC_SEND_MESSAGE, groupId = Constants.KAFKA.GROUP_ID)
    public void consume3(String jsonData, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        log.info(String.format("#### -> Consumed message2-> %s, with partition: %s", jsonData, partition));
    }
}
