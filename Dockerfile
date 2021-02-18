FROM openjdk:8

RUN mkdir /artifact
RUN cd artifact

WORKDIR /artifact
RUN apt update
RUN apt install curl

RUN apt-get install -y libxrender1 libxtst6 libxi6
RUN apt install -y  p7zip-full

RUN curl -L -H "Accept: application/vnd.github.v3+json" -H "Authorization:token <MYTOKEN> >" https://api.github.com/repos/Gellimer989/AutomatedSW/actions/artifacts/41171619/zip --output artifact.zip

RUN 7z x artifact.zip

CMD ["java", "-jar", "InvasioneAliena-1.0-SNAPSHOT.jar"]
