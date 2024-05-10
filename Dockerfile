FROM openjdk:17-jdk-slim

WORKDIR /app

COPY pom.xml /app
COPY testng.xml /app
COPY . /app

RUN apt-get update && \
    apt-get install -y \
        maven \
        git \
        wget && \
    wget -qO- https://github.com/allure-framework/allure2/releases/download/2.21.0/allure-2.21.0.tgz | tar -xz -C /opt/ && \
    ln -s /opt/allure-2.21.0/bin/allure /usr/bin/allure

RUN mvn clean compile

CMD ["mvn", "clean", "test"]