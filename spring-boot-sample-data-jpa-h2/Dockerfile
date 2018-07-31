FROM openjdk:8u131-jre-alpine
VOLUME /tmp
ADD /target/spring-boot-sample-data-jpa-h2-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT exec java $JAVA_OPTS -jar /app.jar