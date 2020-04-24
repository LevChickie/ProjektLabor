package com.squirels.Classes;

import java.util.List;

public abstract class Movable {
    final static String id = "Movable";
    protected String Name;

    //The tile, where the Movable was before
    public Tile previousTile;

    //The current Tile/position/ of Movable
    public Tile tile;

    public String getId(){return id;}

    public String getName(){return Name;}

    //general move-function for Moveable objects
    public void move(Tile nextTile){}

    //The moveable will leave the game-place, when it steps on the exit Tile
    //Will be overriden in Orangutan and Panda too.
    public void exit(Tile t){}

    //basic definition of catch.
    //Will be overridden in Orangutan class.
    public boolean catchPanda(Panda p){ return true;}

    //basic definition of reactions.
    //Will be overridden in special pandas
    public Panda reaction(Tile t){ return null;}

    //basic definition of die.
    //Will be overriden in Orangutan and Panda too.
    public void die(){}

    //basic definition of robbery
    //stolen pandas from another orangutan
    public boolean  pandaRobbery(Orangutan o){ return true;}



}