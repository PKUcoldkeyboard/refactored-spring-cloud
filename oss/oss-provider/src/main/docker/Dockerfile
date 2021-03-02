FROM openjdk:8-jdk-alpine

MAINTAINER cuterwrite

ADD oss-provider-0.0.1-SNAPSHOT.jar oss-provider.jar

EXPOSE 18002

ENTRYPOINT ["java","-Xms64m","-Xmx128m","-jar","oss-provider.jar"]