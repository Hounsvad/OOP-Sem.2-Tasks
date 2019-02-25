/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson1.encryption;

/**
 *
 * @author Hounsvad
 */
public class CeasarCipher extends AbstractCipher {

    int rotFactor;

    public CeasarCipher(int rotFactor) {
        this.rotFactor = rotFactor;
    }

    @Override
    public String encrypt(String original) {
        StringBuilder sb = new StringBuilder();
        char[] chArr = original.toCharArray();
        for (char c : chArr) {
            int index = findCharIndex(c);
            sb.append(index == -1 ? c : ALPHABETH[Math.floorMod(index + rotFactor, ALPHABETH.length)]);
        }
        return sb.toString();
    }

    @Override
    public String decrypt(String encrypted) {
        StringBuilder sb = new StringBuilder();
        char[] chArr = encrypted.toCharArray();
        for (char c : chArr) {
            int index = findCharIndex(c);
            sb.append(index == -1 ? c : ALPHABETH[Math.floorMod(index - rotFactor, ALPHABETH.length)]);
        }
        return sb.toString();
    }

}
