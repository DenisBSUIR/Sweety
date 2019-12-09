package main;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Reader extends Thread {

    private BufferedReader bufferedReader;
    private boolean isAlive = true;
    private Dialog dialog;
    private MessageSender messageSender;

    public Reader(Socket socket, Dialog dialog) {
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException exc) {
            System.err.println("Reader creation error");
        }
        this.dialog = dialog;

        start();
    }

    @Override
    public void run(){
        String str = "";
        while (isAlive) {
            try {
                str = bufferedReader.readLine();
                System.out.println("Readed:    " + str);
                calculateMessage(str);
            } catch (IOException exc) {
                System.err.println("Cant read message");
                isAlive = false;
            }

        }
    }


    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public void setBufferedReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public void setMessageSender(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    private void calculateMessage(String message) {
        if(message == "") {
            System.out.println("AA");
        }
        dialog.addMessageToDialog(message);
        try{
            JSONObject jsonMessage = new JSONObject(message);
            messageSender.sendMessageToAll(jsonMessage.toString());
        } catch (JSONException exc) {
            System.err.println("JSON parsing exception");
        }
    }
}
