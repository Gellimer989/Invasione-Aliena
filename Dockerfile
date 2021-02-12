FROM openjdk:14

RUN mkdir /artifact
RUN cd artifact

WORKDIR /artifact

RUN apt update
RUN apt install curl

RUN apt-get install -y libxrender1 libxtst6 libxi6

RUN curl -L -H "Accept: application/vnd.github.v3+json" -H "Authorization: "  --output game.zip

RUN unzip game.zip

CMD ["java", "-jar", "CHROME_DINO.jar"]
