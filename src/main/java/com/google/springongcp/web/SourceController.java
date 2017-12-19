package com.google.springongcp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableBinding(Source.class)
@RestController
public class SourceController {

  @Autowired
  private Source source;

  @PostMapping("/postMessage")
  public void messageHandler(@RequestParam("message") String message) {
    source.output().send(new GenericMessage<>(message));
//        new Message("user", message, LocalDateTime.now())));
  }

}
