package com.groupeonepoint.kata;
/*
    @author Elmehdi ZANGUI
 */
public record Dice(int value) {
    public static Dice one = new Dice(1);
    public static Dice two = new Dice(2);
    public static Dice three = new Dice(3);
    public static Dice four = new Dice(4);
    public static Dice five = new Dice(5);
    public static Dice six = new Dice(6);
    public Dice{
        if (value < 1 || value > 6) {
            throw new IllegalArgumentException("Invalid dice value : " + value);
        }
    }
}
