<h1 align = "center"> Blogging Platform API </h1>
<p align="center">
<a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
</a>
<a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-3.0.5-brightgreen.svg" />
</a>
<a href="Spring Boot url" >
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.0.6-brightgreen.svg" />
</a>
</p>

This is a simple blog application built using Spring Boot framework.The idea was to build some basic blogging platform.
It provides CRUD operations, validation and exception handling ,using Hibernate as the ORM and MySQL as the database.
Posts are divided into categories for easy navigation and filtering.
It was made using Spring Boot, Spring Data JPA, Spring Data REST and MySql Database.
User can comment on posts made by other users.
Pagination has also been added to get all posts.
### Tech Stack :-
  * Spring Boot
  * Java
  * JPA Hibernate
  * MySQL
### Configuration :-
* Configuration Files - 

    * src/resources/application.properties - main configuration file. Here it is possible to change the port number.
    it has the properties for Database connection and for uploading file.

    it has the properties for Database connection and for uploading file like:![Screenshot 2023-05-21 161824](https://github.com/poojagurnule/MCT-Blogging-Platform-API/assets/102051371/b1034ce1-7a55-49fd-901e-d0e03ff447e8)


 ### Getting Started :-
* To get started with the application, clone the repository to your local machine using :
      
      git clone https://github.com/<your-username>/spring-boot-blog.git
* Make sure you have Java and Maven installed on your machine.
You will also need a MySQL server running on your local machine or a remote server.
* Configure the database connection in the application.properties file:
       spring.datasource.url=jdbc:mysql://localhost:3306/<database-name>
       spring.datasource.username=<database-username>
       spring.datasource.password=<database-password>
* Build and run the application.
## There are Three models -
 * Users
 * Post
 * Comment
  
  ## Data Flow
1. The user sends a request to the application through the API endpoints.
2. The API receives the request and sends it to the appropriate controller method.
3. The controller method makes a call to the method in service class.
4. The method in service class builds logic and retrieves or modifies data from the database, which is in turn given to controller class
5. The controller method returns a response to the API.
6. The API sends the response back to the user.

## Mapping between Models -

![Screenshot 2023-05-21 163629](https://github.com/poojagurnule/MCT-Blogging-Platform-API/assets/102051371/4935d31e-3df1-4667-8063-90d15dcbef18)

## Endpoints
* User Controller has -
   
![Screenshot 2023-05-21 161214](https://github.com/poojagurnule/MCT-Blogging-Platform-API/assets/102051371/5c96e4e9-1dbc-499c-ab1f-0c856b171d96)


* Post Controller has -

   ![Screenshot 2023-05-21 161330](https://github.com/poojagurnule/MCT-Blogging-Platform-API/assets/102051371/730677cf-d99a-454f-8e29-b62b42b05abd)


* Comment Controller has -
  
  ![Screenshot 2023-05-21 161350](https://github.com/poojagurnule/MCT-Blogging-Platform-API/assets/102051371/9f5b1b59-b294-4efd-9641-44feaf72b81e)

## Project Summary
This is a simple blog application built using Spring Boot framework.The idea was to build some basic blogging platform.
It provides CRUD operations, validation and exception handling ,using Hibernate as the ORM and MySQL as the database.
Posts are divided into categories for easy navigation and filtering.
It was made using Spring Boot, Spring Data JPA, Spring Data REST and MySql Database.
User can comment on posts made by other users.
  
## Author
👤 **Pooja Gurnule**
* GitHub: [Pooja Gurnule](https://github.com/poojagurnule)
  
---
  
## 🤝 Contributing
Contributions, issues and feature requests are welcome!<br />Feel free to check [issues page]("url").
  
---
  
## Show your support
Give a ⭐️ if this project helped you!
  
---
  
## 📝 License
Copyright © 2023 [Pooja Gurnule](https://github.com/poojagurnule).<br />
