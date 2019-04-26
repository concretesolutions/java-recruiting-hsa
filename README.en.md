# Backend Code Challenge

Code challenge designed to evaluate technical knowledge of **Backend** candidates.  

## Content
- [The Challenge](#the-challenge)
    - [Scenario](#scenario)
    - [APIs](#apis)
    - [Features](#features)
    - [To Take in Consideration](#to-take-in-consideration)
- [What We Would Like To See](#what-we-would-like-to-see)
    - [Nice To Have](#nice-to-have)
    - [Technology Stack](#technology-stack)
- [Submission Guidelines](#submission-guidelines)
- [Attention](#attention)

## The Challenge

### Scenario
You're part of a team that develops a mobile e-commerce for a huge company.  
This project will target **powerful devices** and also devices with **low memory and process capabilities**.  
The customer already has a established backend containing all business rules and information but, some systems rely on **legacy technologies** and may be **unstable** too.  
**You** are responsible to build the **API** that will integrate with these services and provide all information needed by Mobile.  
For the next interactions, the team will work on the **Home Screen**  
and you must build all required **endpoint(s)** that will integrate with these services and provide the information needed by this screen.

### APIs
You will need to integrate with the following APIs:
- **Categories**: [https://cs-hsa-api-categories.herokuapp.com/docs](https://cs-hsa-api-categories.herokuapp.com/docs).  
- **Coupons**: [https://cs-hsa-api-coupons.herokuapp.com/docs](https://cs-hsa-api-coupons.herokuapp.com/docs)

### Features
Mobile needs to build a home screen that will show: 

- Carousel with **Top 5** categories;  
- Carousel with coupons that the expiration date is still valid;  
- Grid with all **remaining** categories;
- Mobile does not need all images from categories model, but only the **icon** and the **smaller image**. You may need to filter some fields in your response, if you like.

### To Take in Consideration
- Coupons API is **unstable** and sometimes takes too long to respond;
- Categories API returns a model that seems hard to handle. 

## What We Would Like To See
You are free to implement this solution the way you like taking in consideration only 
the scenario, project target, performance implications and proposed technology stack described below.
- We are very focused in **quality** in our projects and we would like to a test strategy applied. You can use test type like, for example **Unit Tests**;
- The services are unstable and we don't want the user experience degrading because an API takes too long to respond;
- **1 week to complete the challenge**. If you need more time, no problem, talk to us and we will see what you can do :)

### Nice To Have
- An API documentation would be good. Suggestion: [Swagger](https://swagger.io/); 
- Running with [Docker](https://www.docker.com/).

### Technology Stack
- **Java 8** or **newer** versions;
- Any Web Framework. Suggestion: [Spring Boot](https://spring.io/projects/spring-boot);
- Any API Client. Suggestion: [Feign](https://github.com/OpenFeign/feign);
- Preferable [Gradle](https://gradle.org/) as the build system;
- You are free to choose the test libraries and frameworks you like. The stack we suggest is: [JUnit](https://junit.org/junit5/), [Mockito](https://site.mockito.org/).

---

## Submission Guidelines
Follow the steps below to implement and submit this code challenge: 
- Fork this repository. Check this guide for how to fork on Github: [How to Fork a repository](https://help.github.com/en/articles/fork-a-repo);
- Implement the proposed challenge; 
- After completing the challenge, open a **Pull Request** to this repository, using **Github** interface. [Check this guide for more details](https://help.github.com/en/articles/creating-a-pull-request-from-a-fork);
- If possible, let your repository public to make code review easier :)

## ATTENTION
Do **NOT** try to PUSH direct to THIS repository!

---
