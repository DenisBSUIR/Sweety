package View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.*;


public class EnterWindow {

    private Button enterButton;
    private Button backButton;
    private TextField loginTextField;
    private PasswordField passwordField;

    public EnterWindow() {
        super();
        enterButton = new Button("Enter");
        enterButton.setMaxSize(140,50);
        enterButton.setMinSize(140,50);


        backButton = new Button("Back");
        backButton.setMinSize(140,50);
        backButton.setMaxSize(140,50);

        loginTextField = new TextField();
        loginTextField.setPromptText("Login");
        loginTextField.setMaxSize(400,50);
        loginTextField.setMinSize(400,50);

        passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setMaxSize(400,50);
        passwordField.setMinSize(400,50);
    }

    public void setWindow(GridPane pane) {
        pane.setHgap(120);
        pane.add(loginTextField, 0,0,2,1);
        pane.add(passwordField,0,1,2,1);
        pane.add(enterButton,0,2);
        pane.add(backButton,1,2);
    }

    public Button getEnterButton() {
        return enterButton;
    }

    public void setEnterButton(Button enterButton) {
        this.enterButton = enterButton;
    }

    public Button getBackButton() {
        return backButton;
    }

    public void setBackButton(Button backButton) {
        this.backButton = backButton;
    }

    public TextField getLoginTextField() {
        return loginTextField;
    }

    public void setLoginTextField(TextField loginTextField) {
        this.loginTextField = loginTextField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(PasswordField passwordField) {
        this.passwordField = passwordField;
    }
}
