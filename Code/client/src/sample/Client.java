package sample;

import View.MyWindow;

import java.io.IOException;
import java.net.Socket;


public class Client extends Thread {

    private Socket client;
    private Application application = new Application();
    private MyWindow window;

    public Client(MyWindow window) {
        super();
        this.window = window;
    }

    @Override
    public void run(){
        try {
            client = new Socket("localhost", 8080);
        } catch (IOException e) {
            System.err.println("Client socket creation exception");
        }

        try {
            application.setReader(new Reader(client, window));
            application.setWriter(new Writer(client));
        } catch (IOException ex) {
            System.err.println("IO streams creation error");
        }
        application.setWindow(window);
        application.start();
    }
}