# Use a Java base image
FROM openjdk:8-jdk-alpine

WORKDIR /app

COPY ./out/artifacts/ecommerceSpringMVC_jar/ecommerceSpringMVC.jar app.jar

EXPOSE 8083

CMD ["java", "-jar", "app.jar"]