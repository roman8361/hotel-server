FROM java:8
ADD hotel-server.war .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "hotel-server.war"]