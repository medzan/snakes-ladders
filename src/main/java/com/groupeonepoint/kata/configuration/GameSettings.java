package com.groupeonepoint.kata.configuration;

import com.groupeonepoint.kata.handler.AbstractNextSquareHandler;

import java.util.Optional;
/*
    @author Elmehdi ZANGUI
 */
public interface GameSettings {

    Optional<AbstractNextSquareHandler> nextSquareHandler();
    int gameBoardSize();


}
