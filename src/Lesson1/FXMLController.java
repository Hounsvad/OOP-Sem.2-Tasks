/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson1;

import Lesson1.Encryption.CipherInterface;
import Lesson1.Encryption.AtbashCipher;
import Lesson1.Encryption.CeasarCipher;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Hounsvad
 */
public class FXMLController implements Initializable {

    @FXML
    private RadioButton RadioButton_Atbash;
    @FXML
    private ToggleGroup Kryptering;
    @FXML
    private RadioButton RadioButton_Caesar;
    @FXML
    private TextArea TextArea_Output;
    @FXML
    private TextArea TextArea_Input;
    @FXML
    private Spinner<Integer> Spinner_RotCount;
    @FXML
    private Button Button_Save;
    @FXML
    private Button Button_Decode;
    @FXML
    private Button Button_Encode;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Spinner_RotCount.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, CipherInterface.ALPHABETH.length - 1, 1));
    }

    @FXML
    private void saveToFile(ActionEvent event) {
        File f = new File("Output.txt");
        try (PrintWriter pw = new PrintWriter(f);) {
            pw.println("(&Input&)");
            pw.println(TextArea_Input.getText());
            pw.println("(&Output&)");
            pw.println(TextArea_Output.getText());
            pw.close();
        } catch (FileNotFoundException e) {

        }
    }

    @FXML
    private void Update(MouseEvent event) {
        if (Kryptering.getSelectedToggle() == RadioButton_Atbash) {
            Button_Encode.setText("Transcode");
            Button_Decode.disableProperty().set(true);
            Spinner_RotCount.disableProperty().set(true);
        } else {
            Button_Encode.setText("Encode");
            Button_Decode.disableProperty().set(false);
            Spinner_RotCount.disableProperty().set(false);
        }
    }

    @FXML
    private void Encode(ActionEvent event) {
        CipherInterface cipher;
        cipher = Kryptering.getSelectedToggle() == RadioButton_Atbash ? new AtbashCipher() : new CeasarCipher(Spinner_RotCount.getValue());
        TextArea_Output.setText(cipher.encrypt(TextArea_Input.getText()));
    }

    @FXML
    private void Decode(ActionEvent event) {
        CipherInterface cipher;
        cipher = Kryptering.getSelectedToggle() == RadioButton_Atbash ? new AtbashCipher() : new CeasarCipher(Spinner_RotCount.getValue());
        TextArea_Output.setText(cipher.decrypt(TextArea_Input.getText()));
    }

}
