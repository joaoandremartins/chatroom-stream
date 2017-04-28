# chatroom-stream

Toy app that logs messages sent from HTML through Spring Cloud Data Stream.

## Apache Kafka

Before running the app, you need to have Apache Kafka running on your machine.

1. Download Apache Kafka from the [Kafka downloads page](https://kafka.apache.org/downloads) and extract the archive contents.
1. Start the Kafka Zookeeper (some kind of broker discovery service). 
   * bin/zookeeper-server-start.sh config/zookeeper.properties
1. Start the Kafka server.
   * bin/kafka-server-start.sh config/server.properties
