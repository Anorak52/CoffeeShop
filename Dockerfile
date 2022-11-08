FROM amazoncorretto:17-alpine3.16-jdk
WORKDIR /app
EXPOSE 8888
COPY target/zerno-0.0.3.jar zerno-0.0.3.jar
ENTRYPOINT ["java","-jar","/app/zerno-0.0.3.jar"]