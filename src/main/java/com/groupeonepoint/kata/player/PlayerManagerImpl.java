package com.groupeonepoint.kata.player;

import java.util.stream.IntStream;
/*
    @author Elmehdi ZANGUI
 */
public class PlayerManagerImpl implements PlayerManager {
    private final int numberOfPlayers;
    private Player[] players;
    private final int PLAYER_FIRST_ID = 0;
    private int playerWithDie = PLAYER_FIRST_ID;

    public PlayerManagerImpl(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        players = initPlayers();
    }

    private Player[] initPlayers() {
        return IntStream.range(0, numberOfPlayers)
                .mapToObj(i -> new Player(i + 1, 0))
                .toArray(Player[]::new);

    }

    public Player getPlayerWithDice() {
        Player currentPlayer = players[playerWithDie];
        if (currentPlayer == null) {
            throw new IllegalStateException("Current Player cannot be null");
        }
        return currentPlayer;
    }

    public void updatePlayerWithDicePosition(int newSquareNumber) {
        getPlayerWithDice().setCurrentPosition(newSquareNumber);

    }

    public void handOverDiceToNextPlayer() {
        playerWithDie = (playerWithDie == numberOfPlayers - 1) ? PLAYER_FIRST_ID : (playerWithDie + 1);
    }


}
