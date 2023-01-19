package com.groupeonepoint.kata.player;
/*
    @author Elmehdi ZANGUI
 */
public interface PlayerManager {
    Player getPlayerWithDice();
    void handOverDiceToNextPlayer();
    void updatePlayerWithDicePosition(int newSquareNumber);
}
