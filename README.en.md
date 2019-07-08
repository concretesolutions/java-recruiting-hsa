# Java Concrete Challenge Proposal
This project is a proposal for the Recruitment Challenge. All the implementation can be found in the **challenge** branch. There is another branch named **challenge-jenkins-flutter**, and is an attempt to build Jenkins with Flutter. Sadly, since the server machine for that requires at least 4Gb (which are unavailable at the time), that part was left aside.

# Scenario Analysis
At a preliminar analysis, the client requires a mobile app focused from low-end to high-end devices. As mentioned from [Google](https://developer.android.com/about/dashboards) recently, about the 99% of devices, at least, uses a JellyBean (API 16) Android Version. And, as it's mentioned in the documentation of [Flutter](https://flutter.io/faq/#what-devices-and-os-versions-does-flutter-run-on), it has compatibility from this version onwards.

There is another point mentioned in the requirement, and that is the considerations regarding the current backend. There are 2 observations made:

1) The backend depends of the legacy technologies, and that causes that all the time, with the Coupons Backend, there is a considerable amount of wait time in the response (~10 seconds in the worst of the cases).

![Coupons Response Time](https://lh3.googleusercontent.com/L8qBuy3xLSy3BbNVjphnGnqQXx1-FvDza4PpEvPZZHPbrCQtlZynpIrtKYI_TLcMWXpTT5s8tsj1=s800 "Coupons Response Time")

- The structure of some backends elements have a complexity in the model. For example, the Categories element have 4 Subcategories levels. And most of them have a very similar structure, with some difference in the attributes.

![Except of some attributes, the Categories are very similar.](https://lh3.googleusercontent.com/tz81ljD3lgjJ3stG8kvk9jW-XIUm1vgswH4sV4oTFX3bCm1bZyEracdY9X4ai-t-D60KkL-QX9Oi=s800 "Except of some attributes, the Categories are very similar.")

# Proposal

Considering the analysis, here's my proposal.

## Application & Patterns

Regarding the first point, the Mobile Application is going to be built with Flutter. And with the API server, i'm going to consider the following:

1) The data is going to be fetched and cached with  ***Memoization***. 
2) The data model are going to be only built with 2 DTO's: *Coupons* and *Categories*. Categories will contain all the attributes and it will only show the non-null data.

## Model

![Server Model](https://lh3.googleusercontent.com/xAe1dyla8MyW1oKDJs8rkYIQnNh8W4EJlEflYoacrOFHKQ1Vb9szaPs3iOfYwrGCpUt5GkMRJUmf=s800 "Server Model")

## UI

The Server API will going to have a documentation built with Swagger. For the mobile part, there is going to be built with a welcome screen and 1 screeen with the carrousels.

## Tools

- Flutter y Android Studio for Mobile
	> For development purpose, the **Jelly Bean (API 16)** is going to be used.
- Java 8 w/Spring Boot & Gradle. Documentation w/Swagger.
	> The server contains JUnit Tests.
- Docker, Docker-Compose, Jenkins & Tomcat
	> This is for the following automated tasks: Build, Test and Server Deploy. 
	
# Installation Rules

1) [Server API (Development)](https://github.com/pperez-accenture/java-recruiting-hsa/tree/challenge/java/challenge/)
2) [Mobile (Development)](https://github.com/pperez-accenture/java-recruiting-hsa/tree/challenge/flutter/challenge)
3) [Docker](https://github.com/pperez-accenture/java-recruiting-hsa/tree/challenge/docker)

# Special

For development purposes, there is available a personal Jenkins and Tomcat to test the compilation and deploy the result. You can check the credential [here](https://myoffice.accenture.com/:w:/g/personal/p_perez_bustos_accenture_com/ERSCKifF2IRCn622gsSo0D8BQMuYZLiNkrl8D4CPSnZI2A?e=3lr4Vp) (requires Organization credentials): 