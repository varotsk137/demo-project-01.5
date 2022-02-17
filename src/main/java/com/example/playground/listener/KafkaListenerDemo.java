package com.example.playground.listener;

import com.example.playground.model.request.GameDtoRequest;
import com.example.playground.processor.GameDtoRandDiscountProcessor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import java.io.InputStream;

@Slf4j
@Configuration
public class KafkaListenerDemo {

    @Autowired
    GameDtoRandDiscountProcessor gameDtoRandDiscountProcessor;

    @KafkaListener(topics = "receiveMessage")
    public void consumeMessage(ConsumerRecord<String, String> cr){
        log.info("Message: {}", cr);
    }

    @KafkaListener(topics = "pub.model.gameDtoRequest")
    public void consumeMessageBody(ConsumerRecord<String, Object> cr){
        GameDtoRequest gameDtoRequest = (GameDtoRequest) cr.value();
        log.info("Body: {}", gameDtoRequest);
        gameDtoRandDiscountProcessor.randomDiscount(gameDtoRequest);
    }

    @KafkaListener(topics = "demo.sendFile")
    public void consumeMessageFile(ConsumerRecord<String, InputStream> cr){
        log.info("Body: {}", cr);
    }

}
