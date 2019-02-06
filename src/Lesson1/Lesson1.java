package Lesson1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Hounsvad
 */
public class Lesson1 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
//        CipherInterface cipher;

//        String message = "Her har vi en Meddelelse, som er hemmelig!";
//        System.out.println("Original: \n" + message);
//
//        // Fjern ud-kommenteringen, når AtbashCipher skal testes
//        cipher = new AtbashCipher();
//        String enc = cipher.encrypt(message);
//        System.out.println("Atbash: \n" + enc);
//        System.out.println(cipher.decrypt(enc));
//
//        // Fjern ud-kommenteringen, når CeasarCipher skal testes
//        cipher = new CeasarCipher(13);
//        enc = cipher.encrypt(message);
//        System.out.println("Ceasar 13: \n" + enc);
//        System.out.println(cipher.decrypt(enc));
    }
    
}
