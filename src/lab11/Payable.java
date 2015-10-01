/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Luis Felipe Franco Candeo Tomazini
 * Date: Sep 30, 2015
 * Time: 10:31:20 AM
 *
 * Project: csci205
 * Package: lab11
 * File: Payable
 * Description: Interface
 *
 * ****************************************
 */
package lab11;

/**
 *
 * @author lffct001
 */
interface Payable {
    /**
     * Given a parameter representing the number of hours to pay returns the
     * amount of money to be paid
     *
     * @param numHrs
     * @return the amount to be paid
     */
    public double calculatePay(double numHrs);

    /**
     * returns a string that should be placed in "Pay To" field on the check to
     * be printed
     *
     * @return a string with the name
     */
    public String getPayTo();

    /**
     * returns a string that should be placed in the memo field on the check to
     * be printed
     *
     * @return
     */
    public String getPayMemo();
}
