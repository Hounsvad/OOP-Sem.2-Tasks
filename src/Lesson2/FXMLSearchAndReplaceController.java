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
    private TextField textFieldSearch;
    @FXML
    private TextField textFieldReplace;
    @FXML
    private TextArea textAreaInput;

    private File file = null;

    private IndexRange selectionIndex = null;

    private String toBeReplaced;

    private String replacement;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void buttonReplace(ActionEvent event) {
        selectionIndex = textAreaInput.getSelection();
        toBeReplaced = textFieldSearch.getText();
        replacement = textFieldReplace.getText();
        String input = textAreaInput.getText();

        if (textAreaInput.getSelectedText().isEmpty()) {
            textAreaInput.setText(input.replaceFirst(toBeReplaced, replacement));
        } else {
            textAreaInput.setText(input.substring(0, selectionIndex.getStart())
                    + textAreaInput.getText(selectionIndex.getStart(), selectionIndex.getEnd()).replaceFirst(toBeReplaced, replacement)
                    + input.substring(selectionIndex.getEnd())
            );
            selectionIndex = new IndexRange(selectionIndex.getStart(), selectionIndex.getEnd() + (replacement.length() - toBeReplaced.length()));
            textAreaInput.selectRange(selectionIndex.getStart(), selectionIndex.getEnd());
        }
    }

    @FXML
    private void buttonReplaceAll(ActionEvent event) {
        selectionIndex = textAreaInput.getSelection();
        toBeReplaced = textFieldSearch.getText();
        replacement = textFieldReplace.getText();
        String input = textAreaInput.getText();

        if (textAreaInput.getSelectedText().isEmpty()) {
            textAreaInput.setText(input.replaceFirst(toBeReplaced, replacement));
        } else {
            textAreaInput.setText(input.substring(0, selectionIndex.getStart())
                    + textAreaInput.getText(selectionIndex.getStart(), selectionIndex.getEnd()).replaceAll(toBeReplaced, replacement)
                    + input.substring(selectionIndex.getEnd())
            );
            selectionIndex = new IndexRange(selectionIndex.getStart(), selectionIndex.getEnd() + (replacement.length() - toBeReplaced.length()));
            textAreaInput.selectRange(selectionIndex.getStart(), selectionIndex.getEnd() - (input.length() - textAreaInput.getText().length()));
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
                textAreaInput.clear();
                while (fileReader.hasNextLine()) {
                    textAreaInput.appendText(fileReader.nextLine());
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
                fw.write(textAreaInput.getText());
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
                System.out.println(textAreaInput.getText());
                fw.write(textAreaInput.getText());
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
        toBeReplaced = textFieldSearch.getText();
        replacement = textFieldReplace.getText();
        textFieldSearch.setText(replacement);
        textFieldReplace.setText(toBeReplaced);
    }

    @FXML
    private void butttonClear(ActionEvent event) {
        file = null;
        selectionIndex = null;
        toBeReplaced = "";
        replacement = "";
        textAreaInput.clear();
        textFieldReplace.clear();
        textFieldSearch.clear();
    }
}
