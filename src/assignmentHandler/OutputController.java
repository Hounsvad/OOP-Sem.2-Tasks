/*This is code written by Frederik Alexander Hounsvad
 * The use of this code in a non commercial and non exam environment is permitted
 */
package assignmentHandler;

import java.io.PrintStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Pinnacle F
 */
public class OutputController implements Initializable {

    @FXML
    private RadioMenuItem radioWrapText;
    @FXML
    private TextArea textDisplay;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.setOut(myStream);
    }

    @FXML
    private void pressClose(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void presClear(ActionEvent event) {
        textDisplay.clear();
    }

    @FXML
    private void updateWrapText(ActionEvent event) {
        textDisplay.setWrapText(radioWrapText.isSelected());
    }

    public PrintStream myStream = new PrintStream(System.out) {
        @Override
        public void print(String input) {
            if (input != null) {
                textDisplay.appendText(input);
            } else {
                throw new NullPointerException();
            }
        }

        @Override
        public void println(String input) {
            print(input + "\n");
        }

        @Override
        public PrintStream printf(String format, Object... args) {
            if (format != null) {
                textDisplay.appendText(String.format(format, (Object) args));
            } else {
                throw new NullPointerException();
            } //To change body of generated methods, choose Tools | Templates.
            return this;
        }
        
    };
}
