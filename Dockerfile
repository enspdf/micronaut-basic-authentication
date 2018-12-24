FROM openjdk:8u171-alpine3.7
RUN apk --no-cache add curl
COPY build/libs/*-all.jar auth.jar
CMD java ${JAVA_OPTS} -jar auth.jar