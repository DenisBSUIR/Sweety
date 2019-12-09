package View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class StartWindow {

    public Button enter = new Button("Enter");
    public Button registration = new Button("Registration");

    public StartWindow() {
        enter.setMaxSize(400,50);
        enter.setMinSize(400,50);

        registration.setMinSize(400,50);
        registration.setMaxSize(400,50);
    }

    public void setWindow( GridPane pane) {
        pane.setPadding(new Insets(200));
        pane.add(enter,0,0);
        pane.add(registration,0,1);
    }

    public Button getEnter() {
        return enter;
    }

    public Button getRegistration() {
        return registration;
    }

    public void setEnter(Button enter) {
        this.enter = enter;
    }

    public void setRegistration(Button registration) {
        this.registration = registration;
    }
}
