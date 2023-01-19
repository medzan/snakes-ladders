# introduction
This project aims to provide an object-oriented approach to implement the classic Snake Ladder game.
## Additional features
This implementation is fully configurable, with additional functionalities

Here is what we could configure :

- #### Number of players:

Game with 4 players
```java 
SnakesLadders game = GameFactory.newGame(4);
```

- #### Board size:
Board with only 50 square and two players
```java 
SnakesLadders game = GameFactory.newGame(2, 50);
```
- #### Difficulties (levels)
   - **Easy**: the board of this level only contains ladders without snakes
    ```java 
    SnakesLadders game = GameFactory.easy(2, 50);
    ``` 
  - **Hard**: the board in this level only contains snakes without any ladder,
  ```java 
    SnakesLadders game = GameFactory.hard(2, 200);
    ```
  
## Run Test
The project contains several tests for different use cases here:
```shell
src/test/java/com/groupeonepoint/kata/*
```

## Main
The Main class contains a basic example to run the game with 2 players and 100 squares with the default configuration (it runs an example with simulating dice rolls)