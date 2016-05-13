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
package lab10;

import java.text.ParseException;
import java.util.ArrayList;

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
    }

}
