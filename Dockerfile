FROM openjdk:17-alpine
ADD target/*.jar springapp.jar
ENTRYPOINT [ "java" , "-jar" , "springapp.jar"]