package com.example.playground.processor;

import com.example.playground.model.request.GameDtoRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Slf4j
@Service
public class GameDtoRandDiscountProcessor {

    @Autowired
    KafkaTemplate<String, String> kafkaStringTemplate;

    public void randomDiscount(GameDtoRequest gameDtoRequest){
        StringBuilder str = new StringBuilder().append("Random Discount ");
        int discount = ((int) (Math.random()*100+1));

        if(discount > 95){
            str.append("Failed: Too much discount ").append(discount);
            kafkaStringTemplate.send("random.discount", str.toString());
            return;
        }

        str.append("by ").append(discount).append(" from original price: ").append(gameDtoRequest.getGameRequest().getPrice());

        gameDtoRequest.getGameRequest().setDiscount(discount);
        BigDecimal discountedPrice = gameDtoRequest.getGameRequest().getPrice().multiply((BigDecimal.valueOf(100).subtract(BigDecimal.valueOf(discount))).divide(BigDecimal.valueOf(100)));
        gameDtoRequest.getGameRequest().setPrice(discountedPrice);

        str.append(", to: ").append(discountedPrice);

        kafkaStringTemplate.send("random.discount", str.toString());

    }

}
