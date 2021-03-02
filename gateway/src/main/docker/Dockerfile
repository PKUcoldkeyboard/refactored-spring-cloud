FROM openjdk:8-jdk-alpine

MAINTAINER cuterwrite

ADD gateway-0.0.1-SNAPSHOT.jar gateway.jar

EXPOSE 18001

ENTRYPOINT ["java","-Xms64m","-Xmx512m","-jar","gateway.jar"]