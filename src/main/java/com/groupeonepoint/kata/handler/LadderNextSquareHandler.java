package com.groupeonepoint.kata.handler;
/*
    @author Elmehdi ZANGUI
 */
public class LadderNextSquareHandler extends AbstractNextSquareHandler {
    private RouteConfigure<Integer> laddersRoutesConfig;
    private final int boardSize;

    public LadderNextSquareHandler(int boardSize, RouteConfigure<Integer> laddersRoutesConfig) {
        this.boardSize = boardSize;
        this.laddersRoutesConfig = laddersRoutesConfig;

    }
    @Override
   public int handle(int squareNumber) {
        if (laddersRoutesConfig.containsRouteFrom(squareNumber)) {
            Integer nextSquare = laddersRoutesConfig.getDestinationFrom(squareNumber).get();
            if(nextSquare <= boardSize){
                System.out.printf("Let's climb up from %s to %s\n",squareNumber, nextSquare);
                return nextSquare;
            }
        }
        return handleNext(squareNumber);
    }
}
