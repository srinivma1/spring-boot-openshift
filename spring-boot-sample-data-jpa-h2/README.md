# spring-boot-sample-data-jpa-h2
Demo project for Spring Boot with JPA and persisting H2 database

## Requirements
- Java 8

## Includes
- Spring Boot 1.3.3
  - spring-boot-starter-web: basic web starter
  - spring-boot-starter-thymeleaf: for templating
  - spring-boot-starter-data-jpa: JPA witth Hibernate for DB communication
  - com.h2database:h2: H2 DB connector
- Bootstrap 3.3.6
- JQuery 1.11.3

## Important properties
application.properties
```properties
# JDBC Url to use H2 DB File for persisting
spring.datasource.url:jdbc:h2:./database/samspledb;AUTO_SERVER=TRUE

# Use H2 DB Driver
spring.datasource.driverClassName:org.h2.Driver

# Disable Thymeleaf cache for development
spring.thymeleaf.cache=false
```


## Steps to run and deploy Spring boot application on openshift:
 - First, create two files deployment.yaml and configMap.yaml under src/main/fabric8. Configmap will contain application.properties and then the deployment.yaml will define volume mounts for the same.
 - Add fabric8 io maven plugin in pom.xml as shown in this repo.
 - Second, run mvn clean install -Dfabric8.mode=openshift. Doing this will create an OpenShift BuildConfig and kick off a binary s2i build!
 - Third, run mvn fabric8:deploy -Dfabric8.mode=openshift. Maven plugin will create the appropriate OpenShift DeploymentConfig and use the associated OpenShift ImageStreams that were created from the BuildConfig.

   
