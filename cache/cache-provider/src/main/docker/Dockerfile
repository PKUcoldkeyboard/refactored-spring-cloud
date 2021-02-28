FROM openjdk:8-jdk-alpine

MAINTAINER cuterwrite

ADD cache-provider-0.0.1-SNAPSHOT.jar cache-provider.jar

EXPOSE 18000

ENTRYPOINT ["java","-Xms64m","-Xmx512m","-jar","cache-provider.jar"]