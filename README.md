# springboot-graphql

## Spring Boot GraphQL API
This repository contains an Spring Boot 'Store Application' which expose a GraphQL API with Queries and Mutations
used to manage operations related to the Store´s Products.

### 🔧 Technology Stack

```
Java 17
Spring Boot 3
Spring for GraphQL ( GraphQL API )
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

### 💡 GraphQL API Examples

#### 1. Get all the available Products =>
```
curl -X POST http://localhost:8080/graphql  \
     -H 'accept: application/json'  \
     -H 'Content-Type: application/json' -d \
'{
    "query": "{ allProducts { id name price } }"
}';
```

#### 2. Get all the available Products ( via HTTPie ) =>
```
http POST http://localhost:8080/graphql query="{ allProducts { id name price } }";
```

#### 3. Retrieves a Product by Product Name (e.g 'Rustic Sofa') and only fetch in particular the product´s price =>
```
curl -X POST http://localhost:8080/graphql  \
     -H 'accept: application/json'  \
     -H 'Content-Type: application/json' -d \
'{
    "query": "{ productByName(name:\"Rustic Sofa\") { price } }"
}';
```

#### 4. Creates a new 'Triathlon Suit' Product =>
```
curl -X POST http://localhost:8080/graphql  \
     -H 'accept: application/json'  \
     -H 'Content-Type: application/json' -d \
'{
    "query":"mutation { addProduct(name:\"Triathlon Suit\", price:250.1) { id name price } }"
}';
```