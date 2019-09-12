
# Start lockally
./mvnw compile quarkus:dev

# get command
curl GET --header 'Content-Type: application/json' --header 'Accept: application/json' http://localhost:8080/instrument

# set environment variable which will be used in the microservice
export INSTRUMENT_ID=hupe_02

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
kubectl apply -f <(istioctl kube-inject -f src/main/docker/piano1.yaml)
kubectl apply -f <(istioctl kube-inject -f src/main/docker/piano2.yaml)

## Service: not needee anymore because it is contained in the mircoservice
kubectl apply -f <(istioctl kube-inject -f src/main/docker/service_piano_01.yaml)
kubectl apply -f <(istioctl kube-inject -f src/main/docker/service_piano_02.yaml)

# switch namespace 
gcloud container clusters get-credentials istio-k8s-cluster-2 --zone  us-central1-a --project hack-istio-2019

gcloud container clusters get-credentials istio-k8s-cluster-3 --zone  us-central1-a --project hack-istio-2019

# for testing loadbalancing using following files
*-deploy.yaml
*ExternalServices.yaml
*Service.yaml

# name
Peter Gabriel  Jörg Tobi Mikhail Johannes Tobias Raphael