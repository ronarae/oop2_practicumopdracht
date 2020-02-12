package practicumopdracht;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import practicumopdracht.views.ContactView;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Adresboek - Rona Rae de Romas Rieza");
        ContactView contactView = new ContactView();

        Scene mainScene = new Scene(
                contactView.getView(),
                600,
                500
        );

        stage.setScene(mainScene);
        stage.show();

    }
}
