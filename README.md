# Spring Cloud Bootstrap
This is a repository for study-only purposes, containing some bootstraps and sample applications. This code was based on the tutorials https://www.baeldung.com/spring-cloud-bootstrapping and https://spring.io/guides/gs/centralized-configuration/

## Architecture
Spring Boot 2.1.6
Spring Cloud Greenwich
Maven 3.6
Lombok
Java 8

## Project Organization
The project contains the server projects: config-server, discovery and gateway; and also the clients: book-service, rating-service and client-refresh. 

<li>The directory `application-config` is a git repository that contains the property files for all applications</li>
<li>`Config-server` is the configuration server which provides the properties from the git repository (based on application-config)</li>
<li>`Discovery` is the Eureka name discovery server in which all the projects should be registered</li>
<li>`Gateway` is the Zuul server acting as a reverse-proxy for name resolve</li>
<li>`Book-service` and `Rating-service` are two sample web projects offering Rest endpoints</li>
<li>Finally, `Client-refresh` is a web project that exposes the `message` property in config file and can be refreshed as the message changes</li>

## Usage
First you need to checkout the repository and compile each project. Then, move the folder `application-config` to your ${HOME} directory (C:\Users\{your-user} on Windows and /home/{your-user} on Unix) and do `git init`, `git add .` and `git commit -m 'your commit message'` into it. This will prepare the repository with the config property files for `Config-server` server.
After that, start the servers with `mvn spring-boot:run` following this order and waiting each one stay up to proceed to the next (this is important!): config-server, discovery and gateway. Once they are up, you can start any client sample you want with `mvn spring-boot:run`.

You can check the properties of each project by accessing http://localhost:8081/{application-name}/{profile}, like http://localhost:8081/book-service/default to read the propeties of `book-service` client. Also, for the `Config-server` project the `/env` actuator is enabled. Moreover, the actuator `/refresh` is enable for `Client-refresh` allowing the refresh properties call through 
`$ curl localhost:8085/actuator/refresh -d {} -H "Content-Type: application/json"`

## Notes
It is fundamental to init the repository and commit each file to get the properties file available on `Config-server`. 
Pay attention on all the service names. They are used for the identification and bind in Eureka and Zuul servers. 

To know more about each technology, visit
<li>https://spring.io/projects/spring-cloud-config</li>
<li>https://spring.io/projects/spring-cloud-netflix</li>
