/*This is code written by Frederik Alexander Hounsvad
 * The use of this code in a non commercial and non exam environment is permitted
 */
package assignmentHandler;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Pinnacle F
 */
public class Assignment {
    String title;
    String discription;
    URL url;
    File file;
    boolean isGUI;
    String path;
    public Assignment(String title, String discription, String path, boolean isGUI) {
        try {
            this.title = title;
            this.discription = discription;
            this.path = path;
            this.file = new File(path);
            this.url = file.toURL();
            this.isGUI = isGUI;
            System.out.println("construct finished");
        } catch (MalformedURLException ex) {
            System.out.println("Error");
        }
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

    public File getFxml() {
        return file;
    }

    public boolean isIsGUI() {
        return isGUI;
    }

    public File getFile() {
        return file;
    }

    public String getPath() {
        return path;
    }
    
    
    @Override
    public String toString() {
        return title;
    }
    
    
}
