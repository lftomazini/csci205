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
 * File: KelvinConvertController
 * Description: Swing
 *
 * ****************************************
 */
package lab13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import lab13.KelvinConvertModel.TempUnits;
import static lab13.KelvinConvertUtility.convertCtoK;
import static lab13.KelvinConvertUtility.convertFtoK;

/**
 *
 * @author lftomazini
 */
public class KelvinConvertController implements ActionListener, ChangeListener {
    private KelvinConvertModel theModel;
    private MainView theView;

    KelvinConvertController(KelvinConvertModel theModel, MainView theView) {
        this.theModel = theModel;
        this.theView = theView;
        updateViewFromModel();
        theView.getSliderTemp().addChangeListener(this);
        theView.getTextMinTemp().addActionListener(this);
        theView.getTextMaxTemp().addActionListener(this);
        theView.getRdbtnCelTemp().addActionListener(this);
        theView.getRdbtnFahTemp().addActionListener(this);

    }

    private void updateViewFromModel() {
        if (theModel.getTempUnits() == TempUnits.FAH_TEMP) {
            theView.getRdbtnFahTemp().setSelected(true);
        } else {
            theView.getRdbtnCelTemp().setSelected(true);
        }

        theView.getLblCurTemp().setText(String.valueOf(
                theModel.getTempRange().getValue()));
        theView.getTextMinTemp().setText(Integer.toString(
                theModel.getTempRange().getMinimum()));
        theView.getTextMaxTemp().setText(Integer.toString(
                theModel.getTempRange().getMaximum()));

        theView.getSliderTemp().setModel(theModel.getTempRange());

        if (theModel.getTempUnits() == TempUnits.FAH_TEMP) {
            String output = new DecimalFormat("##.##").format(convertFtoK(
                    theModel.getTempRange().getValue()));
            theView.getTextTempKelvin().setText(output);
        } else {
            theView.getTextTempKelvin().setText(Double.toString(
                    convertCtoK(
                            (double) theModel.getTempRange().getValue())));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == theView.getTextMinTemp()) {
                theModel.getTempRange().setMinimum(Integer.valueOf(
                        theView.getTextMinTemp().getText()));
                updateViewFromModel();
            }

            if (e.getSource() == theView.getTextMaxTemp()) {
                theModel.getTempRange().setMaximum(Integer.valueOf(
                        theView.getTextMaxTemp().getText()));
                updateViewFromModel();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(theView, "Number Format Error!",
                                          theView.getTextMinTemp().getText() + " is a not a number!",
                                          JOptionPane.ERROR_MESSAGE);
        }
        if (e.getSource() == theView.getLblCurTemp()) {
            theView.getLblCurTemp().setText(Integer.toString(
                    theModel.getTempRange().getValue()));
            updateViewFromModel();
        }

        if (e.getSource() == theView.getRdbtnFahTemp()) {
            theModel.setTempUnits(TempUnits.FAH_TEMP);
            updateViewFromModel();
        }

        if (e.getSource() == theView.getRdbtnCelTemp()) {
            theModel.setTempUnits(TempUnits.CEL_TEMP);
            updateViewFromModel();
        }
    }

    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == theView.getSliderTemp()) {
            theModel.setTempRange(theView.getSliderTemp().getModel());
            updateViewFromModel();
        }
    }

}
