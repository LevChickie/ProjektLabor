package com.squirels.Classes;
import com.squirels.Classes.*;

import java.util.List;

public class SleepyPanda extends Panda {


    public SleepyPanda(Tile t1, Tile t2, int i) {
        super(t1, t2, i);
        t1.mov = this;
        Type = "sleepy";
    }

    //The SleepyPanda will sit down in the armchair, when it is free.
    public Panda reaction(Tile t) {
       if(captive==null) {
           this.move(t);
           return this;
        }
       return null;
    }
}
