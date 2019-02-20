/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson2Prep.danishIsles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author erso
 */
public class DanishIslandFileReader {

    private File inFile;
    private List<DanishIsland> islandList;

    public DanishIslandFileReader(String fName) {
        inFile = new File("src\\Lesson2Prep\\danishIsles\\" + fName);
    }

    private void readFile() {
        islandList = new ArrayList<>();
        String line;
        String[] tokens;

        String name = "";
        double circ;
        double area;
        int addr;
        int adkm;
//        try(FileWriter pw = new FileWriter(inFile, true)){
//            pw.write("Hello test");
//        }catch(Exception e){
            
        
        
        try (Scanner scan = new Scanner(inFile)){
            while(scan.hasNextLine()){
                line = scan.nextLine();
                tokens = line.split(" ");
                name = tokens[0] ;
                circ = Double.parseDouble(tokens[1]);
                area = Double.parseDouble(tokens[2]);
                addr = Integer.parseInt(tokens[3]);
                adkm = Integer.parseInt(tokens[4]);
                islandList.add(new DanishIsland(name, circ, area, addr, adkm));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // OPGAVEN:    
        // Laes filen en linje ad gangen. Split linjen paa mellemrums tegnet.
        // Konverter de enkelte vaerdier til typerne der skal bruges i DanishIsland.
        // Opret et objekt for hver linje og tilfoej det til listen.
        // Vaer omhyggelig med at fange exceptions og faa lukke Scanner og fil
            
    }
    
    public List<?> getList(){
        return islandList;
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(new File(".").getAbsolutePath());
        DanishIslandFileReader fr = new DanishIslandFileReader("Islands punktum.txt");
        //DanishIslandFileReader fr = new DanishIslandFileReader("Islands komma.txt");
        fr.readFile();
        
        
        System.out.println("Result:\n" + fr.getList());

    }


}
