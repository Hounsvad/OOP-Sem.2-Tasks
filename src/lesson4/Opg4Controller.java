/*This is code written by Frederik Alexander Hounsvad
 * The use of this code in a non commercial and non exam environment is permitted
 */
package lesson4;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import lesson4.opg2_numberplates.NumberPlates;
import lesson4.opg3_playingcards.DeckOfCards;

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
    @FXML
    private TextArea cardOutput;
    @FXML
    private ToggleGroup shuffleCount;
    
    DeckOfCards doc = new DeckOfCards();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        postCards();
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

    @FXML
    private void shuffle(ActionEvent event) {
        doc.shuffle(Integer.parseInt(((Node)shuffleCount.getSelectedToggle()).getAccessibleText()));
        postCards();
    }
    
    private void postCards(){
        cardOutput.setText(doc.toString());
    }

}
