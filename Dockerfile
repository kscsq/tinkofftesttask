FROM openjdk:11

EXPOSE 8080

COPY ./target/tinkofftesttask.jar /usr/app/

WORKDIR /usr/app/

ENTRYPOINT ["java", "-jar", "tinkofftesttask.jar"]
