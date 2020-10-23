## NBA Sport 
This is the project for the NBA basket ball games. We will deal with the game operation system.

### Project Technical Overview:
This application is developed in Spring Framework by using 
Spring Boot, Spring Data, Hibernate, Spring RESTful web services, 
Postman, Maven, PostgresSql, Docker, Amazon SQS, and Amazon S3.
1. Project Business Rules
2. Relationships
       *Project Approach:
       Created Game, Team, Player, Sponsor
       
## Configure local environment
### 1.Setup local database with docker
Reference to postgres docker [image](http://hub.docker.com/_/postgres) for environment option.
```
docker run --name training-db -e POSTGRES_USER=${username} -e POSTGRES_PASSWORD=${password} -e POSTGRES_DB=${databaseName} -p 5431:5432 -d postgres
```
### migrate database schema
Refer to flyway setup [documentation](https://flywaydb.org/documentation/migrations), find all[migration schema](src/main/resources/db/migrate)
```
mvn clean compile flyway:mygrate
```
