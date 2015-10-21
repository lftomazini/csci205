/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Luis Felipe Franco Candeo Tomazini
 * Date: Oct 19, 2015
 * Time: 2:00:34 PM
 *
 * Project: csci205
 * Package: lab13
 * File: TrafficLightComponent
 * Description: Swing
 *
 * ****************************************
 */
package lab13;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author lftomazini
 */
public class TrafficLightComponent extends JFrame {

    public static int HEIGHT = 800;
    public static int WIDTH = 280;

    public TrafficLightComponent() {
        this.setTitle("Traffic Light");
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new CirclePanel();
        this.add(panel);
        this.validate();
        this.repaint();
    }

}

class CirclePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval((int) (0.1 * this.getWidth()),
                   (int) (0.04 * this.getHeight()),
                   (int) (this.getWidth() * 0.8),
                   (int) (this.getHeight() * 0.28));

        g.setColor(Color.YELLOW);
        g.fillOval((int) (0.1 * this.getWidth()),
                   (int) (0.36 * this.getHeight()),
                   (int) (this.getWidth() * 0.8),
                   (int) (this.getHeight() * 0.28));

        g.setColor(Color.GREEN);
        g.fillOval((int) (0.1 * this.getWidth()),
                   (int) (0.68 * this.getHeight()),
                   (int) (this.getWidth() * 0.8),
                   (int) (this.getHeight() * 0.28));
    }
}