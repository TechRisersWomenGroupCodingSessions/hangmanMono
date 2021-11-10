**Project Plan**

https://miro.com/app/board/o9J_lBZkjN4=/

**Good video showing how to install Maven on Windows:**

https://www.youtube.com/watch?v=RfCWg5ay5B0&t=300s

**Docker**

first add docker to path

create postgres instance:

docker run --name spring-postgres -e POSTGRES_PASSWORD=password -d -p 5432:5432 postgres:alpine

creates a postgres user called 'postgres' with password 'password'

Expose the port:

docker port spring-postgres

**To build and run the application, execute these commands:**

`mvn clean install`

`mvn spring-boot:run`

**Ignore file locally only**

`git update-index --skip-worktree src/main/resources/application.properties`

`git update-index --skip-worktree [<PATH TO FILE>...]`

**The application is running on** http://localhost:8080/api/v1/

**Postgres Admin** http://127.0.0.1:60390/browser/
psql -U postgres

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

/game/start
``
{"secretWordLength":5,"gameId":"075091cc-1ca6-484f-b9d9-65f2eb14e422"}
``

 - - - - - -

/game/guess

{letter: 'l'} 

client -> server

``
{
 lettersInSecret: [{
letter: 'l',
positions: [2, 3]
}]
}
``

server -> client

_ _ l  l _


{letter: 'h'}

client -> server

``
{
lettersInSecret: [{
letter: 'l',
positions: [2, 3]
},{
letter: 'h',
positions: [0]
}]
}
``

server -> client

h _ l  l _

{letter: 'x',
gameId: 1234
}

``
{
incorrectGuessesLeft: 8,
gameInProgress: True,
incorrectLetter: [ {
letter: 'x' }, {letter: 'p'}],
lettersInSecret: [{
letter: 'l',
positions: [2, 3]
},{
letter: 'h',
positions: [0]
}]
}
``

TODO NEXT:
* add code for saving positions 
* create a text/input field in FE for the guess
* take the guess, check it and return a JSON response (see above)
* refactor SecretWordServiceTest & GameserviceTest



Database Diagram
https://dbdiagram.io/d/618c17f802cf5d186b5007c7

