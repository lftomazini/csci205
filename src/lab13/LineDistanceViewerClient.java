/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
