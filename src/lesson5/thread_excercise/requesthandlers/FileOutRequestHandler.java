/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson5.thread_excercise.requesthandlers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.print.Printer;

/**
 *
 * @author Hounsvad
 */
public class FileOutRequestHandler extends AbstractRequestHandler
{

    Date timeStamp;
    String input;
    InetAddress address;
    int port;
    String fileName;
    ObjectInputStream is = null;
    ObjectOutputStream os = null;
    FileWriter fos = null;

    public FileOutRequestHandler(Socket socket, String fileName)
    {
        super(socket);
        this.fileName = fileName;
        this.address = socket.getInetAddress();
        this.port = socket.getPort();
        System.out.println("Handler created");
    }

    @Override
    public void run()
    {
        System.out.println("run requested");
        try
        {
            os = new ObjectOutputStream(socket.getOutputStream());
            is = new ObjectInputStream(socket.getInputStream());            
            Scanner kb = new Scanner(System.in);
            fos = new FileWriter(new File(fileName), true);
            
            System.out.println("Streams created");
            os.writeUTF(kb.nextLine());
            System.out.println("Initial message sent");

            this.input = is.readUTF();
            this.timeStamp = new Date();
            fos.write(this.timeStamp.toString()
                    + "\t"
                    + this.address.getHostAddress()
                    + ":"
                    + this.port
                    + "\t"
                    + this.input
            );

        } catch (SocketException e)
        {
            System.out.println("Socket Exception: " + e);
            System.exit(0);
        } catch (IOException e)
        {
            System.out.println("IO Exception: " + e);
            System.exit(0);
        } catch (Exception e)
        {
            System.out.println("Exception" + e);
            System.exit(0);
        } finally
        {
            if (is != null)
            {
                is.close();
                if (os != null)
                {
                    os.close();
                    if (fos != null)
                    {
                        try
                        {
                            fos.close();
                        } catch (IOException ex)
                        {
                            System.out.println("Error on closing fileWriter" + ex);
                        }
                    }
                }
            }
        }
    }

}
