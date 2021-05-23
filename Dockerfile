# Create an Image
FROM openjdk:8-jdk-alpine
WORKDIR /home/footballrestapiapp
ARG TRUST_STORE=ftruststore.ks
COPY ${TRUST_STORE} /home/footballrestapiapp/

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /home/footballrestapiapp/
EXPOSE 9000
ENTRYPOINT ["sh", "-c", "java -Djavax.net.ssl.trustStore=ftruststore.ks -Djavax.net.ssl.trustStorePassword=changeit -jar Football-Team-Standings-Service-0.0.1-SNAPSHOT.jar"]

