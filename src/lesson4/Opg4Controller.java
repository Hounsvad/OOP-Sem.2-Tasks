/*This is code written by Frederik Alexander Hounsvad
 * The use of this code in a non commercial and non exam environment is permitted
 */
package lesson4;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import lesson4.opg2_numberplates.NumberPlates;

/**
 * FXML Controller class
 *
 * @author Pinnacle F
 */
public class Opg4Controller implements Initializable {

    @FXML
    private TextField inputLicenceplate;
    @FXML
    private Label labelLicenceplate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void enterLicenceplate(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            pressLicenceplate(null);
        }
    }

    @FXML
    private void pressLicenceplate(ActionEvent event) {
        NumberPlates np = new NumberPlates();
        labelLicenceplate.setText(np.validate(inputLicenceplate.getText().toUpperCase()));
    }

}
