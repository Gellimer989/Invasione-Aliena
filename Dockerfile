FROM openjdk:14

RUN mkdir /artifact
RUN cd artifact

WORKDIR /artifact

RUN apt update
RUN apt install curl

RUN apt-get install -y libxrender1 libxtst6 libxi6

<<<<<<< HEAD
RUN curl -L -H "Accept: application/vnd.github.v3+json" -H "Authorization: token 3778149e58ad85a9b3abe510d05f1a17824e10ef" https://api.github.com/repos/Gellimer989/AutomatedSW/actions/artifacts/40678491 --output InvasioneAliena.zip
=======
RUN curl -L -H "Accept: application/vnd.github.v3+json" -H "Authorization: "  --output game.zip
>>>>>>> e286536dd9291523f29450e1b721a72deafde601

RUN unzip InvasioneAliena.zip

<<<<<<< HEAD
CMD ["java", "-jar", "InvasioneAliena.jar"]
=======
CMD ["java", "-jar", "CHROME_DINO.jar"]
>>>>>>> e286536dd9291523f29450e1b721a72deafde601
