/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Luis Felipe Franco Candeo Tomazini
 * Date: Sep 30, 2015
 * Time: 2:56:53 PM
 *
 * Project: csci205
 * Package: lab11
 * File: Contractor
 * Description: Intefaces
 *
 * ****************************************
 */
package lab11;

import static java.lang.Math.round;
import java.util.Date;
import static lab11.HRUtility.dateToStr;

/**
 *
 * @author lffct001
 */
public class Contractor implements Payable {

    private int id;
    private String firstName;
    private String lastName;
    private int ssNum;
    private double hourlyRate;

    public Contractor(int id, String firstName, String lastName, int ssNum,
                      double hourlyRate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssNum = ssNum;
        this.hourlyRate = hourlyRate;
    }

    public int getId() {
        return id;
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

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSsNum(int ssNum) {
        this.ssNum = ssNum;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculatePay(double numHrs) {
        return numHrs * this.getHourlyRate();
    }

    @Override
    public String getPayTo() {
        return this.getFirstName() + " " + this.getLastName();
    }

    @Override
    public String getPayMemo() {
        Date today = new Date();
        return this.getId() + ", Pay Date:" + dateToStr(today);
    }

    @Override
    public String toString() {
        String output = "Contractor: ";

        output = output.concat(String.valueOf(this.getId()));
        output = output.concat(", ");
        output = output.concat(this.getLastName());
        output = output.concat(", ");
        output = output.concat(this.getFirstName());
        output = output.concat(", ");
        output = output.concat(String.valueOf(this.getSsNum()));
        output = output.concat(", ");
        output = output.concat(String.valueOf(round(this.getHourlyRate())));

        return output;
    }

}
