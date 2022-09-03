package io.lpamintuan.kafkaconsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class KafkaListenerService {

    private ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();

    @KafkaListener(topics = {"my-message-topic"}, groupId = "my-message-topic-consumer")
    public void handle(String message) throws JsonMappingException, JsonProcessingException {
        KafkaMessage x = mapper.readValue(message, KafkaMessage.class);

        // show that the message was parsed
        System.out.println(x);
    }
    
}
