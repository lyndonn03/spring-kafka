package io.lpamintuan.kafkaproducer;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KafkaMessage {

    private LocalDateTime timestamp;
    private String message;

}
