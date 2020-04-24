package com.squirels.Classes;

import java.util.List;

public class SchokoMachine extends Object {
    private static String id = "SchokoMachine";

    public SchokoMachine(Tile t, int i) {
        super(t);
        Name = "schokomachine_"+i;
    }


    public String getId(){return id;}

    //After the Timer has the value of 0, it signals. / Overriding Object function
    public Panda signal() {
        List<Tile> neighbours = tile.getNeighbours();
        for (int i = 0; i < neighbours.size(); i++) {
            if(neighbours.get(i).mov.getId().equals("Panda")){
                Panda p = (Panda) neighbours.get(i).mov;
                if(p.getType().equals("jumpy")){
                    return p.reaction(tile);
                }
            }
        }
        return null;
    }
}