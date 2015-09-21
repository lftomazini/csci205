/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Luis Felipe Franco Candeo Tomazini
 * Date: Sep 20, 2015
 * Time: 1:49:48 PM
 *
 * Project: csci205
 * Package: lab09
 * File: CashRegisterTest
 * Description:
 *
 * ****************************************
 */
package lab09;

import java.util.LinkedList;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author lffct001
 */
public class CashRegisterTest {
    static final double EPSILON = 1.0E-12;

    CashRegister instance;

    public CashRegisterTest() {
    }

    @Before
    public void setUp() {
        instance = new CashRegister();
    }

    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of getPurchaseCount method, of class CashRegister.
     */
    @Test
    public void testGetPurchaseCount() {
        System.out.println("getPurchaseCount");
        //Test the initiasl state = should have NO items
        assertEquals(0, instance.getPurchaseCount());

        //Now, set up a test of 2 items
        instance.scanItem(0.55);
        instance.scanItem(1.27);
        int expResult = 2;
        int result = instance.getPurchaseCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListOfPurchases method, of class CashRegister.
     */
    @Test
    public void testGetListOfPurchases() {
        System.out.println("getListOfPurchases");

        //Now, set up a test of 2 items
        instance.scanItem(0.55);
        instance.scanItem(1.27);

        LinkedList<Double> expResult;
        expResult = new LinkedList<>();
        expResult.add(0.55);
        expResult.add(1.27);

        LinkedList<Double> result = (LinkedList<Double>) instance.getListOfPurchases();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTransactionTotal method, of class CashRegister.
     */
    @Test
    public void testGetTransactionTotal() {
        System.out.println("getTransactionTotal");
        assertEquals(0, instance.getTransactionTotal(), EPSILON);

        //Now, set up a test of 2 items
        instance.scanItem(0.55);
        instance.scanItem(1.27);
        double expResult = 1.82;
        double result = instance.getTransactionTotal();
        assertEquals(expResult, result, EPSILON);
    }

    /**
     * Test of getPaymentCollected method, of class CashRegister.
     */
    @Test
    public void testGetPaymentCollected() {
        System.out.println("getPaymentCollected");
        //Test the initiasl state = should have NO payment
        assertEquals(0, instance.getPaymentCollected(), EPSILON);

        //Now, set up a test of 3 payments
        instance.collectPayment(Money.DOLLAR, 1);
        instance.collectPayment(Money.QUARTER, 3);
        instance.collectPayment(Money.NICKEL, 2);
        double expResult = 1.85;
        double result = instance.getPaymentCollected();
        assertEquals(expResult, result, EPSILON);
    }

    /**
     * Test of giveChange method, of class CashRegister.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGiveChange() throws Exception {
        System.out.println("giveChange");

        //Now, set up a test of 2 items and 3 payments
        instance.scanItem(0.55);
        instance.scanItem(1.27);
        instance.collectPayment(Money.DOLLAR, 1);
        instance.collectPayment(Money.QUARTER, 3);
        instance.collectPayment(Money.NICKEL, 2);
        double expResult = 0.03;
        double result = instance.giveChange();
        assertEquals(expResult, result, EPSILON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testScanItemLowException() {
        instance.scanItem(-0.5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testScanItemHighException() {
        instance.scanItem(1E6);
    }

    /**
     * Test of giveChange method, of class CashRegister.
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCollectPaymentException() {
        System.out.println("collectPaymentException");

        //Now, set up a test of 2 items and 3 payments
        instance.collectPayment(Money.QUARTER, -3);
    }

    @Test(expected = ChangeException.class)
    public void testGiveChangeException() throws ChangeException {
        System.out.println("giveChangeException");

        //Now, set up a test of 2 items and 1 payment
        instance.scanItem(0.55);
        instance.scanItem(1.27);
        instance.collectPayment(Money.DOLLAR, 1);
        instance.giveChange();
    }
}
