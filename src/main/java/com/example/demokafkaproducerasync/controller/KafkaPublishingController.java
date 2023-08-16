package com.example.demokafkaproducerasync.controller;

import com.example.demokafkaproducerasync.model.MessageObject;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@Slf4j
@AllArgsConstructor
public class KafkaPublishingController {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final Gson gson;
    @GetMapping("/send")
    public String send(){
        MessageObject messageObject = new MessageObject("1", "this is data");
        try {
            CompletableFuture.runAsync(() -> {
                kafkaTemplate.send("topic",gson.toJson(messageObject));
            });
        }catch (Throwable e){
            log.info(String.valueOf(e));
            return "Fail";
        }
        return "Success";
    }
}
