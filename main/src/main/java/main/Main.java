package main;

import java.io.IOException;
import java.sql.SQLException;
import controller.ControllerFacade;
import view.ViewFacade;
import model.ModelFacade;
import model.IModel;

/** The Main class
	@authors Robin, Yacine, Antonin and Antoine
*/
public abstract class Main {

    // The main method
    public static void main(final String[] args) throws SQLException, IOException {

    	final IModel model = new ModelFacade();
    	final ViewFacade view = new ViewFacade(model);
    	final ControllerFacade controller = new ControllerFacade(view, model);
    	
    	System.out.println(view.getTabElement(0, 0));
        try {
            controller.start();
        } catch (final SQLException exception) {
            exception.printStackTrace();
        }
    	//System.out.println("2");
    }
}