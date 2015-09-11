/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Luis Felipe Franco Candeo Tomazini
 * Date: Sep 9, 2015
 * Time: 3:13:34 PM
 *
 * Project: csci205
 * Package: lab06
 * File: CashRegister
 * Description: Classes, Part I
 *
 * ****************************************
 */
package lab06;

/**
 *
 * @author Luis Felipe Tomazini
 */
public class CashRegister {

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
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CashRegister reg1 = new CashRegister(), reg2 = new CashRegister(
                "Register 2");
        System.out.println("Constructed:\n" + reg1 + "\n" + reg2);
        reg1.setName("Register 1");
        reg1.startDay(100.0);
        reg2.startDay(200.0);
        System.out.println("Started day:\n" + reg1 + "\n" + reg2);
        System.out.println(
                "TESTING: reg1: New transaction: $2.50, $9.95, $5.50 = $17.95");
        reg1.startTransaction();
        reg1.scanItem(2.50);
        reg1.scanItem(9.95);
        reg1.scanItem(5.50);
        System.out.println(
                "reg1.isInTransaction() = true. ACTUAL = " + reg1.isInTransaction());
        System.out.printf("reg1.getTotal() = $17.95. ACTUAL = $%.2f%n",
                          reg1.getTransactionTotal());
        System.out.println(
                "reg1.getNumItems() = 3. ACTUAL = " + reg1.getNumItemsInTrans());
        System.out.println(
                "reg1.getAmountPaid = 0.0 ACTUAL = " + reg1.getAmountPaid());
        System.out.println(
                "reg1.getAmountOwed() = 17.95. ACTUAL = " + reg1.getAmountOwed());
        System.out.println("Testing out toString() for reg1...");
        System.out.println(reg1);
        double amtBack = reg1.collectPayment(15.0);
        System.out.printf(
                "reg1: made payment of $15. Result = -2.95: ACTUAL = $%.2f%n",
                amtBack);
        System.out.println(reg1);
        System.out.println(
                "reg1: reg1.finishTransaction() = false. ACTUAL = " + reg1.finishTransaction());
        System.out.printf(
                "reg1: reg1.collectPayment(10), result: $7.05 ACTUAL = $%.2f%n",
                reg1.collectPayment(10));
        System.out.println(reg1);
        System.out.println(
                "reg1: reg1.finishTransaction() = true. ACTUAL = " + reg1.finishTransaction());
        System.out.println(reg1);
        System.out.println(
                "reg1: New transaction: $10, $7.50, $19.95, $5 = $42.45");
        reg1.startTransaction();
        reg1.scanItem(10);
        reg1.scanItem(7.50);
        reg1.scanItem(19.95);
        reg1.scanItem(5.00);
        System.out.println(reg1);
        System.out.printf("reg1.collectPayment($42.45) = 0.0. ACTUAL = $%.2f%n",
                          reg1.collectPayment(42.45));
        System.out.println(reg1);
        reg1.finishTransaction();
        System.out.println("Checking reg2, should still be untouched:");
        System.out.println(reg2);
        System.out.printf("reg1.finishDay() = $160.40. ACTUAL = $%.2f%n",
                          reg1.finishDay());
        System.out.println("Reg1 should be empty: " + reg1);
        System.out.printf("reg2.finishDay(): = $200. ACTUAL = $%.2f%n",
                          reg2.finishDay());
        System.out.println("Reg2 shuold be empty: " + reg2);

    }

    /**
     * Constructor with no parameters
     */
    public CashRegister() {
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
        this.sName = sName;
    }

    /**
     * Initializes the amount in the cash drawer
     *
     * @param initCash
     */
    public void startDay(double initCash) {
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
        if (this.amountPaid > this.getTransactionTotal()) {
            this.cashInDrawer += (this.getTransactionTotal() - (this.amountPaid - amount));
            aux = this.amountPaid;
            this.amountPaid = this.transTotal;
            return aux - this.getTransactionTotal();
        } else {
            this.cashInDrawer += amount;
            return this.amountPaid - this.getTransactionTotal();
        }
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
                    "%s: drawer: $%.2f CURRENT TRANS: #items: %d, total sale: $%.2f, amount paid: $%.2f",
                    this.getName(), this.cashInDrawer, this.numItemsInTrans,
                    this.transTotal, this.amountPaid);
        } else {
            return String.format("%s: drawer: $%.2f NOT IN TRANSACTION",
                                 this.getName(), this.cashInDrawer);
        }
    }
}
