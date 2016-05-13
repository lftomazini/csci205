/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Anmol Singh and Luis Felipe Franco Candeo Tomazini
 * Date: Sep 23, 2015
 * Time: 8:16:58 PM
 *
 * Project: csci205
 * Package: lab10
 * File: HRUtility
 * Description:
 *
 * ****************************************
 */
package lab10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author as062
 */
public final class HRUtility {
    private static SimpleDateFormat empDateFormat = new SimpleDateFormat(
            "yyyy-mm-dd");

    public static void displayEmployee(Employee emp) {
        if (emp instanceof Manager) {
            System.out.printf(
                    emp.getEmpID() + ": " + emp.getFirstName() + " " + emp.getLastName() + " [MANAGER] \n");
        } else {
            System.out.printf(
                    emp.getEmpID() + ": " + emp.getFirstName() + " " + emp.getLastName() + "\n");
        }

    }

    public static void displayEmployees(List<Employee> listOfEmps) {
        for (int i = 0; i < listOfEmps.size(); i++) {
            displayEmployee(listOfEmps.get(i));
        }
    }

    /**
     * Helper method to parse a date string into a date object. This is really
     * here just to show how to deal with an exception that may be thrown in a
     * method.
     *
     * @param sDate - a date string
     * @return a <code>Date</code> object
     * @throws ParseException if the string cannot be parse correctly.
     */
    public static Date strToDate(String sDate) throws ParseException {
        return empDateFormat.parse(sDate);
    }

    /**
     * Prints out the manager and the list of employees under the manager
     *
     * @param mgr
     */
    public static void displayManager(Manager mgr) {
        System.out.println(
                "Manager:     " + mgr.getFirstName() + " " + mgr.getLastName());
        System.out.println("Department:  " + mgr.getDeptName());
        System.out.println("# Employees: " + mgr.getEmpList().size());
        displayEmployees(mgr.getEmpList());
        System.out.println("\n");
    }

    /**
     *
     * @param date the value of date
     */
    public static String dateToStr(Date date) {
        String reportDate = empDateFormat.format(date);
        return reportDate;
    }
}
