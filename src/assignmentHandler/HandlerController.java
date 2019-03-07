/*This is code written by Frederik Alexander Hounsvad
 * The use of this code in a non commercial and non exam environment is permitted
 */
package assignmentHandler;

import console.CliWrap;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Pinnacle F
 */
public class HandlerController implements Initializable {

    private Label label;
    @FXML
    private ListView<Assignment> assignmentView;
    @FXML
    private TextArea assignmentDetail;

    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            assignmentView.getItems().add(new Assignment("Lesson1", "The first lesson", "/lesson1/FXML.fxml", true));
            assignmentView.getItems().add(new Assignment("Lesson2 Prep: CamelWriter", "A console application, that convertes text to camelcase", "lesson2Prep.camelWriter.CamelWriter", false));
            assignmentView.getItems().add(new Assignment("Lesson2 Prep: DanishIslands", "A console application, that lists danish islands", "lesson2Prep.danishIsles.DanishIslandFileReader", false));
            assignmentView.getItems().add(new Assignment("Lesson2", "Search and replace", "/lesson2/FXMLSearchAndReplace.fxml", true));
            assignmentView.getItems().add(new Assignment("Lesson3 Prep: Person", "An exorcise in comparable", "lesson3Prep.comparable_exercise.Person", false));
            assignmentView.getItems().add(new Assignment("Lesson3 Prep: TextAnalyzer", "An exorcise in comparable", "lesson3Prep.exercise_text_analyser.TextAnalyzer", false));
            assignmentView.getItems().add(new Assignment("Lesson3", "An exorcise in comparable", "lesson3.Mountain", false));
            assignmentView.getItems().add(new Assignment("Lesson4", "lesson4", "/lesson4/Opg4.fxml", true));
        } catch (URISyntaxException ex) {
            System.out.println("Error");
        }
    }

    @FXML
    private void assignmentClicked(MouseEvent event) throws IOException, ClassNotFoundException, ClassNotFoundException, NoSuchMethodException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InvocationTargetException {
        assignmentDetail.setText(assignmentView.getSelectionModel().getSelectedItem().getDiscription());
        if (event.getClickCount() >= 2 && event.getButton().equals(event.getButton().PRIMARY)) {
            assignmentLaunch(new ActionEvent());
        }
    }

    @FXML
    private void assignmentLaunch(ActionEvent event) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Assignment current = assignmentView.getSelectionModel().getSelectedItem();
        if (current.isGUI) {
            try {
                FXMLLoader loader = new FXMLLoader(assignmentView.getSelectionModel().getSelectedItem().getUrl());
                Parent root1 = (Parent) loader.load();
                Stage stage = new Stage();
                stage.setTitle(assignmentView.getSelectionModel().getSelectedItem().getTitle());
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (IOException e) {

            }
        } else {
            CliWrap wrapper = new CliWrap(current.getPath(), current.getTitle());
        }
    }
}
