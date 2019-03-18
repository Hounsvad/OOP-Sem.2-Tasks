
import java.util.Scanner;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class SocketClient {

    public static void main(String[] args) {
        String str;
        Scanner inputStream = null;
        PrintWriter outputStream = null;

        try (Socket clientSocket = new Socket("localhost", 3333);
                Scanner keyboard = new Scanner(System.in)) {
            // Set up streams to send/receive data
            outputStream = new PrintWriter(clientSocket.getOutputStream(), true);
            inputStream = new Scanner(clientSocket.getInputStream());
            

            // Start massage from server:
            System.out.println("Getting line");
            System.out.println(inputStream.nextLine());
            System.out.println("Line gotten");
            // Read a line from the keyboard:
            outputStream.println("Hello this is string" + new Date().toString() + "\n");

            // Read answer from the server and output it to the screen
            str = inputStream.nextLine();
            System.out.println(str);

        } catch (Exception e) {
            // If any exception occurs, display it
            System.out.println("Error " + e);
        } finally {
            inputStream.close();
            outputStream.close();
        }
    }
}
