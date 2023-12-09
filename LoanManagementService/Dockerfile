FROM openjdk:11

COPY . .
RUN ./mvnw clean install
RUN mv target/*.jar /app.jar
COPY wait-for-it.sh /app/wait-for-it.sh

ENTRYPOINT ["/app/wait-for-it.sh", "config-service:8888", "--"]
CMD ["java", "-jar", "/app.jar"]