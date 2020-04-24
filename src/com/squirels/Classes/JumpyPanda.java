package com.squirels.Classes;

import java.util.List;

//Special Panda, who react to the SchokoMachine
public class JumpyPanda extends Panda {

    public JumpyPanda(Tile t1, Tile t2, int i) {
        super(t1, t2, i);
        t1.mov = this;
        Type = "jumpy";
    }


    //The JumpyPanda will weaken twice the Tile,
    //when it hears the signal of the Schokomachine.
    public Panda reaction(Tile t) {
           tile.weakening(this);
           return this;
    }

}