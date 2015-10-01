/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Anmol Singh and Luis Felipe Franco Candeo Tomazini
 * Date: Sep 22, 2015
 * Time: 3:22:29 PM
 *
 * Project: csci205
 * Package: lab10
 * File: HRDBSystem
 * Description:
 *
 * ****************************************
 */
package lab11;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author as062
 */
public class HRDBSystem {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws ParseException, ManagerException {
        Manager mgr_1 = new Manager(0, "Brian", "King", 1234546789,
                                    HRUtility.strToDate("2010-10-09"), 60000,
                                    "HR");
        Manager mgr_2 = new Manager(1, "Kenneth", "Buffington", 1010101010,
                                    HRUtility.strToDate("2010-10-08"), 150000,
                                    "ENGINEERING");
        Employee emp_1 = new Employee(1, "Keth", "Buffington", 1010101011,
                                      HRUtility.strToDate("2010-10-08"), 60000);
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
        Contractor cont_1 = new Contractor(73, "Builder", "Bob", 342942039,
                                           30.00);
        Contractor cont_2 = new Contractor(74, "Tomazini", "Luis", 247841794,
                                           35.00);
        ArrayList<Employee> empList = new ArrayList<>();

        mgr_1.addEmployee(emp_1);
        mgr_1.addEmployee(emp_3);
        mgr_1.addEmployee(emp_2);

        mgr_2.addEmployee(emp_4);
        mgr_2.addEmployee(emp_5);
        mgr_2.addEmployee(emp_6);

        empList.add(emp_1);
        empList.add(emp_2);
        empList.add(emp_3);
        empList.add(emp_4);
        empList.add(emp_5);
        empList.add(emp_6);
        HRUtility.displayManager(mgr_1);
        HRUtility.displayManager(mgr_2);
        HRUtility.displayEmployees(empList);

        emp_1.raiseSalary(10000);
        emp_1.changeName("Brain", "Kong");

        System.out.println(emp_1.getSalary());
        System.out.println(emp_1.getFirstName());
        System.out.println(emp_1.getLastName());

        // Create an account
        Account acc = new Account(2000.0);
        System.out.println(acc);
        // Test out a couple of payments, intentionally throwing an exception
        // with the second payment
        try {
            System.out.println(
                    "TEST: Printing a check to employee id: " + empList.get(0).getEmpID());
            acc.processCheck(empList.get(0), 50);
            // 40 hrs + 10 hrs overtime
            System.out.println(
                    "TEST: Printing a check to contractor id: " + cont_1.getId());
            acc.processCheck(cont_1, 35);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
        // Verify that funds were debited from the account
        System.out.println(acc);

        System.out.println("*** Employees BEFORE SORT ***");
        HRUtility.displayEmployees(empList);

        System.out.println("*** Employees AFTER SORT_BY_LASTNAME ***");
        Employee.setSortType(SortType.SORT_BY_LASTNAME);

        Collections.sort(empList);

        HRUtility.displayEmployees(empList);

        System.out.println(
                "*** Employees AFTER SORT_BY_ID ***");
        Employee.setSortType(SortType.SORT_BY_ID);

        Collections.sort(empList);

        HRUtility.displayEmployees(empList);
    }
}
