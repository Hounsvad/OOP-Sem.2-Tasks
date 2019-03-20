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
    private final Image[] images = new Image[10];
    private final ImageView[] uiSlots = new ImageView[]{slot1, slot2, slot3};
    private final Spinner[] slots = new Spinner[3];
    private int upCount = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for (int i = 0; i < 10; i++) {
            images[i] = new Image(getClass().getResourceAsStream("/recsources/fruits" + i + ".png"));
        }
        for (int i = 0; i < slots.length; i++) {
            //slot.setImage(images[(int) (Math.random() * 9)]);
            slots[i] = new Spinner(uiSlots[i], (int) (Math.random() * 9), 100 + (i * 10));
            slots[i].start();
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

    public synchronized void updateThreadCount(boolean up) {
        if (up) {
            upCount++;
        } else {
            upCount--;
        }

    }

    public synchronized int getUpCount() {
        return upCount;
    }

    private class Spinner extends Thread {

        ImageView image;
        int initialImage;
        long delay;

        public Spinner(ImageView slot, int initialImage, long delay) {
            this.image = slot;
            this.initialImage = initialImage;
            this.delay = delay;
        }

        @Override
        public void run() {
            int i = initialImage;
            try {
                while (true) {
                    image.setImage(images[i % 10]);
                    Thread.sleep(delay);
                    i++;
                }
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

    }
}
