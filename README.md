

./mvnw compile quarkus:dev

curl -X PUT --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{
      "name": "Red Grapes",
      "description": "can't eat"}' 'http://localhost:8080/fruits'
      

curl PUT --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{"name": "Red Grapes","description": "can not eat"}' http://localhost:8080/fruits

curl -v http://localhost:8080/fruits
