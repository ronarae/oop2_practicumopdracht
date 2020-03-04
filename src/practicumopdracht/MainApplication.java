package practicumopdracht;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import practicumopdracht.controllers.Controller;
import practicumopdracht.controllers.GroepController;

public class MainApplication extends Application {

    private final String TITLE = "Adresboek - Rona Rae de Romas Rieza";
    private final int WIDTH = 850;
    private final int HEIGHT = 1000;
    public static Stage stage;

    @Override
    public void start(Stage stage) {
        this.stage = stage;

        stage.setTitle(TITLE);
        stage.setWidth(WIDTH);
        stage.setHeight(HEIGHT);

        switchController(new GroepController());

        stage.show();
    }
    public static void switchController (Controller controller) {
        stage.setScene(new Scene(controller.getView().getRoot()));
    }


}
