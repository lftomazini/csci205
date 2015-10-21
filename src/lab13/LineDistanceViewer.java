/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab13;

import java.awt.Color;
import java.awt.Graphics;
import static java.awt.geom.Line2D.ptSegDist;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author lftomazini
 */
public class LineDistanceViewer extends JFrame {

    public static int HEIGHT = 500;
    public static int WIDTH = 500;

    public LineDistanceViewer() {
        this.setTitle("Points");
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new Draw();
        this.add(panel);
        this.validate();
        this.repaint();
    }

}

class Draw extends JPanel {
    public static int P1_X = 100;
    public static int P1_Y = 100;
    public static int P2_X = 200;
    public static int P2_Y = 200;
    public static int P3_X = 100;
    public static int P3_Y = 200;
    public static int P4_X = 150;
    public static int P4_Y = 150;
    public static int P5_X = 250;
    public static int P5_Y = 50;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawLine(P1_X, P1_Y, P2_X, P2_Y);
        g.drawOval(P3_X, P3_Y, 3, 3);
        g.drawOval(P4_X, P4_Y, 3, 3);
        g.drawOval(P5_X, P5_Y, 3, 3);

        double distanceP3 = ptSegDist(P1_X, P1_Y, P2_X, P2_Y, P3_X, P3_Y);
        double distanceP4 = ptSegDist(P1_X, P1_Y, P2_X, P2_Y, P4_X, P4_Y);
        double distanceP5 = ptSegDist(P1_X, P1_Y, P2_X, P2_Y, P5_X, P5_Y);

        String stringP3 = "Distance: " + Double.toString(distanceP3);
        String stringP4 = "Distance: " + Double.toString(distanceP4);
        String stringP5 = "Distance: " + Double.toString(distanceP5);

        g.drawString(stringP3, P3_X + 3, P3_Y + 3);
        g.drawString(stringP4, P4_X + 3, P4_Y + 3);
        g.drawString(stringP5, P5_X + 3, P5_Y + 3);
    }
}
