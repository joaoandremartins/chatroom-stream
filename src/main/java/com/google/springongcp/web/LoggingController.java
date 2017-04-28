package com.google.springongcp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import java.util.logging.Logger;

/**
 * Created by joaomartins on 4/26/17.
 */
@EnableBinding(Sink.class)
@EnableAutoConfiguration
public class LoggingController {
  private Logger logger = Logger.getGlobal();
  @Autowired private Sink sink;

  @StreamListener(Sink.INPUT)
  public void processMessage(Message message) {
    logger.info(message.getBody());
  }
}
