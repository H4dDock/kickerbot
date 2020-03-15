FROM openjdk:11
ADD target/kicker-bot-spring.jar kicker-bot-spring.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "kicker-bot-spring.jar"]