# workshop-ddd

This branch is a demonstration for payment implementation without DDD

## Dependencies
* JDK 1.8
* MySQL 5.7
* Spring Boot 2.1.9
* Gradle 5.6.2 (optional)

## Requirements
* IntelliJ IDEA (with Spring framework plugin enabled)

## Code structure
```
/spec               - Jetbrains Http Request files, used to test RESTful API
/src/main/java      - java source code
/src/main/resources - config, static resources
/test               - test code (todo)
```

## Project structure
### Spring boot application
This is a standard Spring boot application, see `DddWorkshopApplication`
### Controllers
This demo focus on how to process payment in general with RESTful API via POST.
The controller map in `PaymentController`

And there is a `DefaultExceptionHandler` to handle modle validation error or other internal errors
### Business
Here place the core business
### Model
View model for representing input/output arguments or errors
### Utils
Include i18n, input validation etc.