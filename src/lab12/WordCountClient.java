/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Anmol Singh and Luis Felipe Franco Candeo Tomazini
 * Date: Oct 4, 2015
 * Time: 3:55:11 PM
 *
 * Project: csci205
 * Package: lab12
 * File: WordCountClient
 * Description:
 *
 * ****************************************
 */
package lab12;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author as062
 */
public class WordCountClient {
    public static void main(String[] args) throws IOException {
        int decider = 0;
        do {
            try {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        ".txt files", "txt");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println("You chose to open this file: "
                                       + chooser.getSelectedFile().getName());
                }

                String file = chooser.getSelectedFile().getPath();
                WordCount just = new WordCount(file);
                just.doIt();

                int option = JOptionPane.showConfirmDialog(null, just,
                                                           "Try again?",
                                                           JOptionPane.YES_NO_OPTION);
                decider = option;
            } catch (FileNotFoundException e) {
                JOptionPane.showConfirmDialog(null, "\nError!",
                                              "File not found!",
                                              JOptionPane.PLAIN_MESSAGE,
                                              0, null);
            } catch (IOException e) {
                JOptionPane.showConfirmDialog(null, "\nError!",
                                              "IO Exception!",
                                              JOptionPane.PLAIN_MESSAGE,
                                              0, null);
                break;
            }
        } while (decider == 0);

        int sFinal = JOptionPane.showConfirmDialog(null, "\nGoodbye!",
                                                   "Goodbye!",
                                                   JOptionPane.PLAIN_MESSAGE,
                                                   0, null);
    }
}
