package practicumopdracht.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import practicumopdracht.MainApplication;
import practicumopdracht.controllers.ContactController;
import practicumopdracht.models.Groep;

public class GroepView extends View{
    private TextField groepNaamInvoerVeld;
    private DatePicker datumToegevoegdInvoerVeld;
    private ListView<Groep> groepListView;
    private Button btOpslaan;
    private Button btNieuw;
    private Button btVerwijderen;
    private Button btTerug;

    private BorderPane border;
    private MenuItem opslaanMenuItem;
    private MenuItem ladenMenuItem;
    private MenuItem sluitenMenuItem;
    private Menu bestandMenu;

    private GridPane view;

    public GroepView() {
        groepNaamInvoerVeld = new TextField();
        datumToegevoegdInvoerVeld = new DatePicker();
        btOpslaan = new Button("Opslaan");
        groepListView = new ListView<>();
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
        view.setPadding(new Insets(125, 10, 10, 10));

        view.add(groepNaamLabel, 0, 0);
        view.add(groepNaamInvoerVeld, 1, 0);
        view.add(datumLabel,0,1);
        view.add(datumToegevoegdInvoerVeld, 1,1);

        view.add(btOpslaan, 0,3,3,1);
        btOpslaan.setMaxWidth(Double.MAX_VALUE);
        //schakel button naar de andere pagina
        btTerug.setOnAction(actionEvent -> MainApplication.switchController(new ContactController()));

        view.add(contactLijstLabel, 0,10);
        view.add(groepListView,0,11,2,1);
        groepListView.setPrefHeight(150);

        view.add(btNieuw,0,16,2,1);
        btNieuw.setMaxWidth(Double.MAX_VALUE);
        view.add(btVerwijderen,0,17,2,1);
        btVerwijderen.setMaxWidth(Double.MAX_VALUE);
        view.add(btTerug,0,18,2,1);
        btTerug.setMaxWidth(Double.MAX_VALUE);

        border = new BorderPane();

        bestandMenu = new Menu("Bestand");

        opslaanMenuItem = new MenuItem("Opslaan");
        ladenMenuItem = new MenuItem("Laden");
        sluitenMenuItem = new MenuItem("Sluiten");

        bestandMenu.getItems().addAll(opslaanMenuItem, ladenMenuItem, new SeparatorMenuItem(), sluitenMenuItem);

        MenuBar menuBar = new MenuBar(bestandMenu);

        border.setTop(menuBar);
        border.setCenter(view);
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

    public ListView<Groep> getGroepListView() {
        return groepListView;
    }


    @Override
    public Parent getRoot() {
        return border;
    }
}
