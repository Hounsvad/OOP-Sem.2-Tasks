package lesson4.opg2_numberplates;

import java.util.Map;

/**
 * VOP eksamen F2014 
 * Kodeskelet til opgave 2
 *
 * @author erso
 */
public class NumberPlates {

    public static final int LENGTH = 7;         // Noejagtig laengde paa nummerplade
    
    private Map<String, String> districtMap;    // Kendingsbogstaver -> Politikreds
    
    private VehicleType[] vehicleTypes = {      // Intervaller for anvendelse
        new VehicleType("Motorcykel", 10000, 19999),
        new VehicleType("Privat personvogn", 20000, 45999),
        new VehicleType("Udlejningsvogn", 46000, 46999),
        new VehicleType("Hyrevogn", 47000, 48999),
        new VehicleType("Skolevogn", 49000, 49899),
        new VehicleType("Ambulance el. lign.", 49900, 49999),
        new VehicleType("Diverse andre ", 50000, 84999)
    };

    public NumberPlates() {
        // opg 2a) initialiser districtMap

    }

    public void readFile() {
        // opg 2a) Indlaes filen og put i mappen
    }

    public String validate(String plate) {
        // Opg 2b) Tjek nummerpladen og returner anvendelse og politidistrikt
        return null;
    }

    private String validateDistrict(String districtCode) {
        // Opg 2b) Tjek kendingsbogstaver og returner politidistrikt
        return null;
    }

    private String validateVehicleType(int number) {
        // Opg 2b) Tjek hvilket interval number ligger i og returner anvendelse
        return null;
    }

    public static void main(String[] arg) {
        // Opg 2) Kan benyttes til test af opgave 2a og 2b
        NumberPlates pd = new NumberPlates();

        System.out.println("KC39078: " + pd.validate("KC39078"));
        System.out.println("kc49900: " + pd.validate("kc49900"));
        System.out.println("KO47078: " + pd.validate("KO47078"));
        System.out.println("EN19022: " + pd.validate("EN19022"));
        System.out.println("EN190220: " + pd.validate("EN190220"));
    }

}
