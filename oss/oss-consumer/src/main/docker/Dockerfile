FROM openjdk:8-jdk-alpine

MAINTAINER cuterwrite

ADD oss-consumer-0.0.1-SNAPSHOT.jar oss-consumer.jar

EXPOSE 19000

ENTRYPOINT ["java","-Xms64m","-Xmx128m","-jar","oss-consumer.jar"]