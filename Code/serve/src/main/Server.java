package main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server {

    private ServerSocket server;
    private boolean isAlive = true;
    private LinkedList<Connection> connections = new LinkedList<>();
    private MessageSender messageSender = new MessageSender();
    private Dialog dialog = new Dialog();

    public void init() {
        try {
            server = new ServerSocket(8080);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Creating socket connection error");
        }
    }

    public void start() {
        while (isAlive) {
            try {
                Socket client = server.accept();
                System.out.print("Connection accepted.");
                Connection connection = new Connection(client, dialog);
                connection.addWriterToSender(messageSender);
                connections.add(connection);
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Client accepting exception");
                isAlive = false;
            }
        }
        disconnect();
    }

    private void disconnect(){

    }

}


