FROM eclipse-temurin:17
RUN apt-get update && apt-get -y upgrade
RUN apt-get install -y dos2unix
#TODO: narrow this down
ENV HOME=/weedbuddy-api
RUN mkdir -p $HOME
WORKDIR $HOME