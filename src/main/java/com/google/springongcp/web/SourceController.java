package com.google.springongcp.web;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@EnableBinding(Source.class)
public class SourceController {

  @Autowired
  private Source source;

  @PostMapping("/postMessage")
  public void messageHandler(@RequestParam("message") String message) {
    source.output().send(new GenericMessage<>(
        new Message("user", message, LocalDateTime.now())));
  }

}
