/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Luis Felipe Franco Candeo Tomazini
 * Date: Sep 30, 2015
 * Time: 3:46:29 PM
 *
 * Project: csci205
 * Package: lab11
 * File: Account
 * Description: Interfaces
 *
 * ****************************************
 */
package lab11;

/**
 * Checked exception representing any issues that might arise from the manager
 * class
 *
 */
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

/**
 *
 * @author lffct001
 */
public class Account {
    private double balance;

    public Account(double initBalance) {
        this.balance = initBalance;
    }

    public double getBalance() {
        return this.balance;
    }

    public void credit(double amount) {
        this.balance += amount;
    }

    public void debit(double amount) throws InsufficientFundsException {
        if (amount > this.balance) {
            throw new InsufficientFundsException(String.format(
                    "Not enough money!"));
        } else {
            this.balance -= amount;
        }
    }

    public void processCheck(Payable payee, double hoursBilled) throws InsufficientFundsException {
        System.out.println(
                payee.getPayTo() + payee.calculatePay(hoursBilled) + payee.getPayMemo());
        this.debit(payee.calculatePay(hoursBilled));
    }

    @Override
    public String toString() {
        String output = "Account Balance = ";
        return output + this.getBalance();
    }

}
