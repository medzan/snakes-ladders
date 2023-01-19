package com.groupeonepoint.kata;

import com.groupeonepoint.kata.configuration.GameSettings;
import com.groupeonepoint.kata.handler.AbstractNextSquareHandler;
import com.groupeonepoint.kata.helpers.GameResult;
import com.groupeonepoint.kata.player.Player;
import com.groupeonepoint.kata.player.PlayerManager;

import java.util.Objects;
import java.util.Optional;
/*
    @author Elmehdi ZANGUI
 */
public class SnakesLadders {
    private PlayerManager playerManager;
    private Optional<AbstractNextSquareHandler> nextSquareHandler;
    private boolean isGameOver = false;
    private int boardSize  ;
    public static SnakesLadders newGame(GameSettings gameSettings, PlayerManager playerManager) {
        return  new SnakesLadders(gameSettings, playerManager);
    }

    private SnakesLadders(GameSettings gameSettings, PlayerManager playerManager) {

        this.playerManager = Objects.requireNonNull(playerManager, "Player Manager could be null");
        this.boardSize = gameSettings.gameBoardSize();
        if(boardSize < 1){
            throw new IllegalArgumentException("Board size cannot be 0 or negative..");
        }
        this.nextSquareHandler = gameSettings.nextSquareHandler();
    }


    public GameResult play(Dice die1, Dice die2) {
        if(isGameOver){
            return GameResult.gameOver();
        }
        Player currentPlayer = playerManager.getPlayerWithDice();
        System.out.printf("%s play => %s, %s\n", currentPlayer, die1, die2);
        movePlayerToNextSquare(currentPlayer, die1.value(),die2.value());
        if (isPlayerWinner(currentPlayer)) {
            endTheGame();
            return GameResult.withWinner(currentPlayer);
        }
        togglePlayersIfNecessary(die1.value(), die2.value());

        return GameResult.inProgress(currentPlayer);

    }
    private void endTheGame() {
        isGameOver = true;
    }
    private boolean isPlayerWinner(Player player) {
        return player.getCurrentPositionOnBoard() == boardSize;
    }

    private void movePlayerToNextSquare(Player player, int die1, int die2){
        int nextSquareNumber = calculateNextSquareNumber(player.getCurrentPositionOnBoard(),die1, die2);
        playerManager.updatePlayerWithDicePosition(nextSquareNumber);
    }
    private int calculateNextSquareNumber(int currentSquareNumber, int die1, int di2){
        int nextSquareNumber = adjustSquareNumberIfBouncedOut(currentSquareNumber + die1 + di2);
        if (nextSquareHandler.isPresent()) {
            return nextSquareHandler.get().handle(nextSquareNumber);
        }
        return nextSquareNumber;
    }
    private void togglePlayersIfNecessary(int die1, int die2) {
        if (die1 != die2) {
            playerManager.handOverDiceToNextPlayer();
        }
    }
    private int adjustSquareNumberIfBouncedOut(int squareNumber){
        if(squareNumber > boardSize){
          squareNumber = boardSize - squareNumber%boardSize;
        }
        return squareNumber;
    }

    public boolean inProgress() {
        return !isGameOver;
    }

}