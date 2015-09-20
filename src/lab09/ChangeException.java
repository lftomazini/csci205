/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Luis Felipe Franco Candeo Tomazini
 * Date: Sep 20, 2015
 * Time: 1:21:47 PM
 *
 * Project: csci205
 * Package: lab09
 * File: ChangeException
 * Description: Exceptions and JUnit
 *
 * ****************************************
 */
package lab09;

/**
 * A custom exception thrown if the cash register tries to give change before
 * enough money is collected
 */
public class ChangeException extends Exception {
    public ChangeException(String message) {
        super(message);
    }
}
