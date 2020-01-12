# MongoDB-CRUD-REST-Demo
MongoDB CRUD Demo by REST, and Spring Boot tech stack
Demonstrate how to use MongoRepository and MongoTemplate, those 2 different category of DAO template tool classes, how to do CRUD(creae, read, update and delete) function with MongoDB persistent storage  
* The layers of the application is Controller, Service, DAO and Model  
* In the service layer, there's a DBSeed util class to do pre-populate some values for testing, when you run this application and check your database there will be sample data inside the sample database-legostore  
* There is also simply introduce in-memory MongoDB for integration test, please run the DataMongoTest application class-LegostoreDatabaseTests to study the details.  
* In the APIs for test of lego store, I also introduce Query DSL for do some special filtering, please check DAO layer interface-LegoSetRepository.
 

