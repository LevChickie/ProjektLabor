package com.squirels.Classes;

import java.util.List;

public class SkaredPanda extends Panda {

    public SkaredPanda(Tile t1, Tile t2, int i) {
        super(t1, t2, i);
        t1.mov = this;
        Type = "skared";
    }

    //The SkaredPanda will break the chain if it's captive
    //And it hears the signal of the Game machine.
    public Panda reaction(Tile t) {
       if (captive!=null) {
                breakChain();
        }
       return this;
    }
}