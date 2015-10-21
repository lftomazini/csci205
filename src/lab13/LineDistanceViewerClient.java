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
 * File: LineDistanceViewerClient
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
public class LineDistanceViewerClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                LineDistanceViewer frame = new LineDistanceViewer();
                frame.setVisible(true);
            }
        });
    }

}