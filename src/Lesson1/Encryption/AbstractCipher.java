/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson1.Encryption;

/**
 *
 * @author Hounsvad
 */
public abstract class AbstractCipher implements CipherInterface {

    public int findCharIndex(char ch) {
        for (int i = 0; i < ALPHABETH.length; i++) {
            if (ch == ALPHABETH[i]) {
                System.out.println(i);
                return i;
            }
        }
        return -1;
    }
}
