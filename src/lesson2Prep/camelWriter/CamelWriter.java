/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson2Prep.camelWriter;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author erso
 */
public class CamelWriter {

    private File inFile;

    public CamelWriter(String fName) {
            inFile = new File("src\\Lesson2Prep\\camelWriter\\" + fName);
    }

    public void readLines() {
        try (Scanner sc = new Scanner(inFile)) {
            while (sc.hasNextLine()) {
                convert2camel(sc.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    private void convert2camel(String line) {
        String[] StringArray = line.toLowerCase().split("");
        StringBuilder sb = new StringBuilder();
        boolean hasHadSpace = false;
        for (String sA : StringArray) {
            //System.out.print(StringArray[i]);
            if (sA.equals(" ")) {
                hasHadSpace = true;
            } else if (hasHadSpace) {
                hasHadSpace = false;
                sb.append(sA.toUpperCase());
            } else {
                sb.append(sA);
            }
        }
        System.out.println(sb);
        // Split line til et String[] af de enkelte ord i linjen
        // Konverter 1. ord til små og resten til stort begyndelsesbogstav
        // Sammensæt ordene til ét langt ord og udskriv.
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CamelWriter cw = new CamelWriter("DryLips.txt");
        cw.readLines();
        cw = new CamelWriter("MaryAnn.txt");
        cw.readLines();
        cw = new CamelWriter("OhLand.txt");
        cw.readLines();
        
    }

}
