# workshop-ddd


Spring boot application with domain driven design example.

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

## Layers

### Interfaces
How you can deliver your software. </br>
e.g.: Rest Controllers, Raw Servlets, Swing Views. </br>
Implementation example: PaymentController

### Application
Where your use cases are orchestrated and the transactional scopes are managed. </br>
e.g.: Payment process. </br>
Implementation example: PaymentProcessManager (Interface) / PaymentProcessManagerImpl (protected Impl)

### Domain
Where your business rules are handled. </br>
e.g.: Payment process: (request payment, authorize payment, confirm payment, cancel payment, etc). </br>
Implementation example: Payment (AggregateRoot)

### Infrastructure
This layer acts as a supporting library for all the other layers. </br>
e.g.: SQL Tables representation, SQL Repositories implementation, i18n, serialization, validators,  etc. </br>
Implementation example:
* persistence package
* i18n package
* serialization package
* validation package
