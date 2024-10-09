FROM openjdk:21-jdk
WORKDIR /app
COPY build/libs/*.jar /app/app.jar
EXPOSE 8060
CMD ["java", "-jar", "./app.jar"]