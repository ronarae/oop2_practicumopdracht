package practicumopdracht.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import practicumopdracht.data.FakeGroepDAO;
import practicumopdracht.models.Groep;
import practicumopdracht.views.GroepView;
import practicumopdracht.views.View;


public class GroepController extends Controller {

    private GroepView groepView;

    private FakeGroepDAO groepDAO;

    public GroepController() {
        groepView = new GroepView();
        groepView.getBtNieuw().setOnAction(actionEvent -> pressedNieuw());
        groepView.getBtOpslaan().setOnAction(actionEvent -> pressedOpslaan());
//        groepView.getBtTerug().setOnAction(actionEvent -> pressedTerug());
        groepView.getBtVerwijderen().setOnAction(actionEvent -> pressedVerwijderen());

        groepDAO = new FakeGroepDAO();
        refreshData();
        //pressedItem();
    }

    public void refreshData() {
        ObservableList<Groep> groepList = FXCollections.observableList(groepDAO.getAll());
        groepView.getGroepListView().setItems(groepList);
    }

    public void pressedNieuw() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Je hebt op de nieuw button geklikt");
        alert.showAndWait();

    }

    public void pressedOpslaan() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("De volgende zijn de fouten");
        if (groepView.getGroepNaamInvoerVeld().getText().isEmpty() ||
                groepView.getGroepNaamInvoerVeld().getText().trim().isEmpty() &&
                groepView.getDatumToegevoegdInvoerVeld().getValue() == null)
        {
            alert.setContentText("Je hebt niet alles ingevuld! \n" +
                    "- Naam van de groep is verplicht! \n" +
                    "- Datum is verplicht of ongeldig" );

        } else if (groepView.getGroepNaamInvoerVeld().getText().isEmpty() ||
                groepView.getDatumToegevoegdInvoerVeld().getValue() == null){
            alert.setContentText("Je hebt niet alles ingevuld!");

        } else {
            alert.setHeaderText("Je hebt het opgeslagen !");

            Groep newGroep = new Groep(groepView.getGroepNaamInvoerVeld().getText(),
                    groepView.getDatumToegevoegdInvoerVeld().getValue());

            groepView.getGroepNaamInvoerVeld().clear();
            groepView.getDatumToegevoegdInvoerVeld().setValue(null);

            groepDAO.addOrUpdate(newGroep);
            refreshData();





        }
        alert.show();
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

