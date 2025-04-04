# springboot-graphql

## Spring Boot GraphQL API
This repository contains an Spring Boot 'Store Application' which expose a GraphQL API with some endpoints related to
Products management.

### 🔧 Technology Stack

```
Java 17
Spring Boot 3
Spring Boot GraphQL / GraphQL API
Spring Data ( MySQL )
Misc Libraries (  Maven  /  Docker /  Lombok /  Apache Commons  )
```

### ⚒️ Getting Started

```bash
# clone the project
git clone https://github.com/rodrigobalazs/springboot-graphql.git;
cd springboot-graphql;

# start a mysql docker container
docker run --name store_db -e MYSQL_DATABASE=store_db -e MYSQL_USER=<user> \
    -e MYSQL_PASSWORD=<pass> -e MYSQL_ROOT_PASSWORD=<pass> \
    -p 3306:3306 -d mysql:latest;

# make sure to update application.properties with the
# MYSQL_USER and MYSQL_PASSWORD values defined in the previous point
spring.datasource.username=<user>
spring.datasource.password=<pass>

# compile and start the spring boot server
mvn clean install;
mvn spring-boot:run;
```
