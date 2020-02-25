package practicumopdracht.views;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import practicumopdracht.models.Contact;


public class ContactView {
    private TextField naamInvoerVeld;
    private DatePicker geboortedatumVeld;
    private TextField emailInvoerVeld;
    private TextField straatInvoerVeld;
    private TextField huisnummerInvoerVeld;
    private TextField postcodeInvoerVeld;
    private TextField woonplaatsInvoerVeld;
    private TextField telefoonnummerInvoerVeld;
    private TextField ratingVeld;
    private CheckBox emergencyContactenVeld;
    private ListView<Contact> contactLijst;

    private GridPane view;

    public ContactView() {
        this.naamInvoerVeld = new TextField();
        this.geboortedatumVeld = new DatePicker();
        this.emailInvoerVeld = new TextField();
        this.straatInvoerVeld = new TextField();
        this.huisnummerInvoerVeld = new TextField();
        this.postcodeInvoerVeld = new TextField();
        this.woonplaatsInvoerVeld = new TextField();
        this.telefoonnummerInvoerVeld = new TextField();
        this.ratingVeld = new TextField();
        this.emergencyContactenVeld = new CheckBox();
        this.contactLijst = new ListView<>();
        initLayout();
    }

    public void initLayout() {
        Label naamLabel = new Label("Naam:");
        Label geboortedatumLabel = new Label("Geboortedatum:");
        Label emailLabel = new Label("Email:");
        Label straatLabel = new Label("Straat:");
        Label huisnmmerLabel = new Label("Huisnummer:");
        Label postcodeLabel = new Label("Postcode:");
        Label woonplaatsLabel = new Label("Woonplaats:");
        Label telefoonnummerLabel = new Label("Telefoonnummer:");
        Label ratingLabel = new Label("Rating");
        Label emergencyContactenLabel = new Label("Als emergency contact?");
        Label contactLijstLabel = new Label("Contact Lijst:");

        naamInvoerVeld = new TextField();
        geboortedatumVeld = new DatePicker();
        emailInvoerVeld = new TextField();
        straatInvoerVeld = new TextField();
        huisnummerInvoerVeld = new TextField();
        postcodeInvoerVeld = new TextField();
        woonplaatsInvoerVeld = new TextField();
        telefoonnummerInvoerVeld = new TextField();
        ratingVeld =  new TextField();
        emergencyContactenVeld = new CheckBox();
        contactLijst = new ListView<>();

        view = new GridPane();
        view.setHgap(10);
        view.setVgap(10);
        view.setPadding(new Insets(10, 10, 10, 10));
        view.setAlignment(Pos.TOP_CENTER);

        view.add(naamLabel, 0, 0);
        view.add(naamInvoerVeld, 1,0);
        view.add(geboortedatumLabel, 0,1);
        view.add(geboortedatumVeld, 1,1);
        view.add(emailLabel,0,2);
        view.add(emailInvoerVeld,1,2);
        view.add(straatLabel,0,3);
        view.add(straatInvoerVeld,1,3);
        view.add(huisnmmerLabel,0,4);
        view.add(huisnummerInvoerVeld,1,4);
        view.add(postcodeLabel,0,5);
        view.add(postcodeInvoerVeld,1,5);
        view.add(woonplaatsLabel,0,6);
        view.add(woonplaatsInvoerVeld,1,6);
        view.add(telefoonnummerLabel,0,7);
        view.add(telefoonnummerInvoerVeld,1,7);
        view.add(ratingLabel, 0, 8);
        view.add(ratingVeld,1,8);
        view.add(emergencyContactenLabel, 0,9 );
        view.add(emergencyContactenVeld, 1, 9);
//
//        HBox hbButtons = new HBox();
//        hbButtons.setSpacing(5);
//        hbButtons.setPadding(new Insets(0,20,10,30));

        Button btOpslaan = new Button("Opslaan");
        btOpslaan.setMaxWidth(Double.MAX_VALUE);

        view.add(btOpslaan,0,10, 10,5);
        view.setFillWidth(btOpslaan, true);

        view.add(contactLijstLabel, 0,15);
        view.add(contactLijst,0,16,10, 5);
    }

    public Parent getRoot(){
        return view;
    }
}
