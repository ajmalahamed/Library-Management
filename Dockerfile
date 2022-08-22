FROM openjdk:17
VOLUME /tmp
EXPOSE 8761
ADD target/*.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=filr:/dev/./urandom -jat /app.jar" ]