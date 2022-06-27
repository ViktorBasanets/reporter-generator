FROM openjdk:15-alpine
ENV STORY_POINT=28800
VOLUME /tmp/reporter
ADD target/reporter-generator-1.0-SNAPSHOT-jar-with-dependencies.jar reporter.jar
COPY src/main/resources/input-data.csv /tmp/reporter/
ENTRYPOINT ["java", "-jar", "/reporter.jar"]
CMD ["/tmp/reporter/input-data.csv"]
