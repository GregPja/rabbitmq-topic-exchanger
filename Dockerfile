FROM adoptopenjdk/openjdk11

ADD build/libs/consumer-0.0.1-SNAPSHOT.jar consumer.jar


ENTRYPOINT exec java $JAVA_OPTS -jar consumer.jar
