package com.squirels.Classes;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        JFrame frame = new JFrame("Projlab mókusok production");
        MyCanvas canvas = new MyCanvas();
        frame.add(canvas);
        frame.setSize(1600, 900);
        frame.setVisible(true);
        ProtoFunctions pf = new ProtoFunctions();

        while (true) {
            Scanner sc;

            sc = new Scanner(System.in);
            String parancs = sc.nextLine();

            List<String> parancsList = Arrays.asList(parancs.split(" "));
            System.out.println(pf.inputHandler(parancsList));
        }

    }


}