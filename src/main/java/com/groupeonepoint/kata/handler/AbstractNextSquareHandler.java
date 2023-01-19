package com.groupeonepoint.kata.handler;
/*
    @author Elmehdi ZANGUI
 */
public abstract class AbstractNextSquareHandler {
    private AbstractNextSquareHandler next;

    public abstract int handle(int squareNumber);

    public int handleNext(int squareNumber) {
        if (next != null) {
            return next.handle(squareNumber);
        }
        return squareNumber;
    }

    public AbstractNextSquareHandler setNextHandler(AbstractNextSquareHandler next) {
        this.next = next;
        return this;
    }
}
