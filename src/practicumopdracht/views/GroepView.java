package practicumopdracht.views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import practicumopdracht.MainApplication;
import practicumopdracht.controllers.ContactController;

public class GroepView extends View{
    private TextField groepNaamInvoerVeld;
    private DatePicker datumToegevoegdInvoerVeld;
    private Button btOpslaan;
    private Button btNieuw;
    private Button btVerwijderen;
    private Button btTerug;

    private GridPane view;

    public GroepView() {
        groepNaamInvoerVeld = new TextField();
        datumToegevoegdInvoerVeld = new DatePicker();
        btOpslaan = new Button("Opslaan");
        btNieuw = new Button("Nieuw");
        btTerug = new Button("Volgende");
        btVerwijderen = new Button("Verwijderen");
        initLayout();
    }

    public void initLayout() {
        Label groepNaamLabel = new Label("Groepnaam:");
        Label datumLabel = new Label("Datum Toegevoegd:");

        groepNaamInvoerVeld = new TextField();
        datumToegevoegdInvoerVeld = new DatePicker();

        view = new GridPane();
        view.setHgap(5);
        view.setVgap(5);
        view.setAlignment(Pos.BASELINE_CENTER);
        view.setPadding(new Insets(200, 10, 10, 10));

        view.add(groepNaamLabel, 0, 0);
        view.add(groepNaamInvoerVeld, 1, 0);
        view.add(datumLabel,0,1);
        view.add(datumToegevoegdInvoerVeld, 1,1);

        view.add(btOpslaan, 0,3,3,1);
        btOpslaan.setMaxWidth(Double.MAX_VALUE);
        btOpslaan.setOnAction(actionEvent -> MainApplication.switchController(new ContactController()));

        //HBOX
        HBox hbButtons = new HBox(btNieuw, btVerwijderen, btTerug);
        hbButtons.setSpacing(10);
        view.getChildren().add(hbButtons);
        view.add(btNieuw,0,14,2,1);
        btNieuw.setMaxWidth(Double.MAX_VALUE);
        view.add(btVerwijderen,0,15,2,1);
        btVerwijderen.setMaxWidth(Double.MAX_VALUE);
        view.add(btTerug,0,16,2,1);
        btTerug.setMaxWidth(Double.MAX_VALUE);

    }

    @Override
    public Parent getRoot() {
        return view;
    }
}
