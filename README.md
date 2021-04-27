**Good video showing how to install Maven on Windows:**

https://www.youtube.com/watch?v=RfCWg5ay5B0&t=300s

**To build and run the application, execute these commands:**

`mvn clean install`

`mvn spring-boot:run`

**Ignore file locally only**

`git update-index --skip-worktree [<PATH TO FILE>...]`

**The application is running on** http://localhost:8080/api/v1/

**Postgres Admin** http://127.0.0.1:60390/browser/

**API Design**

- POST /player (returns id of the user)


Example Request
```
POST /player

Body (JSON): {"name": "amy"}
```

Example Response
```
{
"name": "amy",
"id": 1
}
```

- GET /random (get a random word)

- POST /guess 

**TODOs**
- Create a welcome page for the game
- Create a new page for playing the game

**DONE**
- Create model for player's name & id
- Save name & id in Database 
- Return name & id to client
- Dynamically add name & id to database (i.e. from the name field)


