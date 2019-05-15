package rpsFX.network;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Class representing the connection to the server.
 */
///CLOVER:OFF
public class Client {

    public static String playerResult;

    /**
     * Method connecting to the server.
     * @param choice the choice made by the player
     */
    public static void connection(String choice) {

            try {

                //Open connection towards clients
                System.out.println("Attempting socket connection to localhost:1337");
                InetAddress address = InetAddress.getByName("localhost");

                //Open a new socket belonging to one client towards a server at a specific address and port
                Socket client = new Socket("localhost", 1337);
                System.out.println("Client ready.\n");

                //Create classes to access outputs from the clients and write
                InputStreamReader reader = new InputStreamReader(client.getInputStream());
                BufferedReader inbox = new BufferedReader(reader);
                OutputStreamWriter writer = new OutputStreamWriter(client.getOutputStream());
                BufferedWriter outbox = new BufferedWriter(writer);

                //Ask the user to type
                String inputStr = choice;
                System.out.println("user selected the letter : " + inputStr);

                //Sends the user's choice off to the server
                outbox.write(inputStr + "\n", 0, inputStr.length() + 1);
                //This method forces any buffered output bytes to be written out
                outbox.flush();

                //Clear the previous result
                playerResult = "";

                //Receives result from server
                playerResult = inbox.readLine();
                System.out.println(playerResult);

                //Exceptions are handled if no connections are present or program times out
            } catch (IOException e) {

                System.out.println(e);
            }

    }
}
///CLOVER:ON