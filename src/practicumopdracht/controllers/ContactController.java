package practicumopdracht.controllers;


import practicumopdracht.views.ContactView;
import practicumopdracht.views.View;

public class ContactController  extends Controller {

    private ContactView contactView;

    public ContactController() {
        contactView = new ContactView();
    }
    @Override
    public View getView() {
        return contactView  ;
    }
}
