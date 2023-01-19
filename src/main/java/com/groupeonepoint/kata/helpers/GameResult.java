package com.groupeonepoint.kata.helpers;

import com.groupeonepoint.kata.player.Player;

import java.util.Optional;
/*
    @author Elmehdi ZANGUI
 */
public final class GameResult {
    public enum State{
        GAME_OVER,  IN_PROGRESS, FINISHED_WINNER
    }
    private State currentState;
    private Optional<Player> player = Optional.empty();

    private GameResult() {  }

    public static GameResult gameOver() {
        return new GameResult().setGameAsOver();
    }
    private GameResult setGameAsOver(){
        currentState = State.GAME_OVER;
        return this;
    }
    public static GameResult withWinner(Player winner) {
        return new GameResult().endGameWithWinner(winner);
    }

    private GameResult endGameWithWinner(Player winner) {
        this.player = Optional.of(winner);
        currentState = State.FINISHED_WINNER;
        return this;
    }
    public static GameResult inProgress(Player player) {
        return new GameResult().setGameInProgress(player);
    }

    public  GameResult setGameInProgress(Player player) {
        this.player = Optional.of(player);
        this.currentState = State.IN_PROGRESS;
        return this;
    }

    public Optional<Player> getPlayer() {
        return player;
    }
    public State getCurrentState() {
        return currentState;
    }




}
