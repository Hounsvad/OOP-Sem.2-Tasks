/*This is code written by Frederik Alexander Hounsvad
 * The use of this code in a non commercial and non exam environment is permitted
 */
package assignmentHandler;

import java.net.URISyntaxException;
import java.net.URL;

/**
 *
 * @author Pinnacle F
 */
public class Assignment {
    String title;
    String discription;
    URL url;

    boolean isGUI;
    String path;
    public Assignment(String title, String discription, String path, boolean isGUI) throws URISyntaxException {
        this.title = title;
        this.discription = discription;
        this.path = path;
        this.url = Main.class.getResource(path);
        System.out.println(Main.class.getResource(path));
        this.isGUI = isGUI;
        System.out.println("Construction of " + title + " finished");
    }

    public String getTitle() {
        return title;
    }

    public String getDiscription() {
        return discription;
    }

    public URL getUrl() {
        return url;
    }

    public boolean isIsGUI() {
        return isGUI;
    }

    public String getPath() {
        return path;
    }
    
    @Override
    public String toString() {
        return title;
    }
    
    
}
