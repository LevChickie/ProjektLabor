package com.squirels.Classes;

import java.util.ArrayList;
import java.util.List;

public class Orangutan extends Movable {
    private static String id = "Orangutan";
    protected String Name;

    //Time while the Orangutan must inactive after a robbery
    int inactive;

    //The list of captives
    public List<Panda> pandas = new ArrayList<>();

    //The start-Tile of the current orangutan. If it dies, it will go there to respawn.
    private Tile start;

    public Orangutan(Tile t1, Tile t2, int i) {
        previousTile = t2;
        tile = t1;
        tile.mov = this;
        start = t1;
        pandas.add(0, null);
        inactive = 0;
        Name = "orangutan_"+i;
    }


    public String getId(){return id;}

    public String getName(){return Name;}

    //when the orangutan steps on a tile, which has a panda
    //the orangutan catches the panda, and it will be forced
    //to follow the orangutan.
    public boolean catchPanda(Panda panda) {
        //If inactive can not catch panda
        if (inactive != 0){
            return false;
        }

        //Orangutan orangutan, Previous Panda panda
        panda.move(tile);   // The panda changes places with the orangutan.
        if(pandas.get(0) != null) {
            panda.next = pandas.get(0);
        }
        panda.captive = this;
        pandas.add(0, panda);
        return true;
    }

    public void leavePandas(){
        //Main.stackTraceWriter.classWriter("Orangutan.leavePandas()", true);
        if(pandas.get(0)!=null){
            pandas.get(0).breakChain();
        }
        //Main.stackTraceWriter.classWriter("Orangutan.leavePandas return", false);
    }

    //after stepping on the exit tile, the orangutan is
    //teleported to an entry tile.
    public void exit(Tile toEntryTile){
        move(toEntryTile);

        pandas.removeAll(pandas);
        pandas.add(0, null);
    }

    //the orangutan will move to the Tile- "toNextTile", if it is possible.
    public void move(Tile nextTile) {

        boolean mcatch = false;
        if(nextTile.mov != null) {
            mcatch = true;

        }

        if(inactive!=0){inactive--;}

        tile.mov = null;
        if(nextTile.changeMoveable(this)) {
            previousTile.mov = null;
            previousTile = tile;
            tile = nextTile;
            tile.mov = this;
            if(pandas.get(0) != null) { //húzza maga után a sort,ha pandát kap el nem kell!
                if(!mcatch){pandas.get(0).move(previousTile);}
            }
        }
        if(nextTile.object != null){tile.mov = this;} //ha object van nem sikerült a lépés ő marad a mezőn
    }

    //With the lostPanda function can we delete
    //elements of the captive Panda List
    public void lostPanda(Panda pandaFreed) {
        pandas.remove(pandaFreed);
    }

    //Overriding the die function of Moveable class
    public void die() {
        move(start);
        if(pandas.get(0) != null) {
            pandas.get(0).breakChain();
        }

    }

    public boolean pandaRobbery(Orangutan o){

        if (inactive != 0 || this.pandas.get(0)!=null){
            return false;
        }


        if(o.pandas.get(0)!=null){
            for (int i = o.pandas.size()-2; i>=0 ; i--) {

                this.pandas.add(0, o.pandas.get(i));
                o.pandas.get(i).captive = this;
                o.lostPanda(o.pandas.get(i));
            }
        }

        o.inactive = 5;
        o.move(tile);
        o.inactive = 3;
        return true;
    }
}