/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Anmol Singh and Luis Felipe Franco Candeo Tomazini
 * Date: Sep 23, 2015
 * Time: 7:45:14 PM
 *
 * Project: csci205
 * Package: lab10
 * File: EmployeeTest
 * Description:
 *
 * ****************************************
 */
package lab10;

import java.text.ParseException;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author as062
 */
public class EmployeeTest {

    static final double EPSILON = 1.0E-10;

    public EmployeeTest() {
    }

    public Employee instance;

    @Before
    public void setUp() throws ParseException {
        instance = new Employee(201, "Kennet", "Buffington", 1010101013,
                                HRUtility.strToDate("2010-10-08"), 150000);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of changeName method, of class Employee.
     */
    @Test
    public void testChangeName() {
        System.out.println("changeName");
        assertEquals(instance.getFirstName(), "Kennet");
        assertEquals(instance.getLastName(), "Buffington");

        instance.changeName("Brian", "King");
        assertEquals(instance.getFirstName(), "Brian");
        assertEquals(instance.getLastName(), "King");
    }

    /**
     * Test of raiseSalary method, of class Employee.
     */
    @Test
    public void testRaiseSalary() {
        System.out.println("raiseSalary");
        assertEquals(instance.getSalary(), 150000, EPSILON);

        double expResult = 200000;
        double result = instance.raiseSalary(50000);
        assertEquals(expResult, result, EPSILON);
    }

    /**
     * Test of equals method, of class Employee.
     */
    @Test
    public void testEquals() throws ParseException {
        System.out.println("equals");
        Employee instance_2 = new Employee(200, "Kenneth", "Bufington",
                                           1010101410,
                                           HRUtility.strToDate("2010-10-08"),
                                           150000);
        assertFalse(instance.equals(instance_2));

        Employee instance_3 = new Employee(201, "Kennet", "Buffington",
                                           1010101013,
                                           HRUtility.strToDate("2010-10-08"),
                                           150000);
        assertTrue(instance.equals(instance_3));
    }

}
