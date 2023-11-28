FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]