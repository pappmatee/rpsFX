import java.net.*;
import java.io.*;

public class Server {

    public static void main(String[] args) throws Exception {
        //Runs method runSocket on port 1337
        runSocket(1337, 10);
    }

    //This method opens and runs a socket
    public static void runSocket(int port, int roundNum) {

        //Exceptions handling
        try {

            //New class that implements the socket
            ServerSocket Services = new ServerSocket(port);

            System.out.println("Game is about to start");

            int rounds = 0;

            //Virtually infinite loop
            while (rounds <= roundNum) {

                //Waits and thus accepts (if present) a connection for clients
                Socket connectionSocket1 = Services.accept();
                Socket connectionSocket2 = Services.accept();

                //Prepares buffered object to reads from and writes to a client's socket
                InputStreamReader reader1 = new InputStreamReader(connectionSocket1.getInputStream());
                InputStreamReader reader2 = new InputStreamReader(connectionSocket2.getInputStream());
                BufferedReader player1 = new BufferedReader(reader1);
                BufferedReader player2 = new BufferedReader(reader2);
                OutputStreamWriter w1 = new OutputStreamWriter(connectionSocket1.getOutputStream());
                OutputStreamWriter w2 = new OutputStreamWriter(connectionSocket2.getOutputStream());
                BufferedWriter outToClient1 = new BufferedWriter(w1);
                BufferedWriter outToClient2 = new BufferedWriter(w2);

                //Read all the lines from the client, in this case one being one character only
                String player1Sign = player1.readLine();
                String player2Sign = player2.readLine();

                String declaration = null;
                String declaration2 = null;

                if (rounds == roundNum) {
                    declaration = "OVER";
                    declaration2 = "OVER";
                    rounds = 0;
                } else {
                    //COnditions of victory or loss for each player
                    if (player1Sign.equals(player2Sign)) {
                        declaration = "DRAW";
                        declaration2 = "DRAW";
                        rounds++;
                    } else if ((player1Sign.equals("ROCK")) && (player2Sign.equals("SCISSORS"))) {
                        declaration = "WIN";
                        declaration2 = "LOSE";
                        rounds++;
                    } else if ((player1Sign.equals("ROCK")) && (player2Sign.equals("PAPER"))) {
                        declaration = "LOSE";
                        declaration2 = "WIN";
                        rounds++;
                    } else if ((player1Sign.equals("PAPER")) && (player2Sign.equals("ROCK"))) {
                        declaration = "WIN";
                        declaration2 = "LOSE";
                        rounds++;
                    } else if ((player1Sign.equals("PAPER")) && (player2Sign.equals("SCISSORS"))) {
                        declaration = "LOSE";
                        declaration2 = "WIN";
                        rounds++;
                    } else if ((player1Sign.equals("SCISSORS")) && (player2Sign.equals("PAPER"))) {
                        declaration = "WIN";
                        declaration2 = "LOSE";
                        rounds++;
                    } else if ((player1Sign.equals("SCISSORS")) && (player2Sign.equals("ROCK"))) {
                        declaration = "LOSE";
                        declaration2 = "WIN";
                        rounds++;
                    } else if (player1Sign.equals("GIVEUP") || player2Sign.equals("GIVEUP")) {
                        declaration = "EXIT";
                        declaration2 = "EXIT";
                    }
                }

                //Sends out output to each client
                outToClient1.write(declaration, 0, declaration.length());
                outToClient2.write(declaration2, 0, declaration2.length());
                outToClient1.flush();
                outToClient2.flush();
                System.out.println("Player 1: " + declaration);
                System.out.println("Player 2: " + declaration2);

                //Closes the sockets
                connectionSocket1.close();
                connectionSocket2.close();
            }
            //Exceptions are handled if no connections are present or programme times out
        } catch (IOException e) {
            System.out.println("Error:");
            System.out.println(e);
        }

    }
}
