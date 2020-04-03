package practicumopdracht.controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import practicumopdracht.data.FakeContactDAO;
import practicumopdracht.models.Contact;
import practicumopdracht.models.Groep;
import practicumopdracht.views.ContactView;
import practicumopdracht.views.View;

public class ContactController  extends Controller {

    private ContactView contactView;

    private FakeContactDAO contactDAO;

    public ContactController() {
        contactView = new ContactView();
        contactView.getBtNieuw().setOnAction(actionEvent -> pressedNieuw());
        contactView.getBtOpslaan().setOnAction(actionEvent -> pressedOpslaan());
//        groepView.getBtTerug().setOnAction(actionEvent -> pressedTerug());
        contactView.getBtVerwijderen().setOnAction(actionEvent -> pressedVerwijderen());

        contactDAO = new FakeContactDAO();
        refreshData();
    }

    public void refreshData() {
        ObservableList<Contact> contactLijst = FXCollections.observableList(contactDAO.getAll());
        contactView.getContactLijst().setItems(contactLijst);
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
        if (contactView.getNaamInvoerVeld().getText().isEmpty() ||
                contactView.getGeboortedatumVeld().getValue() == null ||
                contactView.getEmailInvoerVeld().getText().isEmpty() ||
                contactView.getGroepNaamInvoerVeld().getItems().isEmpty()) {
            alert.setContentText("Je hebt niet alles ingevuld! \n" +
                    "- Naam van de groep is verplicht! \n" +
                    "- Datum is verplicht of ongeldig \n" +
                    "- Naam is verplict \n" +
                    "- Email is verplict");

        } else if (contactView.getNaamInvoerVeld().getText().isEmpty() ||
                contactView.getGeboortedatumVeld().getValue() == null ||
                contactView.getEmailInvoerVeld().getText().isEmpty() ||
                contactView.getGroepNaamInvoerVeld().getItems().isEmpty()) {
            alert.setContentText("Je hebt niet alles ingevuld!");;

    } else {
        alert.setHeaderText("Je hebt het opgeslagen !");

        Contact newContact = new Contact(contactView.getNaamInvoerVeld().getText(),
                contactView.getEmailInvoerVeld().getText(),
                contactView.getGeboortedatumVeld().getValue());
        alert.setContentText("Deze gegevens zijn succesvol opgesalgen: \n " + newContact);

            contactView.getNaamInvoerVeld().clear();
            contactView.getEmailInvoerVeld().clear();
            contactView.getGeboortedatumVeld().setValue(null);

            contactDAO.addOrUpdate(newContact);
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
        return contactView  ;
    }
}
