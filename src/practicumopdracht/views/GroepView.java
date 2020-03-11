package practicumopdracht.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import practicumopdracht.MainApplication;
import practicumopdracht.controllers.ContactController;
import practicumopdracht.models.Contact;

public class GroepView extends View{
    private TextField groepNaamInvoerVeld;
    private DatePicker datumToegevoegdInvoerVeld;
    private ListView<Contact> contactLijst;
    private Button btOpslaan;
    private Button btNieuw;
    private Button btVerwijderen;
    private Button btTerug;

    private GridPane view;

    public GroepView() {
        groepNaamInvoerVeld = new TextField();
        datumToegevoegdInvoerVeld = new DatePicker();
        btOpslaan = new Button("Opslaan");
        contactLijst = new ListView<>();
        btNieuw = new Button("Nieuw");
        btTerug = new Button("Volgende");
        btVerwijderen = new Button("Verwijderen");


        initLayout();
    }

    public void initLayout() {
        Label groepNaamLabel = new Label("Groepnaam:");
        Label datumLabel = new Label("Datum Toegevoegd:");
        Label contactLijstLabel = new Label("Contact Lijst:");

        groepNaamInvoerVeld = new TextField();
        datumToegevoegdInvoerVeld = new DatePicker();

        view = new GridPane();
        view.setHgap(5);
        view.setVgap(5);
        view.setAlignment(Pos.BASELINE_CENTER);
        view.setPadding(new Insets(150, 10, 10, 10));

        view.add(groepNaamLabel, 0, 0);
        view.add(groepNaamInvoerVeld, 1, 0);
        view.add(datumLabel,0,1);
        view.add(datumToegevoegdInvoerVeld, 1,1);

        view.add(btOpslaan, 0,3,3,1);
        btOpslaan.setMaxWidth(Double.MAX_VALUE);
        //schakel button naar de andere pagina
        btTerug.setOnAction(actionEvent -> MainApplication.switchController(new ContactController()));

        view.add(contactLijstLabel, 0,10);
        view.add(contactLijst,0,11,2,1);
        contactLijst.setPrefHeight(150);

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
    }

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

    public TextField getGroepNaamInvoerVeld() {
        return groepNaamInvoerVeld;
    }

    public DatePicker getDatumToegevoegdInvoerVeld() {
        return datumToegevoegdInvoerVeld;
    }

    @Override
    public Parent getRoot() {
        return view;
    }
}
