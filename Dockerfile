FROM openjdk:8
ADD target/springboot-webservice.jar springboot-webservice.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "springboot-webservice.jar"]