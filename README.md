Idea_Refindery_project assessment developed on Spring Boot and H2 in-memory database to build a RESTful API.

Prerequisites 
- Java(version 11)
- Maven (4.0.0)
- Spring Boot (2.7.5)

  Getting Started:
  1. Clone the repository:
     git clone https://github.com/YuliiaK93/Idea_Refinery_project

  2. Build your-repo
        mvn clean install
        
  3. Run the application
           
  4. The application will be accessible at HTTP://localhost:8080/h2 to check the connection with the H2 in-memory database
           To connect H2:
           Driver Class: org.h2.Driver
           JDBC URL: jdbc:h2:mem:assignment
           User Name: sa
           Password:

     5. API Endpoints
        - GET localhost:8080/tasks - list of all tasks
        - GET localhost:8080/tasks/{id} - shows the task by id
        - POST localhost:8080/tasks - you can create a new task here
        - PUT localhost:8080/tasks{id} - update task by id 

           
           
