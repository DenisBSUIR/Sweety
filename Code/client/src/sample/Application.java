package sample;

import View.MyWindow;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Application extends Thread {

    private Reader reader;
    private Writer writer;
    private MyWindow window;
    private User user = new User();



    public MyWindow getWindow() {
        return window;
    }

    public void setWindow(MyWindow window) {
        this.window = window;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    @Override
    public void run(){
        setActionListeners();
    }

    private void setActionListeners() {
        window.getStartWindow().getEnter().setOnAction(event -> {
            window.getMainGridPane().getChildren().removeAll(window.getStartWindow().getEnter(),window.getStartWindow().getRegistration());
            window.getEnterWindow().setWindow(window.getMainGridPane());
        });

        window.getEnterWindow().getEnterButton().setOnAction(event -> {
            window.getMainGridPane().getChildren().removeAll(window.getEnterWindow().getBackButton(),
                    window.getEnterWindow().getEnterButton(),
                    window.getEnterWindow().getLoginTextField(),
                    window.getEnterWindow().getPasswordField());
            window.getMainWindow().setWindow(window.getMainGridPane());
            window.getMainWindow().getMessageWindow().setWindow(window.getMainGridPane());
            user.setUserName(window.getEnterWindow().getLoginTextField().getText());
        });

        window.getMainWindow().getMessageWindow().getSendButton().setOnAction(event -> {
            JSONObject message = new JSONObject();
            try {
                message.put("Message", window.getMainWindow().getMessageWindow().getTextArea().getText());
                Date date = new Date();
                message.put("Date", date);
                message.put("Name", user.getUserName());
            } catch (JSONException exc) {
                System.err.println("JSON writing error");
            }
            writer.sendMessage(message.toString());
        });

        window.getStage().setOnCloseRequest(event -> {
            System.exit(0);
        });
    }
}
