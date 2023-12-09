FROM openjdk:11

COPY . .
RUN ./mvnw clean install
RUN mv target/*.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
