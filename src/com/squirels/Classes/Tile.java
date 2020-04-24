package com.squirels.Classes;

import java.util.ArrayList;
import java.util.List;

public class Tile {
    private static String id = "Tile";
    protected String Name;

    public int counter = 0;
    public Tile pair;
    public Tile entry;

    //The list of Tile elements, which has a border
    //with the current Tile.
    public List<Tile> neighbours = new ArrayList<>();

    //The moveable, which is on the Tile.
    Movable mov;

    //The object, which is on the Tile
    Object object;

    public Tile() { }

    public Tile(int i) {Name = "tile_"+i;}


    public String getId(){return id;}

    String getName(){return Name;}

    public void setNeigbour(Tile t) {
        neighbours.add(t);
    }


    //With this function will the Movable passed over
    //to another Tile
    public boolean changeMoveable(Movable moveable) {
        if(object!= null) {
            if(moveable.getId().equals("Panda")) {
                Panda p = (Panda) moveable;
                if (!(p.getType().equals("sleepy") && object.getId().equals("Armchair"))) {
                    return false;
                }
            }
            else{return false;}
        }

        if(moveable.getId().equals("Orangutan") && mov != null) {
            //When the Tile has a Panda on it.
            if (mov.getId().equals("Panda")) {
                Panda p = (Panda) mov;
                boolean succesCatch = moveable.catchPanda(p);
                if (!succesCatch) {
                    return false;
                }
            } else if (mov.getId().equals("Orangutan")) {
                Orangutan o = (Orangutan) mov;
                Orangutan o2 = (Orangutan) moveable;
                if (o2.inactive != 4) {
                    boolean succesRobbery = moveable.pandaRobbery(o);
                    if (!succesRobbery) {
                        return false;
                    }
                }
            }
        }
        if(moveable.getId().equals("Panda") && mov != null) {
            return false;
        }
        mov = moveable;
        return true;
    }

    //The function returns every Tile,
    //which is the neighbour of the selected Tile
    public List<Tile> getNeighbours() {
        return neighbours; //Tile list
    }


    //Calculation of the strength of the Tile.
    public void weakening(Movable m) {}

}