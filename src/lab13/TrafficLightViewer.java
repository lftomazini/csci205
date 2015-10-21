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
 * File: TrafficLightViewer
 * Description: Swing
 *
 * ****************************************
 */
package lab13;

import java.awt.EventQueue;

/**
 *
 * @author lftomazini
 */
public class TrafficLightViewer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                TrafficLightComponent frame = new TrafficLightComponent();
                frame.setVisible(true);
            }
        });
    }

}