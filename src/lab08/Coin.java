/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Luis Felipe Franco Candeo Tomazini & Anmol Singh
 * Date: Sep 16, 2015
 * Time: 8:24:41 PM
 *
 * Project: csci205
 * Package: lab08
 * File: Coin
 * Description: Enumerated types
 *
 * ****************************************
 */
package lab08;

/**
 *
 * @author lffct001
 */
public enum Coin {

    /**
     *
     */
    NICKEL(0.05), DIME(0.10), QUARTER(0.25);

    private double value;

    Coin(double value) {
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }
}
