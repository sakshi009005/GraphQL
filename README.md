# GraphQL
GraphlQL with Spring Boot

This is a Fruit Market based GraphQL implementation with Spring Boot, where following can be done:

1. Add a new user
2. Fetch a user by id
3. Place order for user
4. Get Orders by user id

Clone this repo and execute mvnw spring-boot:run. Or inside an IDE, execute the class com.my.graphql.GraphQLApplication.

Database can be accessed at http://localhost:8080/h2-console/login.jsp with the following information:

JDBC URL: jdbc:h2:file:~/h2data/veggiesandfruits  
User Name: sa  
Password: password  

The GraphQL queries can be executed using http://localhost:8080/graphiql.  For example:  

query findUserById($id : Int){  
    findUserById(id: $id) {  
      id  
      firstName   
      lastName   
      age   
    }  
  }  

Or:  
  
mutation createUser($userRequest: UserRequest){  
  createUser(userRequest:$userRequest) {  
    id  
    firstName  
    lastName  
    age  
  }  
}    
  
The collection of Altair GraphQL CLient is attached which contains queries(fragments, aliases, directives, variables, etc.) and mutations.  

[Altair GraphQL CLient Collection.zip](https://github.com/sakshi009005/GraphQL/files/11260210/Altair.GraphQL.CLient.Collection.zip)
