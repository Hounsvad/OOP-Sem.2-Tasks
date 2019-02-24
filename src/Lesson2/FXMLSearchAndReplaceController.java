/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson2;

import java.net.URL;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.IndexRange;
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
    private TextField search;
    @FXML
    private TextField replace;
    @FXML
    private TextArea input;

    private File file = null;

    private IndexRange selection = null;

    private String varSearch;

    private String varReplace;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void buttonReplace(ActionEvent event) {
        selection = input.getSelection();
        varSearch = search.getText();
        varReplace = replace.getText();
        String varInput = input.getText();

        if (input.getSelectedText().isEmpty()) {
            input.setText(varInput.replaceFirst(varSearch, varReplace));
        } else {
            input.setText(varInput.substring(0, selection.getStart())
                    + input.getText(selection.getStart(), selection.getEnd()).replaceFirst(varSearch, varReplace)
                    + varInput.substring(selection.getEnd())
            );
            selection = new IndexRange(selection.getStart(), selection.getEnd() + (varReplace.length() - varSearch.length()));
            input.selectRange(selection.getStart(), selection.getEnd());
        }
    }

    @FXML
    private void buttonReplaceAll(ActionEvent event) {
        selection = input.getSelection();
        varSearch = search.getText();
        varReplace = replace.getText();
        String varInput = input.getText();

        if (input.getSelectedText().isEmpty()) {
            input.setText(varInput.replaceFirst(varSearch, varReplace));
        } else {
            input.setText(varInput.substring(0, selection.getStart())
                    + input.getText(selection.getStart(), selection.getEnd()).replaceAll(varSearch, varReplace)
                    + varInput.substring(selection.getEnd())
            );
            selection = new IndexRange(selection.getStart(), selection.getEnd() + (varReplace.length() - varSearch.length()));
            input.selectRange(selection.getStart(), selection.getEnd() - (varInput.length() - input.getText().length()));
        }

    }

    @FXML
    private void buttonOpen(ActionEvent event
    ) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open");
        if (file != null) {
            fileChooser.setInitialDirectory(file.getParentFile());
        }
        file = fileChooser.showOpenDialog(null);
        if (file != null && file.isFile() && file.canRead()) {
            try (Scanner fileReader = new Scanner(file)) {
                input.clear();
                while (fileReader.hasNextLine()) {
                    input.appendText(fileReader.nextLine());
                }
            } catch (FileNotFoundException ex) {
                //ex.printStackTrace();
                System.out.println("Error in open");
            }
        }
    }

    @FXML
    private void buttonSaveAs(ActionEvent event
    ) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save as");
        if (file != null) {
            fileChooser.setInitialDirectory(file.getParentFile());
        }
        file = fileChooser.showSaveDialog(null);
        if (file != null) {
            try (FileWriter fw = new FileWriter(file, false)) {
                System.out.println("Saving as");
                fw.write(input.getText());
            } catch (IOException ex) {
                //ex.printStackTrace();
                System.out.println("Error in save as");
            }
        }
    }

    @FXML
    private void buttonSave(ActionEvent event
    ) {
        if (file == null) {
            buttonSaveAs(event);
        } else {
            try (FileWriter fw = new FileWriter(file, false)) {
                System.out.println("Saving");
                System.out.println(input.getText());
                fw.write(input.getText());
            } catch (IOException ex) {
                //ex.printStackTrace();
                System.out.println("Error in save");
            }
        }
    }

    @FXML
    private void buttonExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void buttonSwap(ActionEvent event) {
        varSearch = search.getText();
        varReplace = replace.getText();
        search.setText(varReplace);
        replace.setText(varSearch);
    }

    @FXML
    private void butttonClear(ActionEvent event) {
        file = null;
        selection = null;
        varSearch = "";
        varReplace = "";
        input.clear();
        replace.clear();
        search.clear();
    }
}
