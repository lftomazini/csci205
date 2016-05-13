/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Anmol Singh and Luis Felipe Franco Candeo Tomazini
 * Date: Sep 24, 2015
 * Time: 3:27:23 PM
 *
 * Project: csci205
 * Package: lab10
 * File: ManagerTest
 * Description:
 *
 * ****************************************
 */
package lab10;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author as062
 */
public class ManagerTest {

    public ManagerTest() {
        ArrayList<Employee> listOfEmp = new ArrayList<>();
    }

    public Manager mgr;

    public ArrayList<Employee> listOfEmps = new ArrayList<>();

    @Before
    public void setUp() throws ParseException, ManagerException {

        mgr = new Manager(0, "Brian", "King", 1234546789,
                          HRUtility.strToDate("2010-10-09"), 60000,
                          "HR");

        Employee emp_1 = new Employee(1, "Keth", "Buffington", 1010101011,
                                      HRUtility.strToDate("2010-10-08"), 150000);
        Employee emp_2 = new Employee(2, "Kenneth", "Buffinton", 1010101012,
                                      HRUtility.strToDate("2010-10-08"), 150000);
        Employee emp_3 = new Employee(201, "Kennet", "Buffington", 1010101013,
                                      HRUtility.strToDate("2010-10-08"), 150000);
        Employee emp_4 = new Employee(4, "Keneth", "Buffington", 1010101014,
                                      HRUtility.strToDate("2010-10-08"), 150000);
        Employee emp_5 = new Employee(0, "Knneth", "Buffington", 1010101015,
                                      HRUtility.strToDate("2010-10-08"), 150000);
        Employee emp_6 = new Employee(200, "Kenneth", "Bufington", 1010101410,
                                      HRUtility.strToDate("2010-10-08"), 150000);
        listOfEmps.add(emp_1);
        listOfEmps.add(emp_2);
        listOfEmps.add(emp_3);
        listOfEmps.add(emp_4);
        listOfEmps.add(emp_5);
        listOfEmps.add(emp_6);

        mgr.addEmployee(emp_1);
        mgr.addEmployee(emp_3);
        mgr.addEmployee(emp_2);
    }

    @After
    public void tearDown() {
        listOfEmps.clear();
    }

    /**
     * Test of addEmployee method, of class Manager.
     */
    @Test
    public void testAddEmployee() throws ManagerException {
        System.out.println("addEmployee");
        assertEquals(mgr.getEmpList().size(), 3);

        mgr.addEmployee(listOfEmps.get(3));
        assertEquals(mgr.getEmpList().size(), 4);

    }

    /**
     * Test of getEmpList method, of class Manager.
     */
    @Test
    public void testGetEmpList() {
        System.out.println("getEmpList");
        assertEquals;

        List<Employee> expResult = null;
        List<Employee> result = instance.getEmpList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeEmployee method, of class Manager.
     */
    @Test
    public void testRemoveEmployee() throws Exception {
        System.out.println("removeEmployee");
        Employee emp = null;
        Manager instance = null;
        instance.removeEmployee(emp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeEmployee method Exception, of class Manager.
     */
    @Test(expected = ManagerException.class)
    public void testRemoveEmployeeException() {
        System.out.println("removeEmployeeException");
        Employee emp = null;
        Manager instance = null;
        instance.removeEmployee(emp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addEmployee method Exception, of class Manager.
     */
    @Test(expected = ManagerException.class)
    public void testAddEmployeeException() {
        System.out.println("addEmployeeException");
        Employee emp = null;
        Manager instance = null;
        instance.addEmployee(emp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
