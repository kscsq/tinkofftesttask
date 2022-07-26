FROM jdk-11.0.11_9-alpine

EXPOSE 8080

COPY ./target/tinkofftesttask-1.0-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app/

ENTRYPOINT ["java", "-jar", "tinkofftesttask-1.0-SNAPSHOT.jar"]
