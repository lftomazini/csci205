/**
 * CSCI 205 - Software Engineering and Design
 *
 * Lab 09 - Learning how to use JUnit.
 *
 * @author Brian King, Rick Zaccone
 */
package lab09;

import java.util.LinkedList;
import java.util.List;

/**
 * The <code>CashRegister</code> class models a very simple cash register. The
 * cash register assumes that it has an unlimited supply of money in its drawer,
 * and thus this is not modeled. It handles the management of one transaction of
 * a time, where a transaction consists of a list of items purchased. This
 * register only logs the amount of each purchase in a single transaction.
 *
 * @author Prof. Rick Zaccone and Brian King
 */
public class CashRegister {

    private static double MAX_ITEM_PRICE = 1000.0;

    /**
     * The total amount of the current transaction
     */
    private double totalTransaction;

    /**
     * Payment collected from the customer so far
     */
    private double paymentCollected;

    /**
     * List of purchases in the current transaction
     */
    private final LinkedList<Double> listOfItemPrices;

    /**
     * Constructs a new cash register
     */
    public CashRegister() {
        totalTransaction = 0;
        paymentCollected = 0;
        listOfItemPrices = new LinkedList<>();
    }

    /**
     * @return the number of purchases in the current transaction
     */
    public int getPurchaseCount() {
        return listOfItemPrices.size();
    }

    /**
     * @return the list of purchases in the current transaction
     */
    public List<Double> getListOfPurchases() {
        return listOfItemPrices;
    }

    /**
     * @return get the total amount of the current transaction
     */
    public double getTransactionTotal() {
        return totalTransaction;
    }

    /**
     * @return the total amount of payment collected for the current transaction
     */
    public double getPaymentCollected() {
        return paymentCollected;
    }

    /**
     * Records the sale of an item in a transaction.
     *
     * @param price the price of the item. Precondition: price >= 0
     */
    public void scanItem(double price) {
        if (price < 0.0 || price > MAX_ITEM_PRICE) {
            throw new IllegalArgumentException(String.format(
                    "scanItem: Bad Price: $%.2f", price));
        }
        // If this is the first purchase in the transaction, then clear out the
        // list of purchases
        if (totalTransaction == 0) {
            listOfItemPrices.clear();
        }

        listOfItemPrices.add(price);
        totalTransaction += price;
    }

    /**
     * Enters the payment received from the customer; should be called once for
     * each monetary unit moneyType
     *
     * @param moneyType the moneyType of the monetary units in the payment
     * @param unitCount the number of monetary units
     */
    public void collectPayment(Money moneyType, int unitCount) {
        if (unitCount < 0) {
            throw new IllegalArgumentException(String.format(
                    "collectPayment: Bad Amount: $%d", unitCount));
        }
        paymentCollected += unitCount * moneyType.getValue();
    }

    /**
     * Computes the change due and resets the machine for the next customer,
     * only if enough money was collected.
     *
     * @return the change due to the customer
     */
    public double giveChange() throws ChangeException {
        if (paymentCollected < totalTransaction) {
            throw new ChangeException(String.format(
                    "INSUFFICIENT PAYMENT: $%.2f, transaction = $%.2f",
                    paymentCollected, totalTransaction));
        }

        double change = paymentCollected - totalTransaction;
        totalTransaction = 0;
        paymentCollected = 0;
        return change;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof CashRegister) {
            CashRegister other = (CashRegister) obj;
            return (other.getTransactionTotal() == this.getTransactionTotal() && other.getPaymentCollected() == this.getPaymentCollected() && other.getListOfPurchases() == this.getListOfPurchases());
        } else {
            return false;
        }
        if (obj == this) {
            return true;
        }
    }
}
