FROM openjdk:21

EXPOSE 8282

VOLUME /tmp

COPY target/demo-jenkins-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar", "/app.jar"]
