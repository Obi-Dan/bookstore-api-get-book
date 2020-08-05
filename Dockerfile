FROM openjdk:16-slim
COPY build/libs/bookstore-api-get-book-0.0.1-SNAPSHOT.war /app.war
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.war"]


# docker build -t danshoff/bookstore-api-get-book .
# docker run -p 49160:8080 -d --rm danshoff/bookstore-api-get-book