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
import java.util.Optional;


public class GroepController extends Controller {

    private GroepView groepView;
    private Alert alert;

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


    public void pressedVerwijderen(){
        Groep selectedItem = groepView.getGroepListView().getSelectionModel().getSelectedItem();

        if (selectedItem == null) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Verwijderen");
            alert.setContentText("Je hebt geen item geselecteerd om te verwijderen!");
            alert.show();
        } else {
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Verwijderen");
            alert.setHeaderText("Je hebt op de verwijder-knop gedrukt!");
            alert.setContentText("Weet je zeker dat je deze item wilt verwijderen?");
            Optional<ButtonType> resultverwijderen = alert.showAndWait();

            if (resultverwijderen.get() == ButtonType.OK) {
                groepDAO.remove(selectedItem);
                refreshData();
                refreshFields();
            }
        }
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
        MainApplication.getGroepDAO().save();
        Alert saveAlert = new Alert(Alert.AlertType.INFORMATION);
        saveAlert.setTitle("Succes");
        saveAlert.setHeaderText("Het opslaan was succesvol!");
        saveAlert.showAndWait();
    }

    public void refreshFields() {
        groepView.getGroepNaamInvoerVeld().clear();
        groepView.getDatumToegevoegdInvoerVeld().setValue(null);
    }

    public void afsluiten() {
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Laden");
        alert.setHeaderText("Je hebt op de sluit-knop gedrukt!");
        alert.setContentText("Weet je zeker dat je de applicatie wilt sluiten?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Opslaan");
            alert.setHeaderText("Sla je gegevens op anders gaan ze verloren!");
            alert.setContentText("Wil je je gegevens opslaan?");

            saveData();
            alert.show();
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

