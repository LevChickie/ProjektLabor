package com.squirels.Classes;

import java.util.List;

public class Panda extends Movable {
    private static String id = "Panda";
    protected String Name;
    protected String Type;

    //The reference of the captor
    public Orangutan captive;

    //The following Panda in the Chain
    public Panda next;

    public Panda(Tile t1, Tile t2, int i) {
        previousTile = t2;
        tile = t1;
        tile.mov = this;
        Name = "panda_" +i;
    }


    public String getId(){return id;}

    public String getName(){return Name;}

    public String getType(){return Type;}

    //The chain of captive pandas will break,
    //and the pandas will be free again
    public void breakChain() {
        if(next != null) {
            next.breakChain();
        }
        captive.lostPanda(this);
        captive = null;
        moveRandom();
    }


    public void move(Tile nextTile) {
        boolean succesMov = nextTile.changeMoveable(this);
        if(succesMov) {
            previousTile.mov = null;
            previousTile = tile;
            tile = nextTile;
        } else {
            return;
        }

        if(next != null) {
            next.follow(this);
        }
    }

    //the captive pandas move with the follow function
    //they step always on the place of the prievous member
    public void follow(Panda m) {
        if(next != null) {
            next.follow(this);
        }
        boolean succesMov = m.previousTile.changeMoveable(this);
        if(succesMov) {
            previousTile.mov = null;
            previousTile = tile;
            tile = m.previousTile;
        }
    }

    //the free pandas move in random directions
    public void moveRandom() {
        List<Tile> neighbours = tile.getNeighbours();

        boolean succesMov = false;
        //Random choose one the i-th element.
        //Controlling if the direction is correct.
        for (int i = 0; i <neighbours.size() ; i++) {
            if (neighbours.get(i).object == null && neighbours.get(i).mov ==null) {
                succesMov = neighbours.get(i).changeMoveable(this);
                if(succesMov) {
                    previousTile = tile;
                    tile = neighbours.get(i);
                }
                break;
            }
        }
    }


    //the panda has special task at the exit tile
    public void exit(Tile entry) {
        if (next != null) {
            next.follow(this);
        }
        this.die();
    }

    public void die() {
        if(captive!=null) {
            captive.lostPanda(this);
            if(next!=null) {
                next.breakChain();
            }
        }
        next = null;
        captive = null;
        try {
            this.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    //overriden in special Pandas
    public Panda reaction(Tile t) { return this; }
}