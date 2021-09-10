# simple-fake-bank

## Table of content
- [Introduction](#introduction)
- [Technologies Used](#technologies-used)
- [Swagger](#swagger)
- [Commands](#commands)
- [API Documentation](#api-documentation)
- [Github Actions](#github-actions)
- [Contact Information](#contact-information)

## Introduction

This project contains an application which can be used to:
- Create a new bank account with an initial deposit for a customer.
  - A single customer may have multiple accounts.
- Transfer amounts between two accounts, including those owned by different customers.
- Retrieve balance for a given account.
- Retrieve transaction history for a given account.

## Technologies Used

- Java 11
- [SpringBoot](https://start.spring.io/): Used to create easy stand-alone, production-grade Spring based Applications.
- [H2 database engine](https://www.h2database.com/html/main.html): Embedded relational database
- [Maven](https://maven.apache.org/): Apache Maven is a software project management and comprehension tool. Based on the concept of a project object model (POM), Maven can manage a project's build, reporting and documentation from a central piece of information.
- [Swagger](https://swagger.io/): Swagger is an Interface Description Language for describing RESTful APIs expressed using JSON. Swagger is used together with a set of open-source software tools to design, build, document, and use RESTful web services. Swagger includes automated documentation, code generation, and test-case generation.
- [Git Actions](https://docs.github.com/en/actions): GitHub Actions helps automate tasks within the software development life cycle. GitHub Actions are event-driven, meaning that you can run a series of commands after a specified event has occurred. They happen directly on the Github repo itself.

## Swagger
Following are the available endpoints

>1. POST http://localhost:8080/v1/accounts
Creates a new account

Input:

```
{
"initial_amount": 0,
"user_id": 0
}
```

Output:

```
{
  "body": {},
  "statusCode": "ACCEPTED",
  "statusCodeValue": 0
}
```

>2. GET http://localhost:8080/v1/accounts/{id}
Retrieves the account balance

Output:

```
{
  "account_id": 0,
  "balance": 0,
  "created_at": "2021-04-01T17:26:40.264Z"
}
```

>3. POST http://localhost:8080/v1/operations
Creates a transfer between accounts

Input:

```
{
  "receiver_account_id": 0,
  "sender_account_id": 0,
  "value": 0
}
```

Output:

```
{
  "body": {},
  "statusCode": "ACCEPTED",
  "statusCodeValue": 0
}
```

>4. GET http://localhost:8080/v1/operations/fromAccount/{accountId}
Get the history of operations for the provided account Id.

Output:

```
{
  "account_id": 0,
  "created_at": "2021-04-01T17:29:13.493Z",
  "operations": [
    {
      "created_at": "2021-04-01T17:29:13.493Z",
      "operation_id": 0,
      "receiver_account_id": 0,
      "sender_account_id": 0,
      "value": 0
    }
  ]
}
```

## Commands
To compile and test, please execute
> mvn clean install

To run the application, please execute
> mvn spring-boot:run

## API Documentation
In order to read the API documentation in Swagger, please first start the application and the visit [API Documentation in Swagger](http://localhost:8080/swagger-ui/)


## Github Actions
To ensure the correctness of the code committed, github action for 'building the java project using Maven' is used. This ensures that all tests are green and the projects runs correctly on Windows, MacOS and Linux systems.

## Contact Information

How to reach me? At [github specific gmail account](mailto:syedumerahmedcode@gmail.com?subject=[GitHub]%20Hello%20from%20Github). Additionally, you can reach me via [Linkedin](https://www.linkedin.com/in/syed-umer-ahmed-a346a746/) or at [Xing](https://www.xing.com/profile/SyedUmer_Ahmed/cv)

Original idea for this project came from [Joao Carlos Sousa do Vale](https://github.com/jcarlosvale)



