FROM usedtolove/jre8:latest

VOLUME /tmp

#copy executable jar
ADD target/*.jar app/app.jar

#copy all required dependencies
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app

#entrypoint
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
