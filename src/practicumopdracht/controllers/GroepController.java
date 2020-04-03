package practicumopdracht.controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import practicumopdracht.MainApplication;
import practicumopdracht.comparators.GroepNameComparator;
import practicumopdracht.data.FakeGroepDAO;
import practicumopdracht.enums.Soorteren;
import practicumopdracht.models.Groep;
import practicumopdracht.views.GroepView;
import practicumopdracht.views.View;

import java.util.Comparator;


public class GroepController extends Controller {

    private GroepView groepView;

    private FakeGroepDAO groepDAO;

    public GroepController() {
        groepView = new GroepView();
        groepView.getBtNieuw().setOnAction(actionEvent -> pressedNieuw());
        groepView.getBtOpslaan().setOnAction(actionEvent -> pressedOpslaan());
        // groepView.getBtTerug().setOnAction(actionEvent -> pressedTerug());
        groepView.getBtVerwijderen().setOnAction(actionEvent -> pressedVerwijderen());

        groepView.getOpslaanMenu().setOnAction(actionEvent-> pressedOpslaanMenu());
        groepView.getOpslaanMenu().setOnAction(actionEvent-> loadData());
        groepView.getSluitenMenu().setOnAction(e -> {
            afsluiten();
        });



        groepView.getSortNameAsc().setOnAction(e -> {
            sorteer(new GroepNameComparator(Soorteren.ASCENDING));
        });

        groepView.getSortNameDesc().setOnAction(e -> {
            sorteer(new GroepNameComparator(Soorteren.DESCENDING));
        });

        groepDAO = new FakeGroepDAO();
        refreshData();
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

//    public void pressedTerug() {
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

    public void pressedOpslaanMenu() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Opslaan");
        alert.setHeaderText("Weet u zeker dat u deze gegevens op wilt slaan?");
        alert.showAndWait();
        if (alert.getResult() == ButtonType.OK) {
            saveData();
        }
    }

    private void loadData() {
        groepDAO.load();
        MainApplication.getContactDAO().load();
        refreshData();
    }

    private void saveData() {
        groepDAO.save();
        MainApplication.getContactDAO().save();
        Alert saveAlert = new Alert(Alert.AlertType.INFORMATION);
        saveAlert.setTitle("Succes");
        saveAlert.setHeaderText("Het opslaan was succesvol!");
        saveAlert.showAndWait();
    }

    public void afsluiten() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Weet u zeker ....");
        alert.setHeaderText("Weet u zeker dat u dit programma wilt sluiten");
        alert.setContentText("Klik op OK om alle gegevens op te slaan.");
        alert.showAndWait();
        if (alert.getResult() == ButtonType.OK) {
            saveData();
        }
        Platform.exit();
    }

    private void sorteer(Comparator<Groep> comparator) {
        FXCollections.sort(groepView.getGroepListView().getItems(), comparator);
    }
    @Override
    public View getView() {
        return groepView;
    }
}

