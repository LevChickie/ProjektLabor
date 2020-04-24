package com.squirels.Classes;


import java.util.List;

//Object, which a special Tile is, what teleport the Moveable to there pair
public class Cupboard extends Tile {
    private static String id = "Cupboard";

    //pair is the Tile by the Pair of the Cupboard

    //The pair of the Cupboard will set, when it created
    public Cupboard(Tile p, int i) {
        pair = p;
        Name = "cupboard_"+i;
    }

    public String getId(){return id;}

    //With this function will the Moveable passed over to another Tile
    public boolean changeMoveable(Movable m) {
        this.teleport(m);
        return false; //The moveable has to move forward to the pair of the cupboard
    }

    //Moveable is teleported to the pair of this Cupboard
    public void teleport(Movable mov) {
        mov.move(pair);
    }
}