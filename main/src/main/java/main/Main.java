package main;

import java.io.IOException;
import java.sql.SQLException;

import controller.ControllerFacade;
import model.*;
import view.ViewFacade;

/** The Main class
	@authors Robin, Yacine, Antonin and Antoine
*/
public abstract class Main {

    // The main method
    public static void main(final String[] args) throws SQLException, IOException {
        final ControllerFacade controller = new ControllerFacade(new ViewFacade(), new ModelFacade());
        final Map map = new Map();
        
        map.mapGenerator();
        
        try {
            controller.start();
        } catch (final SQLException exception) {
            exception.printStackTrace();
        }
    }

}