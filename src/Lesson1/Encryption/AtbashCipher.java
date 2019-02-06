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
public class AtbashCipher extends AbstractCipher{

    @Override
    public String encrypt(String original) {
        StringBuilder sb = new StringBuilder();
        char[] chArr = original.toCharArray();
        for(char c : chArr){
            int index = findCharIndex(c);
            sb.append((index == -1 ? c :ALPHABETH[ALPHABETH.length-index-1]));
        }
        return sb.toString();
    }

    @Override
    public String decrypt(String encrypted) {
        return encrypt(encrypted);
    }
    
}
