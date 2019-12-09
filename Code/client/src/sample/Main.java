package sample;

import View.MyWindow;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        MyWindow window = new MyWindow(primaryStage);
        window.setStartWindow();
        Client client = new Client(window);
        client.start();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
