package practicumopdracht;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import practicumopdracht.controllers.Controller;
import practicumopdracht.controllers.GroepController;
import practicumopdracht.data.ContactDAO;
import practicumopdracht.data.GroepDAO;

public class MainApplication extends Application {

    private final String TITLE = "Adresboek - Rona Rae de Romas Rieza";
    private final int WIDTH = 695;
    private final int HEIGHT = 850;
    public static Stage stage;
    public static GroepDAO groepDAO;
    public static ContactDAO contactDAO;

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


    public static GroepDAO getGroepDAO() {
        return groepDAO;
    }

    public static ContactDAO getContactDAO() {
        return contactDAO;
    }
}
