package com.squirels.Classes;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ProtoFunctions {

    Map m = new Map();
    Player p = new Player();

    public String inputHandler(List<String> parancsList) {
        switch (parancsList.get(0)) {
            case "addtile":
                switch (parancsList.get(1)) {
                    case "normal":
                        m.addTile(new Tile(m.tileList.size()));
                        return m.tileList.get(m.tileList.size() - 1).getName();
                    case "weak":
                        int weak = Integer.parseInt(parancsList.get(2));
                        m.addTile(new WeakTile(m.tileList.size(), weak));
                        return m.tileList.get(m.tileList.size() - 1).getName() + " " + m.tileList.get(m.tileList.size() - 1).counter;
                    case "cupboard":
                        for (int i = 0; i < m.tileList.size(); i++) {
                            List<String> pair = Arrays.asList(parancsList.get(2).split("_"));
                            int number = Integer.parseInt(pair.get(1));
                            if (number == i) {
                                m.addTile(new Cupboard(m.tileList.get(i), m.tileList.size()));
                                return m.tileList.get(m.tileList.size() - 1).getName() + " " + m.tileList.get(m.tileList.size() - 1).pair.getName();
                            }
                        }
                        break;
                    case "exit":
                        for (int i = 0; i < m.tileList.size(); i++) {
                            List<String> entry = Arrays.asList(parancsList.get(2).split("_"));
                            int number = Integer.parseInt(entry.get(1));
                            if (number == i) {
                                m.addTile(new Exit(m.tileList.get(i), m.tileList.size(), p));
                                return m.tileList.get(m.tileList.size() - 1).getName() + " " + m.tileList.get(m.tileList.size() - 1).entry.getName();
                            }
                        }
                        break;
                    default:
                        return "error";
                }
                break;

            case "bindneighbours":
                if (!(parancsList.get(1).equals(parancsList.get(2)))) {
                    for (int i = 0; i < m.tileList.size(); i++) {
                        if (parancsList.get(1).equals(m.tileList.get(i).getName())) {
                            for (int j = 0; j < m.tileList.size(); j++) {
                                if (parancsList.get(2).equals(m.tileList.get(j).getName())) {
                                    m.tileList.get(i).setNeigbour(m.tileList.get(j));
                                    m.tileList.get(j).setNeigbour(m.tileList.get(i));
                                    return m.tileList.get(i).getName() + " " + m.tileList.get(j).getName();
                                }
                            }
                        }
                    }
                }

                break;
            case "addobject":
                for (int j = 0; j < m.tileList.size(); j++) {
                    if (parancsList.get(1).equals(m.tileList.get(j).getName())) {
                        Tile tile = m.tileList.get(j);

                        switch (parancsList.get(2)) {
                            case "schokomachine":
                                m.addObject(new SchokoMachine(tile, m.objectList.size()));
                                return m.objectList.get(m.objectList.size() - 1).getName() + " " + m.objectList.get(m.objectList.size() - 1).tile.getName();
                            case "armchair":
                                m.addObject(new Armchair(tile, m.objectList.size()));
                                return m.objectList.get(m.objectList.size() - 1).getName() + " " + m.objectList.get(m.objectList.size() - 1).tile.getName();
                            case "gamemachine":
                                m.addObject(new GameMachine(tile, m.objectList.size()));
                                return m.objectList.get(m.objectList.size() - 1).getName() + " " + m.objectList.get(m.objectList.size() - 1).tile.getName();
                            default:
                                return "error";
                        }
                    }
                }
                break;

            case "addpanda":
                for (int j = 0; j < m.tileList.size(); j++) {
                    if (parancsList.get(1).equals(m.tileList.get(j).getName())) {
                        Tile tile = m.tileList.get(j);

                        switch (parancsList.get(2)) {
                            case "scared":
                                m.addPanda(new SkaredPanda(tile, tile, m.pandaList.size()));
                                break;
                            case "jumpy":
                                m.addPanda(new JumpyPanda(tile, tile, m.pandaList.size()));
                                break;
                            case "sleepy":
                                m.addPanda(new SleepyPanda(tile, tile, m.pandaList.size()));
                                break;
                            default:
                                return "error";
                        }
                        return m.pandaList.get(m.pandaList.size() - 1).getName() + " " + m.pandaList.get(m.pandaList.size() - 1).getType() + " " + m.pandaList.get(m.pandaList.size() - 1).tile.getName();
                    }
                }
                break;
            case "addorangutan":
                for (int j = 0; j < m.tileList.size(); j++) {
                    if (parancsList.get(1).equals(m.tileList.get(j).getName())) {
                        Tile tile = m.tileList.get(j);

                        m.addOrangutan(new Orangutan(tile, tile, m.orangutanList.size()));
                        return m.orangutanList.get(m.orangutanList.size() - 1).getName() + " " + m.orangutanList.get(m.orangutanList.size() - 1).tile.getName();
                    }
                }
                break;
            case "moveorangutan":
                for (int j = 0; j < m.tileList.size(); j++) {
                    if (parancsList.get(2).equals(m.tileList.get(j).getName())) {
                        Tile tile = m.tileList.get(j);
                        for (int i = 0; i < m.orangutanList.size(); i++) {
                            if (parancsList.get(1).equals(m.orangutanList.get(i).getName())) {
                                m.orangutanList.get(i).move(tile);
                                return m.orangutanList.get(i).getName() + " " + m.orangutanList.get(i).tile.getName();
                            }
                        }
                    }
                }
                break;
            case "moverandompandas":
                try {
                    for (int i = 0; i < m.pandaList.size(); i++) {
                        if (parancsList.get(1).equals(m.pandaList.get(i).getName())) {
                            m.pandaList.get(i).moveRandom();
                            return m.pandaList.get(m.pandaList.size() - 1).getName() + " " + m.pandaList.get(m.pandaList.size() - 1).getType() + " " + m.pandaList.get(m.pandaList.size() - 1).tile.getName();
                        }
                    }
                }catch (ArrayIndexOutOfBoundsException e) {
                    String r = "";
                    for (int i = 0; i < m.pandaList.size(); i++) {
                        m.pandaList.get(i).moveRandom();
                        r += " " + m.pandaList.get(m.pandaList.size() - 1).getName() + " " + m.pandaList.get(m.pandaList.size() - 1).getType() + " " + m.pandaList.get(m.pandaList.size() - 1).tile.getName();
                    }
                    return r;
                }

                break;
                case "signal":
                    for (int i = 0; i < m.objectList.size(); i++) {
                        if (parancsList.get(1).equals(m.objectList.get(i).getName())) {
                            Panda p;
                            p = m.objectList.get(i).signal();
                            if(p==null){return "no reaction";}
                            return "react " + p.getName() + " " + p.getType() + " " + p.tile.getName();
                        }
                    }
                    break;
            case "state":
                try {
                    if (parancsList.get(1) != null) {
                        List<String> parancsobject = Arrays.asList(parancsList.get(1).split("_"));
                        switch (parancsobject.get(0)) {
                            case "panda":
                                for (int i = 0; i < m.pandaList.size(); i++) {
                                    if (parancsList.get(1).equals(m.pandaList.get(i).getName())) {
                                        if (m.pandaList.get(i).captive != null) {
                                            if (m.pandaList.get(i).next != null) {
                                                return m.pandaList.get(i).getName() + " " + m.pandaList.get(i).getType() + " " +
                                                        m.pandaList.get(i).tile.getName() + " " + m.pandaList.get(i).captive.getName() + " " + m.pandaList.get(i).next.getName();
                                            } else {
                                                return m.pandaList.get(i).getName() + " " + m.pandaList.get(i).getType() + " "
                                                        + m.pandaList.get(i).tile.getName() + " " + m.pandaList.get(i).captive.getName();
                                            }
                                        } else {
                                            return m.pandaList.get(i).getName() + " " + m.pandaList.get(i).getType() + " " + m.pandaList.get(i).tile.getName();
                                        }
                                    }
                                }
                                break;
                            case "orangutan":
                                for (int i = 0; i < m.orangutanList.size(); i++) {
                                    if (parancsList.get(1).equals(m.orangutanList.get(i).getName())) {
                                        String r = m.orangutanList.get(i).getName() + " " + m.orangutanList.get(i).tile.getName();
                                        if (m.orangutanList.get(i).pandas.get(0) != null) {
                                            for (int j = 0; j < m.orangutanList.get(i).pandas.size()-1; j++) {
                                                r += " " + m.orangutanList.get(i).pandas.get(j).getName();
                                            }
                                        }
                                        return r;
                                    }
                                }
                                break;
                            case "weaktile":
                                for (int i = 0; i < m.tileList.size(); i++) {
                                    if (parancsList.get(1).equals(m.tileList.get(i).getName())) {
                                        return m.tileList.get(i).getName() + " " + m.tileList.get(i).counter;
                                    }
                                }
                                break;
                            case "player":
                                String r = "";
                                r+= p.showPoints();
                                return r;
                            default:
                                return "error";
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    for (int i = 0; i < m.tileList.size(); i++) {

                        if(m.tileList.get(i).mov!=null) {
                            System.out.println(m.tileList.get(i).getName() + " " + m.tileList.get(i).mov.getName());
                        }
                        else if(m.tileList.get(i).object!=null) {
                            System.out.println(m.tileList.get(i).getName() + " " + m.tileList.get(i).object.getName());
                        }
                        else {
                            System.out.println(m.tileList.get(i).getName());
                        }
                    }
                }
                break;
            case "leavepandas":
                for (int i = 0; i < m.orangutanList.size(); i++) {
                    if (parancsList.get(1).equals(m.orangutanList.get(i).getName())) {
                        m.orangutanList.get(i).leavePandas();
                        return m.orangutanList.get(i).getName() + " " + m.orangutanList.get(i).tile.getName();
                    }
                }

                break;
            case "readandwrite":
                try {
                    if (parancsList.get(1) != null && parancsList.get(2) != null) {
                        return this.handleFiles(parancsList.get(1), parancsList.get(2));
                    }
                }
                catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("addfiles!");
                }
                break;
            case "test":
                try {
                    if (parancsList.get(1) != null && parancsList.get(2) != null) {
                        return this.testFiles(parancsList.get(1), parancsList.get(2));
                    }
                }
                catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("addfiles!");
                }
                break;
            default:
                return "elirtad balfasz";
        }
        return " ";
    }

    public String handleFiles(String input, String output) {

        RandomAccessFile in;
        RandomAccessFile out;
        String line;
        List<String> parancs = new ArrayList<>();

        try {
            in = new RandomAccessFile(input, "r");
            out = new RandomAccessFile(output, "rw");
            for (line = in.readLine(); line != null; line = in.readLine()) {
                parancs.add(line);
            }
            for (int i = 0; i < parancs.size(); i++) {
                List<String> panacsList = Arrays.asList(parancs.get(i).split(" "));
                out.writeBytes(inputHandler(panacsList));
                out.writeBytes("  \n");
            }

            in.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }

    public String testFiles(String input, String expected) {

        RandomAccessFile in;
        RandomAccessFile exp;
        String expline;
        String inline;
        List<String> parancs = new ArrayList<>();
        int sor=0;

        try {
            in = new RandomAccessFile(input, "r");
            exp = new RandomAccessFile(expected, "r");
            for (inline = in.readLine(); inline != null; inline = in.readLine()) {
                parancs.add(inline);
            }
            for (int i = 0; i < parancs.size(); i++) {
                List<String> panacsList = Arrays.asList(parancs.get(i).split(" "));
                expline = exp.readLine();
                inline = inputHandler(panacsList);
                System.out.println(expline+  " / " +inline + "<-" + parancs.get(i));
                sor++;
                if(!(expline.equals(inline))){
                    return "fail in " + sor + " line: " + expline + " != " + inline;
                }
            }
            in.close();
            exp.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }
}
