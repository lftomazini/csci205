/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Luis Felipe Franco Candeo Tomazini
 * Date: Oct 21, 2015
 * Time: 2:00:34 PM
 *
 * Project: csci205
 * Package: lab13
 * File: KelvinConvertUtility
 * Description: Swing
 *
 * ****************************************
 */
package lab13;

/**
 *
 * @author lftomazini
 */
public class KelvinConvertUtility {
    /**
     * Utility method to convert a Celsius temperature to Kelvin
     *
     * @param celTemp Celsius tempt to convert
     * @return equivalent temperature in Kelvin
     */
    public static double convertCtoK(double celTemp) {
        return 273.15 + celTemp;
    }

    /**
     * Utility method to convert a Celsius temperature specified by a String to
     * Kelvin
     *
     * @param celTemp Celsius temp (as a String) to convert
     * @return equivalent Kelvin temperature (as a String)
     * @throws NumberFormatException
     */
    public static String strConvertCtoK(String celTemp) throws NumberFormatException {
        double c = Double.valueOf(celTemp);
        return Double.toString(convertCtoK(c));
    }

    /**
     * Utility method to convert a Fahrenheit temperature to Kelvin
     *
     * @param fahTemp Fahrenheit tempt to convert
     * @return equivalent temperature in Kelvin
     */
    public static double convertFtoK(double fahTemp) {
        return (((459.67 + fahTemp) * 5) / 9);
    }

    /**
     * Utility method to convert a Celsius temperature specified by a String to
     * Kelvin
     *
     * @param fahTemp Fahrenheit temp (as a String) to convert
     * @return equivalent Kelvin temperature (as a String)
     * @throws NumberFormatException
     */
    public static String strConvertFtoK(String fahTemp) throws NumberFormatException {
        double f = Double.valueOf(fahTemp);
        return Double.toString(convertCtoK(f));
    }
}
