FROM openjdk:17-jdk

COPY target/hr_Labsoft.jar .

EXPOSE 8085

ENTRYPOINT ["java", "-jar", "hr_Labsoft.jar"]