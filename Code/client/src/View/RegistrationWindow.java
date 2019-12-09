package View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class RegistrationWindow {
    private Button registrationButton;
    private Button backButton;
    private TextField loginTextField;
    private PasswordField passwordField;

    public RegistrationWindow() {
        super();
        registrationButton = new Button("Register");
        registrationButton.setMaxSize(90,50);
        registrationButton.setMinSize(90,50);

        backButton = new Button("Back");
        backButton.setMinSize(90,50);
        backButton.setMaxSize(90,50);

        loginTextField = new TextField("Login");
        loginTextField.setMaxSize(200,50);
        loginTextField.setMinSize(200,50);

        passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setMaxSize(200,50);
        passwordField.setMinSize(200,50);
    }

    public void setWindow(GridPane pane) {
        pane.setAlignment(Pos.CENTER);
        pane.add(loginTextField,0,0,2,1);
        pane.add(passwordField,0,1,2,1);
        pane.add(registrationButton,0,2);
        pane.add(backButton,1,2);

        setActionListeners(pane);
    }

    private void setActionListeners(GridPane pane) {
        registrationButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               // enterWindow.setWindow(pane);
            }
        });

        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //registrationWindow.setWindow(pane);
            }
        });
    }
}
