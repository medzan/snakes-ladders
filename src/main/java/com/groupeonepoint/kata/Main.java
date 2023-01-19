package com.groupeonepoint.kata;


import com.groupeonepoint.kata.helpers.GameResult;
import com.groupeonepoint.kata.helpers.GameResultFormat;

import java.util.Optional;
import java.util.Random;

/*
    @author Elmehdi ZANGUI
 */
public class Main {
    public static void main(String[] args) {
        SnakesLadders game = GameFactory.newGame(2,50);

        runGameWithRandomDices(game);
        //  show a game over message after the game end
        System.out.println(GameResultFormat.format(game.play(Dice.one, Dice.two)));

    }

    public static Optional<GameResult> runGameWithRandomDices(SnakesLadders game) {
        GameResult result = null;
        while (game.inProgress()) {
            Dice[] dieAttempts = simulateDieThrown();
            result = game.play(dieAttempts[0], dieAttempts[1]);
            System.out.println(GameResultFormat.format(result));
        }
        return Optional.of(result);
    }


    private static Dice[] simulateDieThrown() {
        Random random = new Random();
        Dice[] dies = new Dice[2];
        dies[0] = new Dice(random.nextInt(1, 7));
        dies[1] = new Dice(random.nextInt(1, 7));
        return dies;
    }


}
