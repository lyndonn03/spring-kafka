package io.lpamintuan.kafkaproducer;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping
public class KafkaController {

    @Autowired
    private KafkaMessageService kafkaMessageService;

    @PostMapping("/send-message")
    public ResponseEntity<KafkaMessage> sendMessage(@RequestBody KafkaMessage message) throws JsonProcessingException {
        message.setTimestamp(LocalDateTime.now());
        kafkaMessageService.sendMessage(message);
        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
    }

    
}
