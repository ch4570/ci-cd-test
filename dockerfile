FROM openjdk:11
WORKDIR /backend-rex-bucket
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} spring.jar
ENTRYPOINT ["java","-jar","/spring.jar"]