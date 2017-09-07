package com.google.springongcp.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.support.GenericMessage;

//@EnableBinding(Processor.class)
public class ProcessorController {

  @Autowired
  private Processor processor;

  private static final Log LOGGER = LogFactory.getLog(ProcessorController.class);

  @StreamListener(Processor.INPUT)
  public void processor(String message) {
    processor.output().send(new GenericMessage<Object>(message));
    LOGGER.info("Message processed: " + message);
  }
}
