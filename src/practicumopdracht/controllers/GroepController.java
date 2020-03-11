package practicumopdracht.controllers;

import javafx.scene.control.Alert;
import practicumopdracht.views.ContactView;
import practicumopdracht.views.GroepView;
import practicumopdracht.views.View;

public class GroepController extends Controller {

    private GroepView groepView;

    public GroepController() {
        groepView = new GroepView();
        groepView.getBtNieuw().setOnAction(actionEvent -> pressedNieuw());
        groepView.getBtOpslaan().setOnAction(actionEvent -> pressedOpslaan());
//        groepView.getBtTerug().setOnAction(actionEvent -> pressedTerug());
        groepView.getBtVerwijderen().setOnAction(actionEvent -> pressedVerwijderen());
    }

    public void pressedNieuw() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Je hebt op de nieuw button geklikt");
        alert.showAndWait();

    }

    public void pressedOpslaan() {
        if (groepView.getGroepNaamInvoerVeld().getText().isEmpty() &&
                groepView.getDatumToegevoegdInvoerVeld().getValue() == null){
            Alert missingValueAlert = new Alert(Alert.AlertType.ERROR);
            missingValueAlert.setContentText("Je hebt niet alles ingevuld!");
            missingValueAlert.show();
        } else if (groepView.getGroepNaamInvoerVeld().getText().isEmpty() ||
                groepView.getDatumToegevoegdInvoerVeld().getValue() == null){
            Alert missingValueAlert = new Alert(Alert.AlertType.ERROR);
            missingValueAlert.setContentText("Je hebt niet alles ingevuld!");
            missingValueAlert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Je hebt alles ingevuld");
            alert.showAndWait();
        }
    }

//    public void pressedTerug() { // volgendebutton
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Information Dialog");
//        alert.setHeaderText(null);
//        alert.setContentText("Je hebt op de terug button geklikt");
//        alert.showAndWait();
//    }

    public void pressedVerwijderen() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Je hebt op de volgende button geklikt");
        alert.showAndWait();
    }

    @Override
    public View getView() {
        return groepView;
    }
}

