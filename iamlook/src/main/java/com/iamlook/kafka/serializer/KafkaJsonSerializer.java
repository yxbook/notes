package com.iamlook.kafka.serializer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Slf4j
public class KafkaJsonSerializer<T> extends JsonSerializer<T> {

  @Override
  public byte[] serialize(String topic, T data) {
    byte[] bytes = null;
    try {
      bytes = super.serialize(topic, data);
    } catch (Exception e) {
      log.error("Error when serializing object due to: {}", e.getMessage());
    }
    return bytes;
  }

}
