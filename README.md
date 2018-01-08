# Employee Storage Service CodingChallenge

This is coding challenge that I developed to show you my coding and design skills, for example:

1. [Spring MVC](https://github.com/Vedenin/RestAndSpringMVC-CodingChallenge/tree/master/src/main/java/com/github/vedenin/codingchallenge/mvc)

2. [Spring Security](https://github.com/Vedenin/RestAndSpringMVC-CodingChallenge/blob/master/src/main/java/com/github/vedenin/codingchallenge/mvc/security/SpringSecurityConfiguration.java)

3. [Integration with REST service using Java-RS client](https://github.com/Vedenin/RestAndSpringMVC-CodingChallenge/tree/master/src/main/java/com/github/vedenin/codingchallenge/restclient)

4. [Spring Rest Service](https://github.com/Vedenin/RestAndSpringMVC-CodingChallenge/blob/master/src/main/java/com/github/vedenin/codingchallenge/mvc/controler/MainRestController.java) 

5. [Spring Boot](https://github.com/Vedenin/RestAndSpringMVC-CodingChallenge/blob/master/src/main/java/com/github/vedenin/codingchallenge/Application.java)

6. [JPA](https://github.com/Vedenin/RestAndSpringMVC-CodingChallenge/tree/master/src/main/java/com/github/vedenin/codingchallenge/persistence)

6. [Hibernate](https://github.com/Vedenin/RestAndSpringMVC-CodingChallenge/tree/master/src/main/java/com/github/vedenin/codingchallenge/persistence)  

7. [H2 database](https://github.com/Vedenin/RestAndSpringMVC-CodingChallenge/tree/master/src/main/java/com/github/vedenin/codingchallenge/persistence)  

8. [MockMvc](https://github.com/Vedenin/RestAndSpringMVC-CodingChallenge/tree/master/src/test/java/com.github.vedenin.codingchallenge)

9. [Thymeleaf](https://github.com/Vedenin/RestAndSpringMVC-CodingChallenge/tree/master/src/main/resources/templates)

10. [Java Script](https://github.com/Vedenin/RestAndSpringMVC-CodingChallenge/tree/master/src/main/resources/templates) 

## Coding Challenge Requirements 

## Requirement Specification

### Definition

We're building an employee storage service for companies. 

A company admin needs to be able to:
- create employee records for company,
- view them in a list and detail view for company, 
- update the employee records and delete them for company,
- find the average salary for the company

Your task is to build the backend for this service. 

It should be a rest API that exposes the required endpoints.

The company data can either be autogenerated or configurable or dynamically created. (Up to you)

> Nice to have 1: Build a frontend for the rest api

> Nice to have 2: Use jvm based technologies

### Data definition

- Employee model
  - Name
  - Surname
  - email
  - address
  - salary
  - company id
  
- Company model
  - Name

### Delivery

A publicly available git repository with a README.md that explains how to compile, build and start the project.

## My soulution 

#### How run in IDE (Eclipse, Idea)

1. Run 
     "mvn clean install"
     
2. Run Application.class in any Java IDE

#### How run using jar file and Spring Boot 
1. Run 
     "mvn clean install"
     
2. Run Application.class in codingchallenge-1.0-SNAPSHOT.jar, for example 

   java -jar target/codingchallenge-1.0-SNAPSHOT.jar
    
See more info in [Spring Boot documentation](http://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-running-your-application.html)

#### How see result in web
Use following link: [https://currency-convector.herokuapp.com/](https://currency-convector.herokuapp.com/)
