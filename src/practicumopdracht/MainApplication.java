package practicumopdracht;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import practicumopdracht.views.ContactView;
import practicumopdracht.views.GroepView;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Adresboek - Rona Rae de Romas Rieza");
        ContactView contactView = new ContactView();
        GroepView groepView = new GroepView();

        Scene mainScene = new Scene(
//                contactView.getRoot(),
//                500,
//                600
                groepView.getRoot(),
                300,
                200
        );

        stage.setScene(mainScene);
        stage.show();

    }
}
