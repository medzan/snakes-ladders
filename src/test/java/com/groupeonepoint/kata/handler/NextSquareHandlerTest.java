package com.groupeonepoint.kata.handler;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NextSquareHandlerTest {
    @Test
    public void whenOnlyLandOnSnakeHeat_thenHandlerSlideDown() {
        var squareHandler = new SnakeNextSquareHandler(RouteConfigure.build()
                .from(10).to(3)
                .from(20).to(2));
        assertEquals(3, squareHandler.handle(10));
        assertEquals(2, squareHandler.handle(20));
//        when the tail of the snake value is passed as a parameter, the handler returns the same input value
        assertEquals(3, squareHandler.handle(3));
        assertEquals(2, squareHandler.handle(2));

    }

    @Test
    public void whenOnlyLandOnTheBottomOfLadder_thenHandlerClimbUp() {
        var ladderHandler = new LadderNextSquareHandler(100, RouteConfigure.build()
                .from(10).to(20)
                .from(1).to(99));
        assertEquals(99, ladderHandler.handle(1));
        assertEquals(20, ladderHandler.handle(10));
//        when the top of the ladder value is passed as a parameter, the handler returns the same input value
        assertEquals(99, ladderHandler.handle(99));
        assertEquals(20, ladderHandler.handle(20));

    }

    @Test
    public void whenNoConfigurationForNumber_thenSameInputReturned() {
        var squareHandler = new SnakeNextSquareHandler(RouteConfigure.build().from(10).to(3));
        assertEquals(4, squareHandler.handle(4));
        assertEquals(100, squareHandler.handle(100));

        var ladderSquare = new LadderNextSquareHandler(100, RouteConfigure.build().from(3).to(10));
        assertEquals(4, squareHandler.handle(4));
        assertEquals(100, squareHandler.handle(100));
    }
}
