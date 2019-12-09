package sample;

import java.io.*;
import java.net.Socket;

public class Writer {
    private BufferedWriter bufferedWriter;

   Writer(Socket socket) throws IOException{
       super();
       bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
   }

   public void sendMessage(String str){
       try {
        bufferedWriter.write(str+ "\n");
        bufferedWriter.flush();
       } catch (IOException exc) {
           System.err.println("Message sending exception");
           try{
               bufferedWriter.close();
           } catch (IOException e) {}
       }
   }
}
