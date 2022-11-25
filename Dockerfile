#FROM openjdk:11
#EXPOSE 8080
#ADD target spring-boot-docker
#ENTRYPOINT [ "java", "-jar", "./target/spring-boot-docker.jar" ]
FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} spring-boot-docker.jar
ENTRYPOINT ["java","-jar","/spring-boot-docker.jar"]