FROM openjdk:17
EXPOSE 9300
ADD "target/admin-library.jar" "admin-library.jar"
ENTRYPOINT [ "java", "-jar", "/admin-library.jar" ]