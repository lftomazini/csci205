/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Luis Felipe Franco Candeo Tomazini & Anmol Singh
 * Date: Sep 16, 2015
 * Time: 10:28:39 PM
 *
 * Project: csci205
 * Package: lab08
 * File: CoinCollectionClient
 * Description: Enumerated types
 *
 * ****************************************
 */
package lab08;

import javax.swing.JOptionPane;

/**
 *
 * @author lffct001
 */
public class CoinCollectionClient {

    public static void main(String args[]) {
        CoinCollection myCoins = new CoinCollection();

        myCoins.addCoins(Coin.NICKEL, 5);
        myCoins.addCoins(Coin.DIME, 3);
        myCoins.addCoins(Coin.QUARTER, 7);

        loop:
        while (true) {
            int option = JOptionPane.showOptionDialog(null,
                                                      myCoins.toString() + "Select your action:",
                                                      "Add or remove?",
                                                      JOptionPane.YES_NO_CANCEL_OPTION,
                                                      JOptionPane.INFORMATION_MESSAGE,
                                                      null,
                                                      AddRemoveChoices.values(),
                                                      AddRemoveChoices.values()[0]);
            Coin answer;
            String sVal;
            int val = 0;
            switch (option) {
                case 0:
                    answer = (Coin) JOptionPane.showInputDialog(null,
                                                                "Select coin type:",
                                                                "Add coins",
                                                                JOptionPane.QUESTION_MESSAGE,
                                                                null,
                                                                Coin.values(),
                                                                Coin.values()[0]);
                    if (answer == null) {
                        break loop;
                    }
                    sVal = JOptionPane.showInputDialog(null,
                                                       "How many do you want to add?");
                    if (sVal == null) {
                        break loop;
                    }
                    val = Integer.parseInt(sVal);
                    myCoins.addCoins(answer, val);
                    break;

                case 1:
                    answer = (Coin) JOptionPane.showInputDialog(null,
                                                                "Select coin type:",
                                                                "Add coins",
                                                                JOptionPane.QUESTION_MESSAGE,
                                                                null,
                                                                Coin.values(),
                                                                Coin.values()[0]);
                    if (answer == null) {
                        break loop;
                    }
                    sVal = JOptionPane.showInputDialog(null,
                                                       "How many do you want to remove?");
                    if (sVal == null) {
                        break loop;
                    }
                    val = Integer.parseInt(sVal);

                    if (val > myCoins.getCount(answer)) {
                        int error = JOptionPane.showConfirmDialog(null,
                                                                  "Could not remove all coins\n" + myCoins.getCount(
                                                                          answer) + " coins were removed",
                                                                  "ERROR!",
                                                                  JOptionPane.PLAIN_MESSAGE,
                                                                  0, null);
                    }
                    myCoins.removeCoins(answer, val);
                    break;

                default:
                    break loop;
            }

        }

        int sFinal = JOptionPane.showConfirmDialog(null,
                                                   "You have:\n" + myCoins + "\nGoodbye!",
                                                   "Goodbye!",
                                                   JOptionPane.PLAIN_MESSAGE,
                                                   0, null);
    }

}
