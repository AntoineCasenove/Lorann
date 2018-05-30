package main;

import java.io.IOException;
import java.sql.SQLException;
import controller.ControllerFacade;
import model.IModel;
import view.ViewFacade;
import model.ModelFacade;

/** The Main class
	@authors Robin, Yacine, Antonin and Antoine
*/
public abstract class Main {

    // The main method
    public static void main(final String[] args) throws SQLException, IOException {
        
    	final IModel model = new ModelFacade();
    	final ViewFacade view = new ViewFacade(model);
    	final ControllerFacade controller = new ControllerFacade(view, model);
        
        try {
            controller.start();
        } catch (final SQLException exception) {
            exception.printStackTrace();
        }
    }
}