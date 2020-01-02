FROM openjdk:8
VOLUME /tmp
EXPOSE 8008
ADD ./target/transactions-ms-0.0.1-SNAPSHOT.jar transactions-ms.jar
ENTRYPOINT ["java","-jar","/transactions-ms.jar"]