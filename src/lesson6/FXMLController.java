/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson6;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
    private ImageView[] uiSlots;
    private final Thread[] slots = new Thread[3];
    private int upCount = 0;
    private boolean[] shouldKeepRunning = new boolean[3];
    @FXML
    private Label youWin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for (int i = 0; i < 10; i++) {
            images[i] = new Image(getClass().getResourceAsStream("resources/fruits" + i + ".png"));
        }
        uiSlots = new ImageView[]{slot1, slot2, slot3};
    }

    @FXML
    private void slotClicked(MouseEvent event) {
        try {
            for (int i = 0; i < uiSlots.length; i++) {
                if (((ImageView) event.getSource()).equals(uiSlots[i])) {
                    ShouldNotRunning(i);
                    slots[i].join();
                    hasEnded();
                }
            }
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }

    private void hasEnded() {
        if (getUpCount() == 0) {
            this.running = false;
            checkWinStatus();
        }
    }

    private void checkWinStatus() {
        if (uiSlots[0].getImage() == uiSlots[1].getImage()
                && uiSlots[0].getImage() == uiSlots[2].getImage()) {
            youWin.setVisible(true);
        }
    }

    @FXML
    private void handleClicked(MouseEvent event) {
        if (!this.running) {
            this.running = true;
            for (int i = 0; i < slots.length; i++) {
                slots[i] = new Thread(new Spinner(i, (int) (Math.random() * 9), 100 + (i * 20)));
                slots[i].setDaemon(true);
                shouldKeepRunning[i] = true;
                slots[i].start();
            }
        } else {
            youWin.setVisible(false);
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

    public synchronized boolean getShouldKeepRunning(int index) {
        return shouldKeepRunning[index];
    }

    public synchronized void ShouldNotRunning(int index) {
        shouldKeepRunning[index] = false;
    }

    private class Spinner implements Runnable {

        ImageView image;
        int initialImage;
        long delay;
        int slot;

        public Spinner(int slot, int initialImage, long delay) {
            this.slot = slot;
            this.image = uiSlots[slot];
            this.initialImage = initialImage;
            this.delay = delay;
        }

        @Override
        public void run() {
            int i = initialImage;
            try {
                updateThreadCount(true);
                while (true) {
                    if (!getShouldKeepRunning(slot)) {
                        break;
                    }
                    final Integer suckADick = i % 10;
                    if (images[suckADick] == null) {
                        System.out.println("Suck a dick");
                        System.exit(-1);
                    }
                    Platform.runLater(() -> image.setImage(images[suckADick]));
                    Thread.sleep(delay);
                    i++;
                }
            } catch (InterruptedException e) {
                System.out.println(e);
            } finally {
                updateThreadCount(false);
            }

        }
    }
}
