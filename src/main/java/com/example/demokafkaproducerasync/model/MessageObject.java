package com.example.demokafkaproducerasync.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class MessageObject {
  private String id;
  private String data;
}
