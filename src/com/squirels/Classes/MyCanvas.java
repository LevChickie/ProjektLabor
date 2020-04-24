package com.squirels.Classes;

import java.awt.*;

public class MyCanvas extends Canvas {

    public void paint(Graphics g) {

        Toolkit t = Toolkit.getDefaultToolkit();
        Image i = t.getImage("graphics/mokus.jpg");
        g.drawImage(i, 120, 100, this);

    }
}