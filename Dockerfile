FROM openjdk:11

ARG PROFILE
ARG ADITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPS}

WORKDIR /opt/starwars.jar starwars-0.0.1-SNAPSHOT.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 8080

CMD java ${ADDITIONAL_OPS} -jar starwars-0.0.1-SNAPSHOT.jar --spring.profiles.active=${PROFILE}