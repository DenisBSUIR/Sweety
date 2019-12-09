package View;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class MessageWindow {
    private ScrollPane scrollPane = new ScrollPane();
    private TextArea textArea = new TextArea();
    private Button sendButton = new Button("Send");
    private Label dialog = new Label();
    private GridPane sendingStuff = new GridPane();

    public MessageWindow() {
        super();
        scrollPane.setMaxSize(760, 370);
        scrollPane.setMinSize(760, 370);
        scrollPane.setContent(dialog);

        sendButton.setMaxSize(100,100);
        sendButton.setMinSize(100,100);

        textArea.setMaxSize(650,100);
        textArea.setMinSize(650,100);

        sendingStuff.setHgap(10);
        sendingStuff.add(textArea,0,0);
        sendingStuff.add(sendButton,1,0);
    }

    public void setWindow(GridPane root) {
        root.add(scrollPane, 0, 1, 4, 1);
        root.add(sendingStuff,0,2,4,1);
    }

    public TextArea getTextArea() {
        return textArea;
    }

    public Button getSendButton() {
        return sendButton;
    }

    public Label getDialog() {
        return dialog;
    }

}
