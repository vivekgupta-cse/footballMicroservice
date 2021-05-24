keytool -genkey -storetype PKCS12 -keyalg RSA -alias footballTrustStore -keystore ftruststore.ks -storepass changeit
keytool -import -alias footballclient -file apiv2.apifootball.com -storetype PKCS12 -keystore ftruststore.ks


To compile:
mvn -f pom.xml clean package

To Run :
java -Djavax.net.ssl.trustStore=ftruststore.ks -Djavax.net.ssl.trustStorePassword=changeit -jar target/Football-Team-Standings-Service-0.0.1-SNAPSHOT.jar

To Create Docker image:
docker build -f Dockerfile -t vivek/footballservice .

To run docker image:
docker run -p 9001:9000 -t --name myfootballservice vivek/footballservice

Sample URL to put in browser:
http://localhost:9001/standings?countryName=France&leagueName=Ligue%202&teamName=Chateauroux

To connect to container:
docker exec -it myfootballservice /bin/sh

