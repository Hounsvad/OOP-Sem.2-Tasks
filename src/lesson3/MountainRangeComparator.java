/*This is code written by Frederik Alexander Hounsvad
 * The use of this code in a non commercial and non exam environment is permitted
 */
package lesson3;

import java.util.Comparator;

/**
 *
 * @author Pinnacle F
 */
public class MountainRangeComparator implements Comparator<Mountain>{

    @Override
    public int compare(Mountain o1, Mountain o2) {
        return o1.getRange().compareTo(o2.getRange()) == 0 ? o1.getName().compareTo(o2.getName()) : o1.getRange().compareTo(o2.getRange());
    }
    
}
