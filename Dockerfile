FROM openjdk:17-jre-slim

WORKDIR /app
COPY target/GerenciamentoDeCompras-0.0.1-SNAPSHOT.jar /app/GerenciamentoDeCompras-0.0.1-SNAPSHOT.jar.jar
EXPOSE 8080

CMD ["java", "-jar", "target/GerenciamentoDeCompras-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=dev"]
