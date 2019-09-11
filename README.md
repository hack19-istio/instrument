

./mvnw compile quarkus:dev

curl -X PUT --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{
      "name": "Red Grapes",
      "description": "can't eat"}' 'http://localhost:8080/fruits'
      

curl PUT --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{"name": "Red Grapes","description": "can not eat"}' http://localhost:8080/fruits

http://localhost:8080/instrument

# Install:
## maven build:
mvn package

## docker build
docker build -f src/main/docker/Dockerfile.jvm -t gregerrag/istio-instrument .

## Docker run
docker run -i --rm -p 8080:8080 gregerrag/istio-instrument

## Docker push
docker push gregerrag/istio-instrument

## microservices install:
kubectl apply -f <(istioctl kube-inject -f src/main/docker/deploy.yaml)
kubectl apply -f <(istioctl kube-inject -f src/main/docker/piano_01.yaml)
kubectl apply -f <(istioctl kube-inject -f src/main/docker/piano_02.yaml)

## Service:
kubectl apply -f <(istioctl kube-inject -f src/main/docker/service_piano_01.yaml)
kubectl apply -f <(istioctl kube-inject -f src/main/docker/service_piano_02.yaml)