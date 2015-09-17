/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Luis Felipe Franco Candeo Tomazini & Anmol Singh
 * Date: Sep 16, 2015
 * Time: 10:33:04 PM
 *
 * Project: csci205
 * Package: lab08
 * File: AddRemoveChoices
 * Description: Enumeration types
 *
 * ****************************************
 */
package lab08;

/**
 *
 * @author lffct001
 */
public enum AddRemoveChoices {
    ADD("Add coins"), REMOVE("Remove coins"), DONE("Done");

    private String label;

    AddRemoveChoices(String s) {
        this.label = s;
    }

    @Override
    public String toString() {
        return label;
    }
}
