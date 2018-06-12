# springboot-webservice
Springboot + Docker container: a demo App for restful Webservice based on Springboot

# switched to a different serrver port 8085
application.properties should have "server.port=8085"

# mvn
mvn clean install

# build the container
docker build -f .\Dockerfile -t springboot-webservice .


# run it
docker run -p 8085:8085 springboot-webservice