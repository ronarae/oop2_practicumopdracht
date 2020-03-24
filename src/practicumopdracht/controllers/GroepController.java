package practicumopdracht.controllers;

import javafx.scene.control.Alert;
import practicumopdracht.models.Groep;
import practicumopdracht.views.ContactView;
import practicumopdracht.views.GroepView;
import practicumopdracht.views.View;

import java.util.Date;

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
        Alert error = new Alert(Alert.AlertType.ERROR);
        error.setTitle("Information Dialog");
        error.setHeaderText("De volgende zijn de fouten");
        if (groepView.getGroepNaamInvoerVeld().getText().isEmpty() ||
                groepView.getGroepNaamInvoerVeld().getText().trim().isEmpty() &&
                groepView.getDatumToegevoegdInvoerVeld().getValue() == null)
        {
            error.setContentText("Je hebt niet alles ingevuld! \n" +
                    "- Naam van de groep is verplicht! \n" +
                    "- Datum is verplicht of ongeldig" );

        } else if (groepView.getGroepNaamInvoerVeld().getText().isEmpty() ||
                groepView.getDatumToegevoegdInvoerVeld().getValue() == null){
           error.setContentText("Je hebt niet alles ingevuld!");

        } else {
            Alert noError = new Alert(Alert.AlertType.INFORMATION);
            noError.setHeaderText("Je hebt het opgeslagen !");

            Groep newGroep = new Groep(groepView.getGroepNaamInvoerVeld().getText(),
                    groepView.getDatumToegevoegdInvoerVeld().getValue());
            noError.setContentText("Deze gegevens zijn succesvol opgeslagen: \n " + newGroep);

            groepView.getGroepNaamInvoerVeld().clear();
            groepView.getDatumToegevoegdInvoerVeld().setValue(null);
        }
        error.show();
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

