package com.groupeonepoint.kata.player;

import java.util.Objects;
/*
    @author Elmehdi ZANGUI
 */
public class Player {
    private final int id;
    private int currentPosition;
     Player(int id, int currentPosition) {
        this.id = id;
        this.currentPosition = currentPosition;
    }

    public int getCurrentPositionOnBoard() {
        return currentPosition;
    }

    public int getId() {
        return id;
    }
    void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id && currentPosition == player.currentPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, currentPosition);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", position=" + currentPosition +
                '}';
    }
}
