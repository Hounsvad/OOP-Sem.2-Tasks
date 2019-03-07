package lesson4.opg2_numberplates;

import assignmentHandler.Main;
import java.io.File;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * VOP eksamen F2014
 * Kodeskelet til opgave 2
 *
 * @author erso
 */
public class NumberPlates {

    public static final int LENGTH = 7;         // Noejagtig laengde paa nummerplade

    private Map<String, String> districtMap;    // Kendingsbogstaver -> Politikreds

    private VehicleType[] vehicleTypes = { // Intervaller for anvendelse
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
        districtMap = new TreeMap<>();
        readFile();

    }

    public void readFile() {
        // opg 2a) Indlaes filen og put i mappen
        Scanner sc = new Scanner(Main.class.getResourceAsStream("/lesson4/Nummerplader.txt")).useDelimiter("/r/n");
        while (sc.hasNextLine()) {
            String[] tokens = sc.nextLine().split(":");
            districtMap.put(tokens[0], tokens[1]);
        }
        sc.close(); //just for good measure
    }

    public String validate(String plate) {
        // Opg 2b) Tjek nummerpladen og returner anvendelse og politidistrikt
        if (plate.length() != 7) {
            return "Invalid nummerplade";
        }
        StringBuilder sb = new StringBuilder();

        sb.append(validateVehicleType(Integer.parseInt(plate.substring(2)))).append(" fra ");
        sb.append(validateDistrict(plate.substring(0, 2)));
        return sb.toString();
    }

    private String validateDistrict(String districtCode) {
        // Opg 2b) Tjek kendingsbogstaver og returner politidistrikt
        String stringReturn = districtMap.get(districtCode);
        return stringReturn == null ? "Kreds findes ikke: " + districtCode : stringReturn;
    }

    private String validateVehicleType(int number) {
        // Opg 2b) Tjek hvilket interval number ligger i og returner anvendelse
        for (VehicleType v : vehicleTypes) {
            if (v.isA(number)) {
                return v.getVehicleType();
            }
        }
        return "Illegalt nummer: " + number;
    }
}
