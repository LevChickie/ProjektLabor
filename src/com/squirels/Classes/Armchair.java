package com.squirels.Classes;

import java.util.List;

//Object, which react with the sleepy Panda
public class Armchair extends Object {
    private static String id = "Armchair";

    //Constructor
    public Armchair(Tile t, int i) {
        super(t);
        Name = "armchair_"+i;
    }

    public String getId(){return id;}

    //After the timer has the value of 0, it signals to pandas nearby.
    //Overriding function from Object
    public Panda signal() {
        List<Tile> neighbours = tile.getNeighbours();
        for (int i = 0; i < neighbours.size(); i++) {
            if(neighbours.get(i).mov.getId().equals("Panda")){
                Panda p = (Panda) neighbours.get(i).mov;
                if(p.getType().equals("sleepy")){
                    return p.reaction(tile);
                }
            }
        }
        return null;
    }
}
