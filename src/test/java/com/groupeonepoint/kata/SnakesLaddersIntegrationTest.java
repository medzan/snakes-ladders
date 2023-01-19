package com.groupeonepoint.kata;

import com.groupeonepoint.kata.helpers.GameResult;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SnakesLaddersIntegrationTest {
/*
        Test added for convenience as main class uses random values to simulate
         players hands and keep running until there is a winner.
         And as the loop is not safe a bug in the code could cause infinite execution.

        The test considers that normal operation should not exceed 100 ms
 */
    @Test
    public void testGameRunWithingReasonableTime() {
        var snakesLaddersGame = GameFactory.newClassicGame(2);

        Callable<GameResult> task = () -> {
            Optional<GameResult> gameResult = Main.runGameWithRandomDices(snakesLaddersGame);
            return gameResult.orElseThrow();
        };

        GameResult result = runWithingATimeOut(task, 100, TimeUnit.MILLISECONDS);

        assertEquals(GameResult.State.FINISHED_WINNER, result.getCurrentState());
        assertTrue(result.getPlayer().isPresent());
        assertEquals(100, result.getPlayer().get().getCurrentPositionOnBoard());
    }
    @Test
    public void whenGameEndAndPlayerWin_gameOverIsReturned() {
        var snakesLaddersGame = GameFactory.newClassicGame(2);

        Callable<GameResult> task = () -> {
            Optional<GameResult> gameResult = Main.runGameWithRandomDices(snakesLaddersGame);
            return gameResult.orElseThrow();
        };

        GameResult result = runWithingATimeOut(task, 100, TimeUnit.MILLISECONDS);

        assertEquals(GameResult.State.FINISHED_WINNER, result.getCurrentState());
        assertTrue(result.getPlayer().isPresent());
        assertEquals(100, result.getPlayer().get().getCurrentPositionOnBoard());

        GameResult resultAfterWin = snakesLaddersGame.play(Dice.one, Dice.two);
        assertEquals(GameResult.State.GAME_OVER, resultAfterWin.getCurrentState());
    }

    private static GameResult runWithingATimeOut(Callable<GameResult> taskToRun, int timeOut, TimeUnit timeUnit) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<GameResult> task = executorService.submit(taskToRun);
        try {
            return task.get(timeOut, timeUnit);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }
    }
}
