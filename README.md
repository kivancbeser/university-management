# university-management

[![LinkedIn][linkedin-shield]][linkedin-url] 

<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/kivancbeser/university-management">
    <img src="logo.png" alt="Logo" width="80" height="80">
  </a>
  <h3 align="center">Spring Boot Crud Example</h3>
  <br />
 
  <p align="center">
    <br />
    <a href="https://github.com/kivancbeser/spring-boot-crud-example-master/blob/master/ProjectDemo.mp4">View Demo Video</a>
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
  * [Account](#account)
* [Done](#done)
* [TODO](#todo)
* [Roadmap](#roadmap)
* [Contributing](#contributing)
* [License](#license)
* [Contact](#contact)

<!-- ABOUT THE PROJECT -->
## About The Project
 <a href="https://github.com/kivancbeser/university-management">
      <img src="/screenshots/DemoApplication.gif" alt="Demo Gif" width="1600">
 </a>

It was created for the purpose of a web project from database to user. You can see the done features in [Done](#done) sections. 


### Built With

* [SpringBoot](https://start.spring.io/)
* [PostgreSQL](https://www.postgresql.org/)

<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these simple steps.

### Prerequisites

This is an example of how to list things you need to use the software and how to install them.
* npm
```sh
npm install npm@latest -g
```

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

2. Execute Maven Clean & Install

3. Start the Spring Boot Application

### Installation For Frontend

1. Change directory and go to task-vue-side
```sh
cd task-vue-side
```

2. npm install
```sh
npm install
```

3. npm run serve
```sh
npm run serve
```

### Installation For Database
1. Download and Install PostgreSQL
```sh
Please check root and password for connecting java-side. If you choose different password, you have to change "application.properties" file.
```
2. Run Create Database Script
```sh
create database javatask;
```

4. Change postgresql username and password as per your installation

+ open `src/main/resources/application.properties`
+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

<!-- USAGE EXAMPLES -->
## Usage

1. After all installations start spring boot application, start vue project with "npm run serve" command and don't forget to start postgresql server.

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
| POST   | /professor | Create new professor  | 
| PUT    | /professor/{id} | Update professor | 
| DELETE | /professor/{id} | Delete professor | 

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
| GET    | /course/{id} | Get professor by id |
| POST   | /course | Create new professor  | 
| PUT    | /course/{id} | Update professor | 
| DELETE | /course/{id} | Delete professor | 

### Schedule

| Method | Url | Description | Sample Valid Request Body |
| ------ | --- | ----------- | ------------------------- |
| GET    | /schedule/{id} | Get professor by id |
| POST   | /schedule | Create new professor  | 
| PUT    | /schedule/{id} | Update professor | 
| DELETE | /schedule/{id} | Delete professor | 

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
* More comment for spring side.
* Add More Unit Test
* Swagger
* Sonar
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

Project Link: [https://github.com/kivancbeser/spring-boot-crud-example-master](https://github.com/kivancbeser/spring-boot-crud-example-master)

[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=flat-square&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/kivancenesbeser
