package practicumopdracht.views;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import practicumopdracht.MainApplication;
import practicumopdracht.controllers.ContactController;
import practicumopdracht.controllers.GroepController;
import practicumopdracht.models.Contact;

public class ContactView extends View {
    private ComboBox groepNaamInvoerVeld;
    private TextField naamInvoerVeld;
    private DatePicker geboortedatumVeld;
    private TextField emailInvoerVeld;
    private TextField straatInvoerVeld;
    private TextField huisnummerInvoerVeld;
    private TextField postcodeInvoerVeld;
    private TextArea woonplaatsInvoerVeld;
    private TextField ratingVeld;
    private CheckBox emergencyContactenVeld;
    private ListView<Contact> contactLijst;
    private Button btOpslaan;
    private Button btNieuw;
    private Button btVerwijderen;
    private Button btTerug;

    private BorderPane border;

    private MenuItem sortNameAsc;
    private MenuItem sortNameDesc;
    private Menu soort;


    private GridPane view;

    public ContactView() {
        groepNaamInvoerVeld = new ComboBox();
        naamInvoerVeld = new TextField();
        geboortedatumVeld = new DatePicker();
        emailInvoerVeld = new TextField();
        straatInvoerVeld = new TextField();
        huisnummerInvoerVeld = new TextField();
        postcodeInvoerVeld = new TextField();
        woonplaatsInvoerVeld = new TextArea();
        ratingVeld = new TextField();
        emergencyContactenVeld = new CheckBox();
        contactLijst = new ListView<>();
        btOpslaan = new Button("Opslaan");
        btNieuw = new Button("Nieuw");
        btTerug = new Button("Terug naar het overzicht");
        btVerwijderen = new Button("Verwijderen");
        initLayout();
    }

    public void initLayout() {
        Label groepNaamLabel = new Label("Groepnaam: *");
        Label naamLabel = new Label("Naam: *");
        Label geboortedatumLabel = new Label("Geboortedatum: *");
        Label emailLabel = new Label("Email: *");
        Label straatLabel = new Label("Straat:");
        Label huisnmmerLabel = new Label("Huisnummer:");
        Label postcodeLabel = new Label("Postcode:");
        Label woonplaatsLabel = new Label("Woonplaats:");
        Label ratingLabel = new Label("Rating");
        Label emergencyContactenLabel = new Label("Als emergency contact?");
        Label contactLijstLabel = new Label("Contact Lijst:");

        Label textLabel = new Label("Alle * zijn verplicte velden! ");

        view = new GridPane();
        view.setHgap(10);
        view.setVgap(10);
        view.setPadding(new Insets(10));

        view.add(groepNaamLabel, 0,0);
        view.add(groepNaamInvoerVeld, 1, 0);
        groepNaamInvoerVeld.getItems().add("Familie");
        groepNaamInvoerVeld.getItems().add("Vrienden");
        groepNaamInvoerVeld.getItems().add("School");
        groepNaamInvoerVeld.getItems().add("Werk");
        groepNaamInvoerVeld.setMaxWidth(Double.MAX_VALUE);

        view.add(naamLabel, 0, 1);
        view.add(naamInvoerVeld, 1,1);

        view.add(geboortedatumLabel, 0,2);
        view.add(geboortedatumVeld, 1,2);
        geboortedatumVeld.setMaxWidth(Double.MAX_VALUE);

        view.add(emailLabel,0,3);
        view.add(emailInvoerVeld,1,3);

        view.add(straatLabel,0,4);
        view.add(straatInvoerVeld,1,4);

        view.add(huisnmmerLabel,0,5);
        view.add(huisnummerInvoerVeld,1,5);

        view.add(postcodeLabel,0,6);
        view.add(postcodeInvoerVeld,1,6);

        view.add(woonplaatsLabel,0,7);
        view.add(woonplaatsInvoerVeld,1,7);
        woonplaatsInvoerVeld.setPrefHeight(50);

        view.add(ratingLabel, 0, 9);
        view.add(ratingVeld,1,9);

        view.add(emergencyContactenLabel, 0,10);
        view.add(emergencyContactenVeld, 1, 10);

        view.add(textLabel, 0 , 11);
        //VBOX
        VBox vbButtons = new VBox(btOpslaan,contactLijstLabel,contactLijst);
        vbButtons.setSpacing(10);
        view.getChildren().add(vbButtons);
        btOpslaan.setMaxWidth(Double.MAX_VALUE);
        view.add(btOpslaan,0,12,2,1);
        view.add(contactLijstLabel, 0,13);
        view.add(contactLijst,0,14,2,1);
        contactLijst.setPrefHeight(100);

        //HBOX
        HBox hbButtons = new HBox(btNieuw, btVerwijderen, btTerug);
        hbButtons.setSpacing(10);
        view.getChildren().add(hbButtons);
        view.add(btNieuw,0,15,2,1);
        btNieuw.setMaxWidth(Double.MAX_VALUE);
        view.add(btVerwijderen,0,16,2,1);
        btVerwijderen.setMaxWidth(Double.MAX_VALUE);

        view.add(btTerug,0,17,2,1);
        btTerug.setMaxWidth(Double.MAX_VALUE);
        btTerug.setOnAction(actionEvent -> MainApplication.switchController(new GroepController()));


        soort = new Menu("Sorteren");

        sortNameAsc = new MenuItem("Naam, oplopend");
        sortNameDesc = new MenuItem("Naam, aflopend");

        soort.getItems().addAll(sortNameAsc, sortNameDesc, new SeparatorMenuItem());

        MenuBar menuBar = new MenuBar(soort);

        border.setTop(menuBar);
        border.setCenter(view);

    }
    //getters for the buttons
    public Button getBtOpslaan() {
        return btOpslaan;
    }

    public Button getBtNieuw() {
        return btNieuw;
    }

    public Button getBtVerwijderen() {
        return btVerwijderen;
    }

    public Button getBtTerug() {
        return btTerug;
    }

    //getters for the verplicte velden

    public ComboBox getGroepNaamInvoerVeld() {
        return groepNaamInvoerVeld;
    }

    public TextField getNaamInvoerVeld() {
        return naamInvoerVeld;
    }

    public DatePicker getGeboortedatumVeld() {
        return geboortedatumVeld;
    }

    public TextField getEmailInvoerVeld() {
        return emailInvoerVeld;
    }

    public ListView<Contact> getContactLijst() {
        return contactLijst;
    }

    public MenuItem getSortNameAsc() {
        return sortNameAsc;
    }

    public MenuItem getSortNameDesc() {
        return sortNameDesc;
    }

    public Menu getSoort() {
        return soort;
    }

    public Parent getRoot(){
        return border;
    }
}
