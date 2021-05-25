__________________________________________________________________________________
To create a keystore and to put certificate into it (For using it as trust-store)
__________________________________________________________________________________
keytool -genkey -storetype PKCS12 -keyalg RSA -alias footballTrustStore -keystore ftruststore.ks -storepass changeit
keytool -import -alias footballclient -file apiv2.apifootball.com -storetype PKCS12 -keystore ftruststore.ks

__________________________________________________________________________________
RUNNING WITHOUT DOCKER:
__________________________________________________________________________________
To compile:
mvn -f pom.xml clean package

To Run :
java -Djavax.net.ssl.trustStore=ftruststore.ks -Djavax.net.ssl.trustStorePassword=changeit -jar target/Football-Team-Standings-Service-0.0.1-SNAPSHOT.jar

Sample URL to put in browser:
http://localhost:9000/standings?countryName=France&leagueName=Ligue%202&teamName=Chateauroux

__________________________________________________________________________________
RUNNING WITH DOCKER:
__________________________________________________________________________________

To compile:
mvn -f pom.xml clean package

To Create Docker image:
docker build -f Dockerfile -t vivek/footballservice .

To run docker image:
docker run -p 9001:9000 -t --name myfootballservice vivek/footballservice
or
docker run -p 9001:9000 -d --name myfootballservice vivek/footballservice

Sample URL to put in browser:
http://localhost:9001/standings?countryName=France&leagueName=Ligue%202&teamName=Chateauroux

To connect to container:
docker exec -it myfootballservice /bin/sh


__________________________________________________________________________________

Git commands for reference:
__________________________________________________________________________________
git config --global user.email "vivekgupta333@gmail.com"
git config --global user.name "Vivek Gupta"
git add .
git commit -m "updated code"
git push origin main

__________________________________________________________________________________

Jenkins commands for reference:
__________________________________________________________________________________

To start Jenkins container:
docker-compose up
