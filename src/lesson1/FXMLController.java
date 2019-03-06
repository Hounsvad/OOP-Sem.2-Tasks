/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson1;

import lesson1.encryption.CipherInterface;
import lesson1.encryption.AtbashCipher;
import lesson1.encryption.CeasarCipher;
import lesson1.shape.ShapeFacade;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Hounsvad
 */
public class FXMLController implements Initializable {

    @FXML
    private RadioButton radioButtonAtbash;
    @FXML
    private ToggleGroup toggleGroupCipher;
    @FXML
    private RadioButton radioButtonCaesar;
    @FXML
    private TextArea textAreaOutput;
    @FXML
    private TextArea textAreaInput;
    @FXML
    private Spinner<Integer> spinnerRotCount;
    @FXML
    private Button buttonSave;
    @FXML
    private Button buttonDecode;
    @FXML
    private Button buttonEncode;
    @FXML
    private RadioButton radioButtonEllipse;
    @FXML
    private ToggleGroup toggleGroupShape;
    @FXML
    private RadioButton radioButtonRectangle;
    @FXML
    private RadioButton radioButtonCircle;
    @FXML
    private RadioButton radioButtonSquare;
    @FXML
    private TextField textFieldSecondParam;
    @FXML
    private Label labelSecondInput;
    @FXML
    private TextField textFieldFirstParam;
    @FXML
    private Label labelFirstInputd;
    @FXML
    private TextArea textAreaShapeOutput;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        spinnerRotCount.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, CipherInterface.ALPHABETH.length - 1, 1));
        radioButtonEllipse.setUserData(ShapeFacade.SHAPES.ELLIPSE);
        radioButtonRectangle.setUserData(ShapeFacade.SHAPES.RECTANGLE);
        radioButtonCircle.setUserData(ShapeFacade.SHAPES.CIRCLE);
        radioButtonSquare.setUserData(ShapeFacade.SHAPES.SQUARE);

    }

    @FXML
    private void saveToFile(ActionEvent event) {
        File f = new File("Output.txt");
        try (PrintWriter pw = new PrintWriter(f);) {
            pw.println("(&Input&)");
            pw.println(textAreaInput.getText());
            pw.println("(&Output&)");
            pw.println(textAreaOutput.getText());
            pw.close();
        } catch (FileNotFoundException e) {

        }
    }

    @FXML
    private void updateEncoder(MouseEvent event) {
        if (toggleGroupCipher.getSelectedToggle() == radioButtonAtbash) {
            buttonEncode.setText("Transcode");
            buttonDecode.disableProperty().set(true);
            spinnerRotCount.disableProperty().set(true);
        } else {
            buttonEncode.setText("Encode");
            buttonDecode.disableProperty().set(false);
            spinnerRotCount.disableProperty().set(false);
        }
    }

    @FXML
    private void encode(ActionEvent event) {
        CipherInterface cipher;
        cipher = toggleGroupCipher.getSelectedToggle() == radioButtonAtbash ? new AtbashCipher() : new CeasarCipher(spinnerRotCount.getValue());
        textAreaOutput.setText(cipher.encrypt(textAreaInput.getText()));
    }

    @FXML
    private void decode(ActionEvent event) {
        CipherInterface cipher;
        cipher = toggleGroupCipher.getSelectedToggle() == radioButtonAtbash ? new AtbashCipher() : new CeasarCipher(spinnerRotCount.getValue());
        textAreaOutput.setText(cipher.decrypt(textAreaInput.getText()));
    }

    @FXML
    private void getShapeInfo(ActionEvent event) {
        ShapeFacade.SHAPES shape = (ShapeFacade.SHAPES) toggleGroupShape.getSelectedToggle().getUserData();
        switch (shape) {
            case SQUARE:
            case CIRCLE:
                textAreaShapeOutput.setText(ShapeFacade.getInstance().getShapeInfo(shape, new double[]{Double.parseDouble(textFieldFirstParam.getText())}));
                break;
            case RECTANGLE:
            case ELLIPSE:
                textAreaShapeOutput.setText(ShapeFacade.getInstance().getShapeInfo(shape, new double[]{Double.parseDouble(textFieldFirstParam.getText()), Double.parseDouble(textFieldSecondParam.getText())}));
                break;
            default:
                throw new AssertionError();
        }
    }

    @FXML
    private void updateShape(ActionEvent event) {
        ShapeFacade.SHAPES shape = (ShapeFacade.SHAPES) toggleGroupShape.getSelectedToggle().getUserData();
        switch (shape) {
            case SQUARE:
            case CIRCLE:
                labelSecondInput.disableProperty().set(true);
                textFieldSecondParam.disableProperty().set(true);
                break;
            case RECTANGLE:
            case ELLIPSE:
                labelSecondInput.disableProperty().set(false);
                textFieldSecondParam.disableProperty().set(false);
                break;
            default:
                throw new AssertionError();
        }
    }

}
