package com.squirels.Classes;


import java.util.List;

//Object, which react with the scared Panda
public class GameMachine extends Object {
    private static String id = "GameMachine";

    public GameMachine(Tile t, int i) {
        super(t);
        Name = "gamemachine_"+ i;
    }

    public String getId(){return id;}

    //After the timer has the value of 0, it signals.
    //Overriding Object function
    public Panda signal() {
        List<Tile> neighbours = tile.getNeighbours();
        for (int i = 0; i < neighbours.size(); i++) {
            if(neighbours.get(i).mov.getId().equals("Panda")){
                Panda p = (Panda) neighbours.get(i).mov;
                if(p.getType().equals("skared")){
                    return p.reaction(tile);
                }
            }
        }
        return null;
    }
}