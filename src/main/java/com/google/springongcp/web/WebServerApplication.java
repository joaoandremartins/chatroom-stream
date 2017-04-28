package com.google.springongcp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * Created by joaomartins on 4/26/17.
 */
@SpringBootApplication
@RestController
@EnableBinding(Source.class)
public class WebServerApplication {

  @Autowired
  private Source source;

  public static void main(String[] args) {
    SpringApplication.run(WebServerApplication.class);
  }

  @GetMapping("/")
  public void index() {

  }

  @PostMapping("/postMessage")
  public void messageHandler(@RequestParam("message") String message) {
    source.output().send(new GenericMessage<>(
        new Message("user", message, LocalDateTime.now())));
  }
}
