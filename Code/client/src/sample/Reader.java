package sample;

import View.MyWindow;
import javafx.application.Platform;
import org.json.JSONException;
import org.json.JSONObject;
import javafx.scene.control.Label;
import java.io.*;
import java.net.Socket;

public class Reader extends Thread{
    private BufferedReader bufferedReader;
    private boolean isAlive = true;
    private MyWindow window;

    Reader(Socket socket, MyWindow window) throws IOException{
        super();
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.window = window;
        start();
    }

    @Override
    public void run() {
        String str = "";
        while (isAlive) {
            System.out.println("QQ");
            try {
                str = bufferedReader.readLine();
                System.out.println("Readed:    " + str);
                calculateMessage(str);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
            } catch (IOException exc) {
                System.err.println("Cant read message");
                isAlive = false;
            }
        }
    }

    private void calculateMessage(String message){
        try{
            JSONObject jsonObject = new JSONObject(message);
            System.out.println(jsonObject.getString("Message"));
            String newDialog = jsonObject.getString("Date") + "/" + jsonObject.getString("Name") + "/" + jsonObject.getString("Message")
                    + "\n" + window.getMainWindow().getMessageWindow().getDialog().getText();
            Platform.runLater(() ->  window.getMainWindow().getMessageWindow().getDialog().setText(newDialog));
        } catch (JSONException exc) {
        }
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }
}

