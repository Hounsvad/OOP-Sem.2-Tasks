package Lesson3;

import java.util.Arrays;

/**
 *
 * @author erso 
 *  Udleveret kode skelet med main()-metode til opgave 4, VOP eksamen 10 juni 2016
 */
public class Mountain implements Comparable<Mountain> {

    String name;
    int height;
    int prominence;
    String lattitude;
    String longtitude;
    String range;

    public Mountain(String name, int height, int prominence, String lattitude, String longtitude, String range) {
        this.name = name;
        this.height = height;
        this.prominence = prominence;
        this.lattitude = lattitude;
        this.longtitude = longtitude;
        this.range = range;
    }
    //Mont Ventoux h=1909, pro=1148, lat=44°10'26", lon=05°16'42", ran=Alps    
    @Override
    public String toString() {
        return String.format("Mont %s h=%d, pro=%d, lat=%s, lon=%s, ran=%s",name,height,prominence,lattitude,longtitude,range);
    }

    @Override
    public int compareTo(Mountain o) {
        return Integer.compare(prominence, o.prominence) == 0 ? Integer.compare(height, o.height) : Integer.compare(prominence, o.prominence);
    }
    

    /**
     * @param args
     */
    public static void main(String[] args) {
        // Til test af Mountain-klassen

        //Opg a Test af constructor og toString()
        // NB: \u00B0 er unicode for grade-tegnet
//        Mountain m = new Mountain("Mont Ventoux", "1909", "1148", "44\u00B010'26\"", "05\u00B016'42\"", "Alps");
//        System.out.println(m);

        // Opg b Test af compareTo()
        Mountain[] testArray = new Mountain[4];
//        testArray[0] = new Mountain("Pic du Midi d'Ossau", "2886", "1092", "42\u00B048'22\"", "-00\u00B025'05\"", "Pyrenees");
//        testArray[1] = new Mountain("Pic de Bure", "2709", "1268", "44\u00B037'38\"", "05\u00B056'07\"", "Alps");
//        testArray[2] = new Mountain("Mont Chaberton", "3131", "1281", "44\u00B057'53\"", "06\u00B045'06\"", "Alps");
//        testArray[3] = new Mountain("Pica d'Estats", "3143", "1281", "42\u00B042'43\"", "00\u00B057'23\"", "Pyrenees");

        System.out.println("Usorteret: ");
        System.out.println(Arrays.toString(testArray));

        System.out.println("Sorteret: ");
        Arrays.sort(testArray);
        System.out.println(Arrays.toString(testArray));

    }



}
