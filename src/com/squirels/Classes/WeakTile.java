package com.squirels.Classes;

import java.util.List;

public class WeakTile extends Tile {
    private static String id = "WeakTile";

    //counter counts the Structure point /health point/ of the Tile

    public WeakTile(int i, int weak) {
        counter = weak; //Starting value of Structure point is 20.
        Name = "weaktile_"+i;
    }

    public String getId(){return id;}


    //With this function will the Moveable passed over
    //to another Tile
    public boolean changeMoveable(Movable m) {
        super.changeMoveable(m);
        weakening(m);if(counter ==0){return false;}mov = m;
        return true;
    }

    //Calculation of the strength of the Tile.
    //It can break and cause the death of the Moveable
    public void weakening(Movable m) {
        counter--; if(counter==0){m.die();}
        //The following is depends on the choice of the tester
        //The command contains the necessary instructions to end the test-program.

    }
}