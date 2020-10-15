# Concrete Mobile App
This is the thechnical test

# Getting Started

### Reference Documentation
The project is running on localhost:8080

The API documentation is located in http://localhost:8080/swagger-ui.html

the client endpoint is configured on ```application.properties``` file with this params

```category.url.service``` : the client endpoint for category service   
```coupons.url.service``` : the client endpoint for coupons service   


### Docker File

Build docker file:

```docker build --build-arg JAR_FILE=build/libs/*.jar -t concrete/mobile-app .```

Run docker container:

```docker run -p 8080:8080 concrete/mobile-app```