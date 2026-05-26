# Use lightweight JDK image
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy jar (adjust name if needed)
COPY build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]