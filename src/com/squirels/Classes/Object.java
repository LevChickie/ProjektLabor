package com.squirels.Classes;

import java.util.List;

public abstract class Object {
    private static String id = "Object";
    protected String Name;

    //Tile, where the object is
    Tile tile;

    int baseTime;
    int timer;

    //Constructor
    public Object(Tile t) {
        tile = t;
        baseTime = 100;
        timer = baseTime;
        tile.object = this;
    }

    public String getId(){return id;}

    public String getName(){
        return Name;
    }

    //calculating the time between two signals
    public void calculation() {
        timer--;
        if(timer==0){this.signal(); timer = baseTime;}
    }

    //After the Timer has the value of 0, it signals.
    //Will be overriden in special Object.
    public Panda signal() {
        return null;
    }

}