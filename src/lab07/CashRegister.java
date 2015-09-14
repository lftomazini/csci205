/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Luis Felipe Franco Candeo Tomazini and Anmol Singh
 * Date: Sep 13, 2015
 * Time: 2:00:34 PM
 *
 * Project: csci205
 * Package: lab07
 * File: CashRegister
 * Description: Classes, Part II
 *
 * ****************************************
 */
package lab07;

import java.util.ArrayList;

/**
 *
 * @author Luis Felipe Tomazini and Anmol Singh
 */
public class CashRegister {

    /**
     * Array of the items
     */
    private ArrayList<Double> itemList;

    /**
     * Total number of transactions
     */
    private int numTransToday = 0;

    /**
     * The name of the cash drawer
     */
    private String sName;

    /**
     * The amount of cash in the drawer
     */
    private double cashInDrawer;

    /**
     * Are we currently in a transaction?
     */
    private boolean isInTransaction;

    /**
     * The total amount of the transaction
     */
    private double transTotal;

    /**
     * The total number of items purchased in this transaction so far
     */
    private int numItemsInTrans = 0;

    /**
     * The total amount of money collected toward the transaction
     */
    private double amountPaid;

    /**
     * Constructor with no parameters
     */
    public CashRegister() {
        this.numTransToday = 0;
        this.itemList = new ArrayList<>();
        this.cashInDrawer = 0;
        this.isInTransaction = false;
        this.transTotal = 0;
        this.numItemsInTrans = 0;
        this.amountPaid = 0;
        this.sName = "Default";
    }

    /**
     * Constructor with a parameter to set the name
     *
     * @param sName The name to set the cash register
     */
    public CashRegister(String sName) {
        this();
        this.itemList = new ArrayList<>();
        this.sName = sName;
    }

    /**
     * Initializes the amount in the cash drawer
     *
     * @param initCash
     */
    public void startDay(double initCash) {
        this.numTransToday = 0;
        this.itemList.clear();
        this.cashInDrawer = initCash;
    }

    /**
     * Takes the money from the drawer so that the drawer has no money left
     *
     * @return the amount of cash there was in the drawer
     */
    public double finishDay() {
        double totalCash = this.cashInDrawer;
        this.cashInDrawer = 0;
        return totalCash;
    }

    /**
     * Starts a transaction
     *
     * @return if there is money in the drawer and it is not currently in a
     * transaction
     */
    public boolean startTransaction() {
        this.isInTransaction = this.cashInDrawer != 0 && this.isInTransaction() == false;
        this.numItemsInTrans = 0;
        this.amountPaid = 0;
        this.transTotal = 0;
        return this.cashInDrawer != 0 && this.isInTransaction() == false;
    }

    /**
     * Finishes a transaction
     *
     * @return if it is in the middle of a transaction and money still owed
     */
    public boolean finishTransaction() {
        if (this.isInTransaction() && this.getAmountPaid() >= this.getTransactionTotal()) {
            this.cashInDrawer -= (this.amountPaid - this.transTotal);
            this.isInTransaction = false;
            return true;
        } else {
            return !this.isInTransaction();
        }
    }

    /**
     * Scans an item
     *
     * @param amount the price of the item
     */
    public void scanItem(double amount) {
        this.itemList.add(amount);
        this.transTotal += amount;
        this.numItemsInTrans++;
    }

    /**
     * Gets the total value of the transaction
     *
     * @return the total value of the transaction
     */
    public double getTransactionTotal() {
        return this.transTotal;
    }

    /**
     * Gets the number of items in the transaction
     *
     * @return
     * @returnthe number of items in the transaction
     */
    public int getNumItemsInTrans() {
        return this.numItemsInTrans;
    }

    /**
     * Gets how much the costumer has paid
     *
     * @return how much the costumer has paid
     */
    public double getAmountPaid() {
        return this.amountPaid;
    }

    /**
     * Gets the name of the cash register
     *
     * @return the name of the cash register
     */
    public String getName() {
        return this.sName;
    }

    /**
     * States if it is in a transaction
     *
     * @return
     * @returnif it is in a transaction
     */
    public boolean isInTransaction() {
        return this.isInTransaction;
    }

    /**
     * Gets the amount owed by the costumer
     *
     * @return the amount owed by the costumer
     */
    public double getAmountOwed() {
        return this.getTransactionTotal() - this.getAmountPaid();
    }

    /**
     * Sets the name of the cash register
     *
     * @param sName
     */
    public void setName(String sName) {
        this.sName = sName;
    }

    /**
     * Collects the amount paid by the client
     *
     * @param amount
     * @return a value that is positive indicating the amount overpaid if change
     * is due, 0 if the exact amount was paid, or a negative value indicating
     * how much the customer
     */
    public double collectPayment(double amount) {
        double aux;
        this.amountPaid += amount;
        if (this.amountPaid >= this.getTransactionTotal()) {
            this.cashInDrawer += (this.getTransactionTotal() - (this.amountPaid - amount));
            aux = this.amountPaid;
            this.amountPaid = this.transTotal;
            this.numTransToday++;
            return aux - this.getTransactionTotal();
        } else {
            this.cashInDrawer += amount;
            return this.amountPaid - this.getTransactionTotal();
        }
    }

    /**
     * Returns the number of items purchased
     *
     * @return number of items purchased
     */
    public int getNumItemsToday() {
        return this.itemList.size();
    }

    /**
     * Returns the average price of items purchased today
     *
     * @return average price of items purchased today
     */
    public double getAveItemPurchasedToday() {
        double sum = 0;
        for (Double itemList1 : this.itemList) {
            sum += itemList1;
        }
        return sum / this.getNumItemsToday();
    }

    /**
     * Prints the entire list of items
     */
    public void displayItemList() {
        System.out.printf("Item Log: %d items purchased today%n",
                          this.itemList.size());
        for (int i = 0; i < this.itemList.size(); i++) {
            System.out.printf("$%.2f%n", this.itemList.get(i));
        }
    }

    /**
     * Returns the total number of transactions today
     *
     * @return the total number of transactions today
     */
    public int getNumTransToday() {
        return this.numTransToday;
    }

    /**
     * Returns the average price of items purchased
     *
     * @return the average price of items purchased
     */
    public double getAveTransToday() {
        double sum = 0;
        for (Double item : this.itemList) {
            sum += item;
        }
        return sum / this.getNumTransToday();
    }

    /**
     * Overriding the toString() method to give us an easy way to look at the
     * guts of the object.
     *
     * @return the string representing the value of the cash register
     */
    @Override
    public String toString() {
        if (this.isInTransaction()) {
            return String.format(
                    "%s: drawer: $%.2f CURRENT TRANS: #items: %d, total sale: $%.2f, amount paid: $%.2f%nTODAY: #items: %d, #trans: %d",
                    this.getName(), this.cashInDrawer, this.numItemsInTrans,
                    this.transTotal, this.amountPaid, this.itemList.size(),
                    this.getNumTransToday());
        } else {
            return String.format(
                    "%s: drawer: $%.2f NOT IN TRANSACTION%nTODAY: #items: %d, #trans: %d",
                    this.getName(), this.cashInDrawer, this.itemList.size(),
                    this.getNumTransToday());
        }
    }
}
