package com.squirels.Classes;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private static String id = "Map";
    //In the skeleton it has not got big role
    //This will build the physical field

    List<Tile> tileList = new ArrayList<>();
    List<com.squirels.Classes.Object> objectList = new ArrayList<>();
    List<Panda> pandaList = new ArrayList<>();
    List<Orangutan> orangutanList = new ArrayList<>();


    public String getId(){return id;}

    void addTile(Tile t){
        tileList.add(t);
    }

    void addObject(com.squirels.Classes.Object o){ objectList.add(o);}

    void addPanda(Panda p){
        pandaList.add(p);
    }

    void addOrangutan(Orangutan o){
        orangutanList.add(o);
    }

    void removePanda(Panda p){pandaList.remove(p);}

    void clean() {tileList.clear(); pandaList.clear();objectList.clear();orangutanList.clear();}

}