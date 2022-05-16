# university-management

[![LinkedIn][linkedin-shield]][linkedin-url] 

<!-- PROJECT LOGO -->
<br />
<p align="center">
  <h3 align="center">Spring Boot University Management</h3>
  <br />
 
  <p align="center">
    <br />
    ·
    <a href="https://github.com//kivancbeser/university-management/issues">Report Bug</a>
    ·
    <a href="https://github.com//kivancbeser/university-management/issues">Request Feature</a>
  </p>
</p>

<!-- TABLE OF CONTENTS -->
## Table of Contents

* [About the Project](#about-the-project)
  * [Built With](#built-with)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
* [Usage](#usage)
* [Explore Rest APIs](#explorerestapis)
  * [Professor](#professor)
  * [Course](#course)
  * [Schedule](#schedule)
  * [Department](#course)
* [Done](#done)
* [TODO](#todo)
* [Roadmap](#roadmap)
* [Contributing](#contributing)
* [License](#license)
* [Contact](#contact)

<!-- ABOUT THE PROJECT -->
## About The Project
<a href="https://github.com/kivancbeser/university-management/searchRequest.jpg">
      <img src="/searchRequest.jpg" alt="Search Api">
 </a>
 
It was created for the purpose of a web project from database to user. 
You can see the done features in [Done](#done) sections.

## Design Considerations
When design the application, Although it is a simple application, I preferred to do it with hibernate.
Because when a big project arrives, I think that using jdbc increases the maintenance cost in the future.

## Scalability
When I want to increase the scalability, I can containerizing the application by using Docker.

## Testing
I preferred to write end-to-end tests and check whether the apis work correctly.
I plan to add my unit tests that will provide at least 85% coverage to the project.

Improvement
You can see the done features in [Todo](#todo) sections.
* Input Validations 
* Swagger
* Add pagenumber for lazyload. 
* More comment for spring side.
* Add More Unit Test
* Swagger
* Sonar
* Authorization and Authentication.
* API Gateway(If caching, security and traceability are desired, one more layer can be added and an API Gateway)

### Built With

* [SpringBoot](https://start.spring.io/)
* [PostgreSQL](https://www.postgresql.org/)

<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these simple steps.

### Prerequisites

This is an example of how to list things you need to use the software and how to install them.
* Install JDK 1.8 version or more higher version.
```sh
https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html
```

### Installation
 
1. Clone the repo
```sh
git clone https://github.com/kivancbeser/university-management.git
```
### Installation For Backend

1. Open the project in the IDE. (I Prefer Intellij Idea)

2. Execute "mvn clean install -DskipTests:true" command should be run.

3. Start the Spring Boot Application

### Installation For Database
1. Download and Install PostgreSQL
```sh
Please check root and password for connecting java-side. If you choose different password, you have to change "application.properties" file.
```
2. After the installation you can run this script for create tables with in data.
```sh
`src/main/resources/create_db_with_data_script.sql
```

4. Change postgresql username and password as per your installation

+ open `src/main/resources/application.properties`
+ change `spring.datasource.username` and `spring.datasource.password` as per your postgresql installation

<!-- USAGE EXAMPLES -->
## Usage

1. After all installations start spring boot application and don't forget to start postgresql server.

2. Go to Postman and try it.

```sh
http://localhost:8080/
```
3. And DONE. You can easily use this application.

<!-- Explore Rest APIs -->
## Explore Rest APIs

The app defines following CRUD APIs.

### Professor

| Method | Url | Description | Sample Valid Request Body |
| ------ | --- | ----------- | ------------------------- |
| GET    | /professor | Get all professor | |
| GET    | /professor/{id} | Get professor by id |
| POST   | /professor | Create new professor  | [JSON](#prefessorcreate) |
| PUT    | /professor/{id} | Update professor | [JSON](#prefessorupdate) |
| DELETE | /professor/{id} | Delete professor | 

##### <a id="prefessorcreate">Create Professor -> /professor</a>
```json
{
    "name": "New Professor",
    "departmentEntity": {
        "id": 4
    }
}
```

##### <a id="prefessorupdate">Update Professor -> /professor/{id}</a>
```json
{
    "id" : 10,
    "name": "Updated Professor",
    "departmentEntity": {
        "id": 4
    }
}
```

### Department

| Method | Url | Description | Sample Valid Request Body |
| ------ | --- | ----------- | ------------------------- |
| GET    | /department/{id} | Get department by id |
| POST   | /department | Create new department  | 
| PUT    | /department/{id} | Update department | 
| DELETE | /department/{id} | Delete department | 

### Course

| Method | Url | Description | Sample Valid Request Body |
| ------ | --- | ----------- | ------------------------- |
| GET    | /course/{id} | Get course by id |
| POST   | /course | Create new course  | 
| PUT    | /course/{id} | Update course | 
| DELETE | /course/{id} | Delete course | 

### Schedule

| Method | Url | Description | Sample Valid Request Body |
| ------ | --- | ----------- | ------------------------- |
| GET    | /schedule/{id} | Get schedule by id |
| POST   | /schedule | Create new schedule  | 
| PUT    | /schedule/{id} | Update schedule | 
| DELETE | /schedule/{id} | Delete schedule | 

### Spesific Search

| Method | Url | Description | Sample Valid Request Body |
| ------ | --- | ----------- | ------------------------- |
| GET    | /search | All professors and the respective courses they teach. |

You can test them using postman.

<!-- Done -->
## Done
* Create Crud Operation
* Create Backend SpringBoot Project
* Create Database and Connect to Database 
* Create Entity
* Create Repository
* Create Service and Service Implement
* Create Controller
* Adding Unit Test
<!-- TODO -->
## TODO
* Input Validations 
* Swagger
* Add pagenumber for lazyload. 
* More comment for spring side.
* Add More Unit Test
* Swagger
* Sonar
* Authorization and Authentication.
* API Gateway(If caching, security and traceability are desired, one more layer can be added and an API Gateway)
<!-- ROADMAP -->
## Roadmap

See the [open issues](https://github.com/kivancbeser/university-management/issues) for a list of proposed features (and known issues).

<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.

<!-- CONTACT -->
## Contact

Kıvanç Enes Beşer - [@Linkedin_handle](https://www.linkedin.com/in/kivancenesbeser/) - beserkivanc@gmail.com

Project Link: [https://github.com/kivancbeser/university-management](https://github.com/kivancbeser/university-management)

[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=flat-square&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/kivancenesbeser
