FROM openjdk:8-jre-alpine
COPY target/broker-1.0-SNAPSHOT-jar-with-dependencies.jar /broker-1.0.jar
CMD ["/usr/bin/java", "-jar", "/broker-1.0.jar", "http://dodgydrivers:8081/quotations,http://girlpower:8082/quotations,http://auldfellas:8083/quotations"]
