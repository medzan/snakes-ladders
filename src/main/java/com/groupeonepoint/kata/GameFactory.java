package com.groupeonepoint.kata;

import com.groupeonepoint.kata.configuration.SimpleGameSettings;
import com.groupeonepoint.kata.handler.LadderNextSquareHandler;
import com.groupeonepoint.kata.handler.RouteConfigure;
import com.groupeonepoint.kata.handler.SnakeNextSquareHandler;
import com.groupeonepoint.kata.player.PlayerManagerImpl;
/*
    @author Elmehdi ZANGUI
 */
public class GameFactory {
    //    Classic Game settings is the same default configuration detailed in the original game specification
    public static SnakesLadders newClassicGame(int numberOfPlayers) {
        return newGame(numberOfPlayers, 100);
    }

    public static SnakesLadders newGame(int numberOfPlayers, int boardSize) {
        var classicHandlers = new SnakeNextSquareHandler(classicSnakesPositions())
                .setNextHandler(new LadderNextSquareHandler(boardSize, classicLadderPositions()));

        return SnakesLadders.newGame(new SimpleGameSettings(boardSize, classicHandlers),
                new PlayerManagerImpl(numberOfPlayers));
    }

    //    Game contains only ladders no snakes
    public static SnakesLadders easy(int numberOfPlayers, int boardSize) {
        return SnakesLadders.newGame(new SimpleGameSettings(boardSize,
                        new LadderNextSquareHandler(boardSize, classicLadderPositions())),
                new PlayerManagerImpl(numberOfPlayers));
    }

    //    Game contains only snakes with no ladder
    public static SnakesLadders hard(int numberOfPlayers, int boardSize) {
        return SnakesLadders.newGame(new SimpleGameSettings(boardSize,
                        new SnakeNextSquareHandler(classicSnakesPositions())),
                new PlayerManagerImpl(numberOfPlayers));
    }

    private static RouteConfigure<Integer> classicSnakesPositions() {
        return RouteConfigure.build()
                .from(16).to(6)
                .from(46).to(25)
                .from(49).to(11)
                .from(62).to(19)
                .from(64).to(60)
                .from(74).to(53)
                .from(89).to(68)
                .from(92).to(88)
                .from(95).to(75)
                .from(99).to(80);
    }

    private static RouteConfigure classicLadderPositions() {
        return RouteConfigure.build()
                .from(2).to(38)
                .from(7).to(14)
                .from(8).to(31)
                .from(15).to(26)
                .from(21).to(42)
                .from(28).to(84)
                .from(36).to(44)
                .from(51).to(67)
                .from(71).to(91)
                .from(78).to(98)
                .from(87).to(94);

    }
}
