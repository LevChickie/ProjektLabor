package com.squirels.Classes;

import java.util.List;

//Special Tile, where the Orangutan leaves the map with there pandas
//The player get points after the pandas, and the Orangutan return on the map on the entry Tile
public class Exit extends Tile {
    private static String id = "Exit";

    //Pair of the Exit is the Entry, where the Orangutan move after leaving the field
    Player player;

    //Set the player and the joint entry Tile
    public Exit(Tile e, int i, Player p) {
        entry = e;
        player = p;
        Name = "exit_"+i;
    }

    public String getId(){return id;}

    public boolean changeMoveable(Movable m) {
        //PAnda and Orangutan act different on Exit field
        if(m.getId().equals("Panda")) {
            //Get points for panda
            addPoints();
            //Panda p1 = (Panda) m;
            m.exit(entry);
        }
        if(m.getId().equals("Orangutan")) {
            Orangutan o1 = (Orangutan) m; //Casting to reach the pandas list of the orangutan
            if (o1.pandas.get(0) != null) {
                o1.pandas.get(0).move(this);
            }
            o1.exit(entry);
            return false;
        }
        mov = m;

        //Main.stackTraceWriter.classWriter("Exit.changeMoveable return", false);
        return true;
    }

    //Add points to the player for every single captive panda
    public void addPoints() {
        //Main.stackTraceWriter.classWriter("Exit.addPoints()", true);
        player.setPoints(10);
        //Main.stackTraceWriter.classWriter("Exit.addPoints return", false);
    }
}