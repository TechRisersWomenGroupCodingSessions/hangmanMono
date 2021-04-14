**Good video showing how to install Maven on Windows:**

https://www.youtube.com/watch?v=RfCWg5ay5B0&t=300s

**To build and run the application, execute these commands:**

`mvn clean install`

`mvn spring-boot:run`

**The application is running on** http://localhost:8080/hello

**Postgres Admin** http://127.0.0.1:60390/browser/

**API Design**

- POST /name (returns id of the user)

- GET /random (get a random word)

- POST /guess 

**TODOs**
- Return name & id to client
- Dynamically add name & id to database (i.e. from the name field)

**DONE**
- Create model for player's name & id
- Save name & id in Database 


