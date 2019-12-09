package main;

import java.io.*;
import java.net.Socket;

public class Writer {

    private BufferedWriter bufferedWriter;

    public Writer(Socket socket) {
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException exc) {
            System.err.println("Writer creation error");
        }
    }

    public void sendMessage(String str) {
        try {
            bufferedWriter.write(str + "\n");
            bufferedWriter.flush();
        } catch (IOException exc) {
            System.err.println("Message sending exception");
            try {
                bufferedWriter.close();
            } catch (IOException exce) {}
        }
    }

    public BufferedWriter getBufferedWriter() {
        return bufferedWriter;
    }

    public void setBufferedWriter(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }
}
