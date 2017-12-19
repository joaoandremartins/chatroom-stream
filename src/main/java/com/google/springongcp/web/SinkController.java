package com.google.springongcp.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class SinkController {

  private static final Log LOGGER = LogFactory.getLog(SinkController.class);

  @StreamListener(Sink.INPUT)
  public void processMessage(String message) {
    LOGGER.info("Message received: " + message);
  }
}
