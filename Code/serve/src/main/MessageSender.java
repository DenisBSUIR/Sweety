package main;

import java.io.BufferedWriter;
import java.util.LinkedList;

public class MessageSender {

    private LinkedList<Writer> writersList = new LinkedList<>();

    public void addWriter(Writer writer) {
        writersList.add(writer);
    }

    public void deleteWriter(Writer writer){
        writersList.remove(writer);
    }

    public void sendMessageToAll(String message) {
        for (Writer br: writersList) {
            br.sendMessage(message);
        }
    }
}
