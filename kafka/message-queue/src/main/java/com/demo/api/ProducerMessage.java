package com.demo.api;

import com.demo.utils.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProducerMessage {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessageNoKey(String smsJsonData) {
        log.info(String.format("#### -> Producing message -> %s", smsJsonData));
        ListenableFuture<SendResult<String, String>> future =
                kafkaTemplate.send(Constants.KAFKA.TOPIC_SEND_MESSAGE, smsJsonData);

        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(@NotNull Throwable throwable) {
                System.out.println("Unable to send message=["
                        + smsJsonData + "] due to : " + throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("Sent message=[" + smsJsonData +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
        });
    }

    public void sendMessageDefineKey(String smsJsonData, String key) {
        log.info(String.format("#### -> Producing message -> %s", smsJsonData));
        kafkaTemplate.send(Constants.KAFKA.KAFKA_TOPIC, key, smsJsonData);
    }

    public void sendMessageDefinePartition(String smsJsonData) {
        log.info(String.format("#### -> Producing message -> %s", smsJsonData));
        for (int i = 0; i < 5; i++) {
            kafkaTemplate.send(Constants.KAFKA.KAFKA_TOPIC, i, null, smsJsonData);
        }
    }
}
