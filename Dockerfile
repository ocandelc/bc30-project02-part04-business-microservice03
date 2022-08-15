FROM openjdk:11.0.15
ARG JAR_FILE=target/bc30-project02-part04-business-microservice03-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8093
ENTRYPOINT ["java","-jar","/app.jar"]