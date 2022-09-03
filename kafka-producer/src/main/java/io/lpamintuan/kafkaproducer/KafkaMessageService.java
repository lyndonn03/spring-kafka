package io.lpamintuan.kafkaproducer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageService {

    @Autowired
    private KafkaTemplate<String, KafkaMessage> kafkaTemplate;

    @Autowired
    private NewTopic messageTopic;

    public void sendMessage(KafkaMessage message) {

        kafkaTemplate.send(messageTopic.name(), message);

    }
    
}
