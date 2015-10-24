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
 * File: KelvinConvertModel
 * Description: Swing
 *
 * ****************************************
 */
package lab13;

import javax.swing.BoundedRangeModel;
import javax.swing.DefaultBoundedRangeModel;

/**
 *
 * @author lftomazini
 */
public class KelvinConvertModel {
    public static enum TempUnits {
        FAH_TEMP, CEL_TEMP;
    }

    private double tempToConvert;
    private TempUnits tempUnits;
    private BoundedRangeModel tempRange;

    public double getTempToConvert() {
        return tempToConvert;
    }

    public TempUnits getTempUnits() {
        return tempUnits;
    }

    public void setTempToConvert(double tempToConvert) {
        this.tempToConvert = tempToConvert;
    }

    public void setTempUnits(TempUnits tempUnits) {
        this.tempUnits = tempUnits;
    }

    public void setTempRange(BoundedRangeModel tempRange) {
        this.tempRange = tempRange;
    }

    public BoundedRangeModel getTempRange() {
        return tempRange;
    }

    public KelvinConvertModel() {
        this.tempToConvert = 25.0;
        this.tempUnits = TempUnits.FAH_TEMP;
        this.tempRange = new DefaultBoundedRangeModel((int) tempToConvert, 0, 0,
                                                      100);
    }
}
