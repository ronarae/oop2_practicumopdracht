package practicumopdracht.views;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class GroepView extends View{
    private TextField groepNaamInvoerVeld;
    private DatePicker datumToegevoegdInvoerVeld;
    private Button btOpslaan;

    private GridPane view;

    public GroepView() {
        groepNaamInvoerVeld = new TextField();
        datumToegevoegdInvoerVeld = new DatePicker();
        btOpslaan = new Button("Opslaan");
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
        view.setAlignment(Pos.TOP_CENTER);

        view.add(groepNaamLabel, 0, 0);
        view.add(groepNaamInvoerVeld, 1, 0);
        view.add(datumLabel,0,1);
        view.add(datumToegevoegdInvoerVeld, 1,1);

        view.add(btOpslaan, 0,3,3,1);
        btOpslaan.setMaxWidth(Double.MAX_VALUE);

    }

    @Override
    public Parent getRoot() {
        return view;
    }
}
