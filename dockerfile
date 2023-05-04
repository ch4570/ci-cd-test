### 주석 필요 ###

FROM openjdk:11
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} example.jar
ENTRYPOINT ["java", "-jar", "/example.jar"]