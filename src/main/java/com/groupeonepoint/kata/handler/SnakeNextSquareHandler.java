package com.groupeonepoint.kata.handler;
/*
    @author Elmehdi ZANGUI
 */
public class SnakeNextSquareHandler extends AbstractNextSquareHandler {
    private RouteConfigure<Integer> snakesRoutesConfig;

    public SnakeNextSquareHandler(RouteConfigure<Integer> snakesRoutesConfig ) {
        this.snakesRoutesConfig = snakesRoutesConfig;
    }
    @Override
    public int handle(int squareNumber) {
        if (snakesRoutesConfig.containsRouteFrom(squareNumber)) {
            Integer nextSquare = snakesRoutesConfig.getDestinationFrom(squareNumber).get();
            System.out.printf("Oops .. slide from %s to %s \n",squareNumber, nextSquare);
            return nextSquare;
        }
        return handleNext(squareNumber);
    }

}
