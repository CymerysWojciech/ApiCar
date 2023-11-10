## ApiCar. Homework 3
[![Current Version](https://img.shields.io/badge/version-0.0.1-green.svg)](https://github.com/IgorAntun/node-chat)


### General info

This is a homework for the course "Kurs Spring Boot 2: Tworzenie efektywnych aplikacji internetowych".

The task was to create a REST API for the car database
The vehicle has the following fields: id, mark, model, color. API supports web methods:
to download all items
to retrieve an element by its id
to retrieve elements of a specific color (query)
to add items
to modify positions
to modify one of the item fields
for removing one item
When the application starts, 3 items are to be added.
The application returns data in the form of XML and JSON
Swagger UI is added
HATEOAS is implemented

### Technologies
* Java 17
* Spring Boot
* Gradle
* Base H2
* Swagger UI
* HATEOAS
* Lombok

### How To Use

To clone and run this application, you'll need [Git](https://github.com/CymerysWojciech/ApiCar.git)

```shell
# Clone this repository
git clone https://github.com/CymerysWojciech/ApiCar.git
```
There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `pl.budowniczowie.apicar.ApiCarApplication` class from your IDE.


### Documentation


The application will be available at http://localhost:8084.
#### Car
- Get all products  http://localhost:8084/api/v1/car method GET
- Get car by id http://localhost:8084/api/v1/car/{id} method GET
- Get car by color http://localhost:8084/api/v1/car/?color={name} method GET
- Add car http://localhost:8084/api/v1/products method POST
  {
  "brand": "string",
  "model": "string",
  "color": "string"
  }
- Edit car http://localhost:8084/api/v1/car/{id} method PUT
 {
  "brand": "string",
  "model": "string",
  "color": "string"
  }
- Edit car http://localhost:8084/api/v1/car/{id} method PATCH
  {
  "color": "string" ?,
  "model": "string" ?,
  "color": "string" ?
  }
- Delete car http://localhost:8084/api/v1/car/{id} method DELETE

#### Swagger UI
- http://localhost:8084/swagger-ui.html
- http://localhost:8084/v3/api-docs

#### H2
- http://localhost:8084/h2-console
- JDBC URL: jdbc:h2:mem:mydb
- User Name: user
- Password: password
