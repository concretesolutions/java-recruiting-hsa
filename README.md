# Desafio Java Concrete

* This project is developed to solve the provision of categories and coupons for the mobile application of e-commerce

## Releases

### Versioning of releases

0.0.1

> Given this version there are the following changes :
>
> 1. Top 5 categories in the **/bff/v1/categories/top-five** endpoint
> 2. Coupons that have not expired in the **/bff/v1/coupons** endpoint
> 3. Remaining categories on the **/bff/v1/categories/remaining** endpoint
> 4. Response filtering for small images of the subcategory model
> 5. Coupon API is unstable and sometimes takes time to respond, 5 second timeout was implemented
> 6. The Categories API responds to a complex model to handle, it responds with the necessary category lists
> 7. Unit tests can be tested in Eclipse with JUnit 4 or 5 and have 95.2% coverage


## Built With

* [Gradle](https://gradle.org/) - Dependency Management
* [Java 8](https://www.java.com/es/download/help/java8.html) - Programming language

## Building the project

It is important to build the project first, this operation has the additional task of copying the created *jar* file and leaving it in the *docker/* folder for later execution with docker.

```Run    
gradle clean build
```

Or

```Run    
./gradlew clean build
```

## Docker Running the project

With the command **cd docker** we position ourselves in the *docker/* folder to build the image and run the container.

```
cd docker
```

```
docker build -t bff-init-page-docker .
```

The image brings by default port 8007 but in our local environment we will display it on port 8080

```
docker run -it -p 8080:8007 bff-init-page-docker
```

## Gradle Running the project

If you do not have Docker installed in your operating system (*in Windows it is usually difficult to install and configure docker*) you can run the application with gradle.

```Run    
gradle bootRun
```

Or

```Run    
./gradlew bootRun
```

Also try testing the project with the following command

```Run    
./gradlew test
```

## Exposed endpoints

These are the curls with which you can test the controllers at runtime.

```  
curl --location --request GET 'http://localhost:8080/bff/v1/categories/top-five'
```

```  
curl --location --request GET 'http://localhost:8080/bff/v1/categories/remaining'
```

```  
curl --location --request GET 'http://localhost:8080/bff/v1/coupons'
```

```  
curl --location --request POST 'http://localhost:8080/bff/v1/categories?topCategories=2' \
--header 'accept: application/json'
```

**Imporant:** The documentation for the endpoints and entities is in the *openapi.yaml* file.

## Authors

* **Jorge Leiva** - *Initial work*