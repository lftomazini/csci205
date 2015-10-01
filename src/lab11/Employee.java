/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Anmol Singh and Luis Felipe Franco Candeo Tomazini
 * Date: 9/21/2015
 * Time: 10:30am
 *
 * Project: csci205
 * Package: lab10
 * File: Employee
 * Description:
 * A very basic abstraction for an employee in a simple HR system
 * ****************************************
 */
package lab11;

/**
 * A basic representation for an Employee.
 *
 * @author Anmol Singh and Luis Felipe Franco Candeo Tomazini
 */
import java.util.Date;
import java.util.HashSet;
import static lab11.HRUtility.dateToStr;

enum SortType {
    SORT_BY_LASTNAME, SORT_BY_ID;
}

/**
 * Employee - represents an employee in the database system
 *
 * @author brk009
 */
public class Employee implements Payable, Comparable<Employee> {

    public static final int HOURS_PER_WEEK = 40;
    public static final int WEEKS_PER_YEAR = 52;
    public static final double OVERTIME_PAY = 1.5;

    private static HashSet<Integer> setOfIDs = new HashSet<>();
    private static SortType sortType = SortType.SORT_BY_ID;

    private int empID;
    private String firstName;
    private String lastName;
    private int ssNum;
    private Date hireDate;
    private double salary;

    /**
     * Explicit construct to create new employee
     *
     * @param empID
     * @param firstName
     * @param lastName
     * @param ssNum
     * @param hireDate
     * @param salary
     */
    public Employee(int empID, String firstName, String lastName, int ssNum,
                    Date hireDate, double salary) {
        if (setOfIDs.contains(empID) || empID <= 0) {
            this.empID = generateID();
        } else {
            this.empID = empID;
            setOfIDs.add(empID);
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssNum = ssNum;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    public int getEmpID() {
        return empID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSsNum() {
        return ssNum;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public double getSalary() {
        return salary;
    }

    /**
     * Change the name of the employee
     *
     * @param first - New first name
     * @param last - New last name
     */
    public void changeName(String first, String last) {
        this.firstName = first;
        this.lastName = last;
    }

    private static int generateID() {
        int i = 1;
        while (setOfIDs.contains(i) == true) {
            i++;
        }
        setOfIDs.add(i);
        return i;
    }

    /**
     * Raise the salary by <code>salaryAdj</code> dollars.
     *
     * @param salaryAdj - amount to add to the current salary
     * @return the new salary
     */
    public double raiseSalary(double salaryAdj) {
        this.salary += salaryAdj;
        return this.salary;
    }

    /**
     * Checks to see if the two objects are equal or not
     *
     * @param obj
     * @return
     */
    public static void setSortType(SortType s) {
        sortType = s;
    }

    @Override
    public boolean equals(Object obj) {
        return (((Employee) obj).getSsNum() == this.getSsNum());
    }

    /**
     * Return a string representation of the Employee
     *
     * @return the String of comma delimited values
     */
    @Override
    public String toString() {
        String s = this.empID + "," + this.lastName + "," + this.firstName;
        s += String.format(",%09d", this.ssNum);
        s += "," + HRUtility.dateToStr(this.hireDate);
        s += String.format(",%.2f", this.salary);
        return s;
    }

    @Override
    public double calculatePay(double numHrs) {
        double hourlyRate = (this.getSalary() / (HOURS_PER_WEEK * WEEKS_PER_YEAR));

        if (numHrs > HOURS_PER_WEEK) {
            return Math.round(
                    ((hourlyRate * HOURS_PER_WEEK) + ((numHrs - HOURS_PER_WEEK) * hourlyRate * OVERTIME_PAY)) * 100) / 100.00;
        } else {
            return (Math.round(hourlyRate * numHrs) * 100.00) / 100.00;
        }
    }

    @Override
    public String getPayTo() {
        return this.getFirstName() + " " + this.getLastName();
    }

    @Override
    public String getPayMemo() {
        Date today = new Date();
        return this.getEmpID() + ", Pay Date:" + dateToStr(today);
    }

    @Override
    public int compareTo(Employee o) {
        if (sortType == SortType.SORT_BY_ID) {
            if (this.getEmpID() > o.getEmpID()) {
                return 1;
            } else if (this.getEmpID() == o.getEmpID()) {
                return 0;
            } else {
                return -1;
            }
        } else {
            return this.getLastName().compareTo(o.getLastName());
        }

    }
}
