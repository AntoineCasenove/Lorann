package main;

import java.io.IOException;
import java.sql.SQLException;
import controller.ControllerFacade;
import view.*;
import model.*;

/** The Main class
	@authors Robin, Yacine, Antonin and Antoine
*/
public abstract class Main {
	
    // The main method
    public static void main(final String[] args) throws SQLException, IOException, InterruptedException {
    	
	    final IModel model = new ModelFacade();
    	final ViewFacade view = new ViewFacade(model);
    	final ControllerFacade controller = new ControllerFacade(view, model);
    	
        System.out.println(controller.getDirection());
        try {
            controller.start();
        } catch (final SQLException exception) {
            exception.printStackTrace();
        }
    }
}