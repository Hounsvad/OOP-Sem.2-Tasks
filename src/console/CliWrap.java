/*This is code written by Frederik Alexander Hounsvad
 * The use of this code in a non commercial and non exam environment is permitted
 */
package console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Pinnacle F
 */
public class CliWrap extends ConsoleApplication {

    Stage primaryStage = new Stage();

    public CliWrap(String path, String title) {
        //final String[] args = getParameters().getRaw().toArray(new String[0]);
        final ConsoleView console = new ConsoleView();
        final Scene scene = new Scene(console);
        final URL styleSheetUrl = getStyleSheetUrl();
        if (styleSheetUrl != null) {
            scene.getStylesheets().add(styleSheetUrl.toString());
        }
        primaryStage.setTitle(title);
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(e -> primaryStage.close());
        primaryStage.show();

        System.setOut(console.getOut());
        System.setIn(console.getIn());
        System.setErr(console.getOut());
        final Thread thread = new Thread(() -> {
            Throwable throwable = null;
            try {
                invokeMain(null, path);
            } catch (Throwable e) {
                throwable = e;
            }
            final int result = throwable == null ? 0 : 1;
            if (this.pauseBeforeExit) {
                System.out.print("Press enter key to exit.");
                try {
                    new BufferedReader(new InputStreamReader(System.in)).readLine();
                } catch (IOException e) {
                    // ignore
                }
            }
            primaryStage.close();
        });
        thread.setName("Console Application Main Thread");
        thread.start();
    }

    @Override
    public void invokeMain(String[] args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void invokeMain(String[] args, String path) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalAccessException, IllegalArgumentException, IllegalArgumentException, InvocationTargetException, InvocationTargetException, InvocationTargetException, InvocationTargetException {
        Class<?> cls = Class.forName(path);
        Method meth = cls.getMethod("main", String[].class);
        String[] params = null;
        meth.invoke(cls, (Object) params);
    }
}
