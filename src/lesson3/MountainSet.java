/*This is code written by Frederik Alexander Hounsvad
 * The use of this code in a non commercial and non exam environment is permitted
 */
package lesson3;

import assignmentHandler.Main;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Pinnacle F
 */
public class MountainSet {
    
    Set<Mountain> mountains;
    
    public MountainSet() {
        this.mountains = new TreeSet<>();
    }
    
    public Set<Mountain> getMauntains() {
        return mountains;
    }

    //Aiguille de Scolette;3506;1069;45°09'36";06°46'07";Alps 
    public void loadMountains() {
        Scanner s = new Scanner(Main.class.getResourceAsStream("/lesson3/FranskeBjerge.csv"));
        while (s.hasNextLine()) {
            String[] tokens = s.nextLine().split(";");
            mountains.add(new Mountain(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5]));
        }
    }
    
    public Set<Mountain> sortByRange(Comparator comp) {
        Set<Mountain> set = new TreeSet<>(comp);
        set.addAll(mountains);
        return set;
    }
    
    public static void main(String[] args) {
        MountainSet m = new MountainSet();
        m.loadMountains();
        System.out.println(m.getMauntains());
        System.out.println("Sorted by range:\n" + m.sortByRange(new MountainRangeComparator()));
        
    }
}
