/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Luis Felipe Franco Candeo Tomazini
 * Date: Sep 30, 2015
 * Time: 8:41:37 PM
 *
 * Project: csci205
 * Package: lab11
 * File: AccountTest
 * Description:
 *
 * ****************************************
 */
package lab11;

import java.text.ParseException;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author lffct001
 */
public class AccountTest {

    public AccountTest() {
    }

    public Employee emp;
    public Account acc;

    @Before
    public void setUp() throws ParseException {
        acc = new Account(2000.0);
        emp = new Employee(201, "Kennet", "Buffington", 1010101013,
                           HRUtility.strToDate("2010-10-08"), 150000);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of credit method, of class Account.
     */
    @Test
    public void testCredit() {
        System.out.println("credit");
        double amount = 0.0;
        acc.credit(500);
        Assert.assertEquals(2500.0, acc.getBalance(), 1.0E-10);
    }

    /**
     * Test of debit method, of class Account.
     */
    @Test
    public void testDebit() throws Exception {
        System.out.println("debit");
        double amount = 0.0;
        acc.debit(500);
        Assert.assertEquals(1500.0, acc.getBalance(), 1.0E-10);
    }

    /**
     * Test of processCheck method, of class Account.
     */
    @Test
    public void testProcessCheck() throws Exception {
        System.out.println("processCheck");
        Payable payee = emp;
        double hoursBilled = 10.0;
        acc.processCheck(payee, hoursBilled);
        Assert.assertEquals(acc.getBalance(), 1278.8462, 10E-1);
    }

    /**
     * Test of processCheckInsufficientFundsException method, of class Account.
     *
     * @throws lab11.InsufficientFundsException
     */
    @Test(expected = InsufficientFundsException.class)
    public void testProcessCheckInsufficientFundsException() throws InsufficientFundsException {
        System.out.println("processCheckInsufficientFundsException");
        Payable payee = emp;
        double hoursBilled = 3000.0;
        acc.processCheck(payee, hoursBilled);
    }

}
