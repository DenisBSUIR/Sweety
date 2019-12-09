package View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class ApplicationWindow {
    private ToggleButton profileButton = new ToggleButton("Profile");
    private ToggleButton contactsButton = new ToggleButton("Contacts");
    private ToggleButton messagesButton = new ToggleButton("Messages");
    private ToggleButton settingsButton = new ToggleButton("Settings");
    private ToggleGroup toggleGroup = new ToggleGroup();
    private MessageWindow messageWindow = new MessageWindow();


    //private GridPane root;

    public ApplicationWindow() {
        super();

        profileButton.setMinSize(190, 40);
        profileButton.setMaxSize(190, 40);

        contactsButton.setMinSize(190, 40);
        contactsButton.setMaxSize(190, 40);

        messagesButton.setMinSize(190, 40);
        messagesButton.setMaxSize(190, 40);

        settingsButton.setMinSize(190, 40);
        settingsButton.setMaxSize(190, 40);

        profileButton.setToggleGroup(toggleGroup);
        contactsButton.setToggleGroup(toggleGroup);
        messagesButton.setToggleGroup(toggleGroup);
        settingsButton.setToggleGroup(toggleGroup);
    }

    public void setWindow(GridPane root) {
        root.setPadding(new Insets(20));
        root.setVgap(20);
        root.setHgap(0);
        root.add(profileButton, 0, 0);
        root.add(contactsButton, 1, 0);
        root.add(messagesButton, 2, 0);
        root.add(settingsButton, 3, 0);
    }

    public ToggleButton getProfileButton() {
        return profileButton;
    }

    public void setProfileButton(ToggleButton profileButton) {
        this.profileButton = profileButton;
    }

    public ToggleButton getContactsButton() {
        return contactsButton;
    }

    public void setContactsButton(ToggleButton contactsButton) {
        this.contactsButton = contactsButton;
    }

    public ToggleButton getMessagesButton() {
        return messagesButton;
    }

    public void setMessagesButton(ToggleButton messagesButton) {
        this.messagesButton = messagesButton;
    }

    public ToggleButton getSettingsButton() {
        return settingsButton;
    }

    public void setSettingsButton(ToggleButton settingsButton) {
        this.settingsButton = settingsButton;
    }

    public MessageWindow getMessageWindow() {
        return messageWindow;
    }

    public void setMessageWindow(MessageWindow messageWindow) {
        this.messageWindow = messageWindow;
    }
}
