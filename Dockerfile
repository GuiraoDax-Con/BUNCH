# Dockerfile
FROM eclipse-temurin:21-jdk
ARG JAR_FILE=target/BUNCH-0.0.1.jar
COPY ${JAR_FILE} bunch_app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","bunch_app.jar"]