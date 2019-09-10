package com.iamlook.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumerService {

  @KafkaListener(topics = {"${spring.kafka.topic.userTopic}"})
  public void consume(Object o) {
    System.out.println("kafka");
    System.out.println("kafka");
    System.out.println("kafka");
    System.out.println("kafka");
  }
}
