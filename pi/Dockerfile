FROM java:8
COPY ./target/pi-0.0.1-SNAPSHOT.jar /apps/spring_app/
WORKDIR /apps/spring_app
EXPOSE 9000
CMD ["java", "-jar", "pi-0.0.1-SNAPSHOT.jar"]