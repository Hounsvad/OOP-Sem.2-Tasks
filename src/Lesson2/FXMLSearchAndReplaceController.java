/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson2;

import java.net.URL;
import java.io.File;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Hounsvad
 */
public class FXMLSearchAndReplaceController implements Initializable {

    @FXML
    private TextField textFieldSearch;
    @FXML
    private TextField textFieldReplace;
    @FXML
    private TextArea textAreaInput;
    
    private File file;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void buttonReplace(ActionEvent event) {
        
    }

    @FXML
    private void buttonOpen(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        file = fileChooser.showOpenDialog(null);
        if(file.isFile() && file.canRead()){
            textAreaInput = 
        }
    }

    @FXML
    private void buttonSaveAs(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.showOpenDialog(null);
    }

}
