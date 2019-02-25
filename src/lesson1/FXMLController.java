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
    private RadioButton radioButton_Atbash;
    @FXML
    private ToggleGroup toggleGroup_Cipher;
    @FXML
    private RadioButton radioButton_Caesar;
    @FXML
    private TextArea textArea_Output;
    @FXML
    private TextArea textArea_Input;
    @FXML
    private Spinner<Integer> spinner_RotCount;
    @FXML
    private Button button_Save;
    @FXML
    private Button button_Decode;
    @FXML
    private Button button_Encode;
    @FXML
    private RadioButton radioButton_Ellipse;
    @FXML
    private ToggleGroup toggleGroup_Shape;
    @FXML
    private RadioButton radioButton_Rectangle;
    @FXML
    private RadioButton radioButton_Circle;
    @FXML
    private RadioButton radioButton_Square;
    @FXML
    private TextField textField_SecondParam;
    @FXML
    private Label label_SecondInput;
    @FXML
    private TextField textField_FirstParam;
    @FXML
    private Label label_FirstInput;
    @FXML
    private TextArea textArea_ShapeOutput;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        spinner_RotCount.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, CipherInterface.ALPHABETH.length - 1, 1));
        radioButton_Ellipse.setUserData(ShapeFacade.SHAPES.ELLIPSE);
        radioButton_Rectangle.setUserData(ShapeFacade.SHAPES.RECTANGLE);
        radioButton_Circle.setUserData(ShapeFacade.SHAPES.CIRCLE);
        radioButton_Square.setUserData(ShapeFacade.SHAPES.SQUARE);

    }

    @FXML
    private void saveToFile(ActionEvent event) {
        File f = new File("Output.txt");
        try (PrintWriter pw = new PrintWriter(f);) {
            pw.println("(&Input&)");
            pw.println(textArea_Input.getText());
            pw.println("(&Output&)");
            pw.println(textArea_Output.getText());
            pw.close();
        } catch (FileNotFoundException e) {

        }
    }

    @FXML
    private void updateEncoder(MouseEvent event) {
        if (toggleGroup_Cipher.getSelectedToggle() == radioButton_Atbash) {
            button_Encode.setText("Transcode");
            button_Decode.disableProperty().set(true);
            spinner_RotCount.disableProperty().set(true);
        } else {
            button_Encode.setText("Encode");
            button_Decode.disableProperty().set(false);
            spinner_RotCount.disableProperty().set(false);
        }
    }

    @FXML
    private void encode(ActionEvent event) {
        CipherInterface cipher;
        cipher = toggleGroup_Cipher.getSelectedToggle() == radioButton_Atbash ? new AtbashCipher() : new CeasarCipher(spinner_RotCount.getValue());
        textArea_Output.setText(cipher.encrypt(textArea_Input.getText()));
    }

    @FXML
    private void decode(ActionEvent event) {
        CipherInterface cipher;
        cipher = toggleGroup_Cipher.getSelectedToggle() == radioButton_Atbash ? new AtbashCipher() : new CeasarCipher(spinner_RotCount.getValue());
        textArea_Output.setText(cipher.decrypt(textArea_Input.getText()));
    }

    @FXML
    private void getShapeInfo(ActionEvent event) {
        ShapeFacade.SHAPES shape = (ShapeFacade.SHAPES) toggleGroup_Shape.getSelectedToggle().getUserData();
        switch (shape) {
            case SQUARE:
            case CIRCLE:
                textArea_ShapeOutput.setText(ShapeFacade.getInstance().getShapeInfo(shape, new double[]{Double.parseDouble(textField_FirstParam.getText())}));
                break;
            case RECTANGLE:
            case ELLIPSE:
                textArea_ShapeOutput.setText(ShapeFacade.getInstance().getShapeInfo(shape, new double[]{Double.parseDouble(textField_FirstParam.getText()), Double.parseDouble(textField_SecondParam.getText())}));
                break;
            default:
                throw new AssertionError();
        }
    }

    @FXML
    private void updateShape(ActionEvent event) {
        ShapeFacade.SHAPES shape = (ShapeFacade.SHAPES) toggleGroup_Shape.getSelectedToggle().getUserData();
        switch (shape) {
            case SQUARE:
            case CIRCLE:
                label_SecondInput.disableProperty().set(true);
                textField_SecondParam.disableProperty().set(true);
                break;
            case RECTANGLE:
            case ELLIPSE:
                label_SecondInput.disableProperty().set(false);
                textField_SecondParam.disableProperty().set(false);
                break;
            default:
                throw new AssertionError();
        }
    }

}
