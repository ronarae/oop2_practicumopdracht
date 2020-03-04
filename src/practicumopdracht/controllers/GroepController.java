package practicumopdracht.controllers;

import practicumopdracht.views.ContactView;
import practicumopdracht.views.GroepView;
import practicumopdracht.views.View;

public class GroepController extends Controller {

    private GroepView groepView;

    public GroepController() {
        groepView = new GroepView();
    }

    @Override
    public View getView() {
        return groepView;
    }
}

