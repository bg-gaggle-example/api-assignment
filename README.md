# api-assignment
Here are some reflections and a bit of an explanation of my work on this assignment.



1. `Create a REST API in Java that returns a JSON payload with 2 fields:
a. message - this field should be a string with the value of “Welcome to the machine.”
b. timestamp - this field should be a string with the value of the current time as an ISO 8701 timestamp`

I used java spring for this assignment.  I referenced the following documentation to implement the first requirement:  
https://spring.io/guides/gs/rest-service/

I had to set up everything fresh on Ubuntu 20.04 LTS machine I had lying around.  I used Atom as the text editor and:  

`java --version`  
`openjdk 11.0.10 2021-01-19
OpenJDK Runtime Environment (build 11.0.10+9-Ubuntu-0ubuntu1.20.04)
OpenJDK 64-Bit Server VM (build 11.0.10+9-Ubuntu-0ubuntu1.20.04, mixed mode, sharing)`  

`mvn -v`  
`Apache Maven 3.6.3
Maven home: /usr/share/maven
Java version: 11.0.10, vendor: Ubuntu, runtime: /usr/lib/jvm/java-11-openjdk-amd64
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "5.8.0-44-generic", arch: "amd64", family: "unix"`



  * `a. message - this field should be a string with the value of “Welcome to the machine.”`  
  achived here: https://github.com/bg-gaggle-example/api-assignment/pull/1  
  * `b. timestamp - this field should be a string with the value of the current time as an ISO 8701 timestamp`  
  also implemented in the above commit featured in that PR.  **note:** ISO 8701 doesn't exist.  As a person usually focused on testing I thought this was humorous or an honest mistake.  Either way, I used ISO 8601 as it's implemented here: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/time/format/DateTimeFormatter.html#ISO_TIME
  
  getting this far, it was nice to see the ability to use `/.mvnw clean package` and `/.mvnw spring-boot:run` start the example API service and return the JSON as requested in this first requirement.
  
  
2. `The project should include automation to perform testing of the code for the API.`  

Fortunately for me, Maven makes it easy to run tests in an automated fashion.  And Spring docs include a nice introduction on how to test your APIs.  I followed this generally: https://spring.io/guides/gs/testing-web/  

You'll find the commit which includes the test under this PR here: https://github.com/bg-gaggle-example/api-assignment/pull/4  

I included two web layer tests and one smoke test just for good measure.

3. `The project should include automation to build the API as a Docker image and automation to test the image.`  

I wrote a simple Dockerfile, again following Spring's documentation here:  https://spring.io/guides/gs/spring-boot-docker/  

PR for the commit which contains the Dockerfile work: https://github.com/bg-gaggle-example/api-assignment/pull/2  

At this point, I could run the following commands and see the json returning while the API container was running:  

`docker build -t springio/api-assignment .`  
`docker run -p 8080:8080 springio/api-assignment`  
`curl --request GET http://localhost:8080/welcome`  

more on this in just a bit.
