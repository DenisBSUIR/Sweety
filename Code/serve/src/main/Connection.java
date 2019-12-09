package main;

import java.io.IOException;
import java.net.Socket;

public class Connection extends Thread {

    private Socket socket;
    private boolean isAlive = true;
    private Writer writer;
    private Reader reader;
    private MessageSender sender;

    Connection(Socket socket, Dialog dialog){
        super();
        this.socket = socket;
        writer = new Writer(socket);
        reader = new Reader(socket, dialog);
        sendHistory(dialog);
        start();
    }

    public void addWriterToSender(MessageSender messageSender) {
        sender = messageSender;
        messageSender.addWriter(writer);
        reader.setMessageSender(messageSender);
    }

    @Override
    public void run(){
        while (isAlive){
            if(socket.isClosed()){
                try{
                    reader.getBufferedReader().close();
                    writer.getBufferedWriter().close();
                    sender.deleteWriter(writer);
                } catch (IOException e) {
                    System.err.println("BufferedStreams closings error");
                }
            }

        }
    }

    private void sendHistory(Dialog dialog){
        for(String message: dialog.getDialog()){
            writer.sendMessage(message);
        }
    }
}
