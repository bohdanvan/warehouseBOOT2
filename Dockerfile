#FROM frolvlad/alpine-oraclejdk8:slim
FROM java:8
EXPOSE 8080
ADD /target/Warehouse.jar Warehouse.jar
#RUN sh -c 'touch Warehouse.jar'
ENTRYPOINT ["java","-jar","Warehouse.jar"]