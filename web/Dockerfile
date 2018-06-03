FROM java:8
COPY ./target/web-0.0.1-SNAPSHOT.jar /apps/spring_app/
WORKDIR /apps/spring_app
EXPOSE 8080
CMD ["java", "-jar", "web-0.0.1-SNAPSHOT.jar"]