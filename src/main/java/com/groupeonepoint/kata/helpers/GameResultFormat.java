package com.groupeonepoint.kata.helpers;

import com.groupeonepoint.kata.player.Player;

import java.util.Optional;
/*
    @author Elmehdi ZANGUI
 */
public class GameResultFormat {
    private static  final String GAME_OVER_MSG = "Game over...";

    public static String format(GameResult result) {
        return switch (result.getCurrentState()) {
            case IN_PROGRESS -> inProgress(result.getPlayer());
            case FINISHED_WINNER -> winner(result.getPlayer());
            case GAME_OVER -> GAME_OVER_MSG;
        };

    }
    public static String winner(Optional<Player> winner) {
        if (!winner.isPresent()) {
            throw new IllegalStateException("Winner player cannot be null in a finished game ");
        }
        return String.format("Player %d Wins!. ", winner.get().getId());
    }
    private static  String inProgress(Optional<Player> player) {
        if (!player.isPresent()) {
            throw new IllegalStateException("Player cannot be null in on going game ");
        }
        return String.format("%s is on square %d", player.get(), player.get().getCurrentPositionOnBoard());
    }

}
