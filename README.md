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

```Run    
gradle clean build
```

Or

```Run    
./gradlew clean build
```

## Running the project

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

## Authors

* **Jorge Leiva** - *Initial work*