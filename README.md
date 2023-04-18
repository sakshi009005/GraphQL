# GraphQL
GraphlQL with Spring Boot

This is a Fruit Market based GraphQL implementation with Spring Boot, where following can be done:

1. Add a new user

mutation createUser($userRequest: UserRequest){
  createUser(userRequest:$userRequest) {
    id
    firstName
    lastName
    age
  }
}

2. Fetch a user by id

mutation createUser($userRequest: UserRequest){
  createUser(userRequest:$userRequest) {
    id
    firstName
    lastName
    age
  }
}


3. Place order for user
mutation placeOrder($id : Int , $orderRequest : OrderRequest) {
  placeOrder(id: $id, orderRequest: $orderRequest)
}

Variables:
{
  "id" : 2,
  "orderRequest" : {
    "orderDetails":[
    {
      "orderType" : "VEGETABLE",
      "name" : "POTATO",
      "quantity" : 1,
      "unit" : "kg"
    },
    {
      "orderType" : "VEGETABLE",
      "name" : "TOMATO",
      "quantity" : 1,
      "unit" : "kg"
    },
      {
      "orderType" : "FRUIT",
      "name" : "CORN",
      "quantity" : 2,
      "unit" : "pcs"
      },
      {
      "orderType" : "FRUIT",
      "name" : "WATERMELON",
      "quantity" : 1,
      "unit" : "pc"
    }
  ]
  }
}

4. Get Orders by user id
{
  getOrdersByUserId(userId: 46) {
    orders {
      orderId
      orderDetails(orderType: VEGETABLE) {
        orderType
        name
        quantity
        unit
      } 
    }
  }
}

Clone this repo and execute mvnw spring-boot:run. Or inside an IDE, execute the class com.my.graphql.GraphQLApplication.

Database can be accessed at http://localhost:8080/h2-console/login.jsp with the following information:

JDBC URL: jdbc:h2:file:~/h2data/veggiesandfruits
User Name: sa
Password: password

The GraphQL queries can be executed using http://localhost:8080/graphiql. 
