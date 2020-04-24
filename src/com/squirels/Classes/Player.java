package com.squirels.Classes;


public class Player {

    private static String id = "Player";
    int p;


    //Constructor
    public Player() {
        p = 0;
    }

    public String getId(){return id;}

    //modify the points of the Player
    public void setPoints(int points) {
        p+=points;
    }

    //returns the points of the Player
    public int showPoints() {
        return p;
    }
}