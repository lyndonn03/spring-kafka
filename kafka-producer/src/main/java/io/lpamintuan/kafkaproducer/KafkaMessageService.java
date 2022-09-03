package io.lpamintuan.kafkaproducer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class KafkaMessageService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private NewTopic messageTopic;

    private ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();

    public void sendMessage(KafkaMessage message) throws JsonProcessingException {
        kafkaTemplate.send(messageTopic.name(), mapper.writeValueAsString(message));

    }
    
}
