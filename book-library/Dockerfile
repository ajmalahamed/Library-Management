FROM openjdk:17
EXPOSE 9200
ADD "target/book-library.jar" "book-library.jar"
ENTRYPOINT [ "java", "-jar", "/book-library.jar" ]