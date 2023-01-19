package com.groupeonepoint.kata.configuration;

import com.groupeonepoint.kata.handler.AbstractNextSquareHandler;

import java.util.Optional;

/*
    @author Elmehdi ZANGUI
 */
public class SimpleGameSettings implements GameSettings {

    private final int BOARD_SIZE = 100;
    private final Optional<AbstractNextSquareHandler> handler;
    private final int boardSize;

    public SimpleGameSettings(int boardSize, AbstractNextSquareHandler handler) {
        this.boardSize = boardSize;
        this.handler = Optional.of(handler);
    }

    public SimpleGameSettings(int boardSize) {
        this.handler = Optional.empty();
        this.boardSize = boardSize;
    }

    @Override
    public Optional<AbstractNextSquareHandler> nextSquareHandler() {
        return this.handler;
    }

    @Override
    public int gameBoardSize() {
        return this.boardSize;
    }


}
