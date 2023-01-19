package com.groupeonepoint.kata.player;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PlayersManagerImplTest {

    @Test
    public void whenTogglePlayers_thenHandOverDiceToNextPlayer() {

        PlayerManagerImpl playerManager = new PlayerManagerImpl(3);
        Player first = playerManager.getPlayerWithDice();
        playerManager.handOverDiceToNextPlayer();

        Player second = playerManager.getPlayerWithDice();
        assertNotEquals(first, second);
        playerManager.handOverDiceToNextPlayer();

        Player third = playerManager.getPlayerWithDice();
        assertNotEquals(first, third);
        assertNotEquals(second, third);
//        after the fourth hand, we expect the first player to be the one with the dice
        playerManager.handOverDiceToNextPlayer();
        assertEquals(first, playerManager.getPlayerWithDice());

    }
    @Test
    public void whenNewPlayerManagerCreated_PlayersAreInSqrNumberZero(){

        PlayerManagerImpl playerManager = new PlayerManagerImpl(2);
        Player first = playerManager.getPlayerWithDice();
        Assertions.assertNotNull(first);
        assertEquals(0, first.getCurrentPositionOnBoard());

        playerManager.handOverDiceToNextPlayer();
        Player second = playerManager.getPlayerWithDice();
        Assertions.assertNotNull(second);
        assertEquals(0, second.getCurrentPositionOnBoard());


    }

}
