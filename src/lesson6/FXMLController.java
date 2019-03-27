/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson6;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author Hounsvad
 */
public class FXMLController implements Initializable {

    @FXML
    private Circle handle;
    @FXML
    private ImageView slot1;
    @FXML
    private ImageView slot2;
    @FXML
    private ImageView slot3;
    private boolean running = false;
    private Image[] images = new Image[10];
    private ImageView[] slots = new ImageView[]{slot1, slot2, slot3};
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for (int i = 0; i < 10; i++) {
            images[i] = new Image(getClass().getResourceAsStream("/recsources/fruits"+i+".png"));
        }
        for (ImageView slot : slots){
            slot.setImage(images[(int)Math.random()*10]);
        }
    }

    @FXML
    private void slot1Clicked(MouseEvent event) {
    }

    @FXML
    private void slot2Clicked(MouseEvent event) {
    }

    @FXML
    private void slot3Clicked(MouseEvent event) {
    }

    @FXML
    private void handleClicked(MouseEvent event) {
        if (!this.running) {
            this.running = true;

        }

    }
}
