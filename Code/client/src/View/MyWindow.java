package View;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MyWindow {

    private EnterWindow enterWindow = new EnterWindow();
    private RegistrationWindow registrationWindow = new RegistrationWindow();
    private ApplicationWindow mainWindow = new ApplicationWindow();
    private StartWindow startWindow = new StartWindow();
    private Scene scene;
    private Stage stage;

    private GridPane mainGridPane = new GridPane();

    public MyWindow(Stage stage) {

        scene = new Scene(mainGridPane,800,600);
        stage.setTitle("Sweety");
        stage.setScene(scene);
        this.stage = stage;
        stage.show();
    }

    public void setStartWindow() {
        mainGridPane.setPadding(new Insets(100));
        mainGridPane.setVgap(50);
        startWindow.setWindow(mainGridPane);
    }

    public Stage getStage() {
        return stage;
    }

    public EnterWindow getEnterWindow() {
        return enterWindow;
    }

    public void setEnterWindow(EnterWindow enterWindow) {
        this.enterWindow = enterWindow;
    }

    public RegistrationWindow getRegistrationWindow() {
        return registrationWindow;
    }

    public void setRegistrationWindow(RegistrationWindow registrationWindow) {
        this.registrationWindow = registrationWindow;
    }

    public ApplicationWindow getMainWindow() {
        return mainWindow;
    }

    public void setMainWindow(ApplicationWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    public StartWindow getStartWindow() {
        return startWindow;
    }

    public void setStartWindow(StartWindow startWindow) {
        this.startWindow = startWindow;
    }

    public GridPane getMainGridPane() {
        return mainGridPane;
    }

    public void setMainGridPane(GridPane mainGridPane) {
        this.mainGridPane = mainGridPane;
    }
}
