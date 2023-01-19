package com.groupeonepoint.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SnakesLaddersTest {



    @Test
    public void whenNoLadderOrSnakeEncounter_thenPlayerMoveToSumOfDices() {

        var snakesLaddersGame = GameFactory.newClassicGame(1);


        var player = snakesLaddersGame.play(Dice.one, Dice.two).getPlayer();

        assertTrue(player.isPresent());
        assertEquals(3, player.get().getCurrentPositionOnBoard());

        player = snakesLaddersGame.play(Dice.six, Dice.one).getPlayer();
        assertTrue(player.isPresent());
        assertEquals(10, player.get().getCurrentPositionOnBoard());

    }

    @Test
    public void whenPlayerGetBothDieSameValue_thenPlayerWillHaveAnotherGo() {

        var snakesLaddersGame = GameFactory.newClassicGame(2);


        var firstHandPlayer = snakesLaddersGame.play(Dice.two, Dice.two).getPlayer();
        assertTrue(firstHandPlayer.isPresent());
        assertEquals(4, firstHandPlayer.get().getCurrentPositionOnBoard());

        var secondHandPlayer = snakesLaddersGame.play(Dice.three, Dice.two).getPlayer();
        assertTrue(firstHandPlayer.isPresent());
        assertEquals(9, secondHandPlayer.get().getCurrentPositionOnBoard());
        assertEquals(firstHandPlayer, secondHandPlayer);


    }

    @Test
    public void whenPlayerGetDifferentDicesValue_thenNextPlayerGetHand() {

        var snakesLaddersGame = GameFactory.newClassicGame(2);


        var firstHandPlayer = snakesLaddersGame.play(Dice.one, Dice.two).getPlayer();
        assertTrue(firstHandPlayer.isPresent());
        assertEquals(3, firstHandPlayer.get().getCurrentPositionOnBoard());

        var secondHandPlayer = snakesLaddersGame.play(Dice.three, Dice.two).getPlayer();
        assertTrue(firstHandPlayer.isPresent());
        assertEquals(5, secondHandPlayer.get().getCurrentPositionOnBoard());
        assertNotEquals(firstHandPlayer, secondHandPlayer);


    }

    @Test
    public void whenPlayerHitALadder_thenPlayerClimbUp() {

        var snakesLaddersGame = GameFactory.newClassicGame(1);


        var player = snakesLaddersGame.play(Dice.six, Dice.one).getPlayer();
        assertTrue(player.isPresent());
        assertEquals(14, player.get().getCurrentPositionOnBoard());


    }

    @Test
    public void whenPlayerHitASnake_thenPlayerSlideDown() {

        var snakesLaddersGame = GameFactory.newClassicGame(1);

//    we target the first snake head at square 16, we need two round to hit that square
//        First round
        var player = snakesLaddersGame.play(Dice.six, Dice.six).getPlayer();
        assertTrue(player.isPresent());
        assertEquals(12, player.get().getCurrentPositionOnBoard());
//        Second round where we expect to hit snake's head (at 16)
        player = snakesLaddersGame.play(Dice.three, Dice.one).getPlayer();
        assertTrue(player.isPresent());
        assertEquals(6, player.get().getCurrentPositionOnBoard());

    }
}

