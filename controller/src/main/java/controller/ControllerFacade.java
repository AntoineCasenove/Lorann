package controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import model.Element;
import model.IModel;
import model.Tile;
import view.IView;

//The Class ControllerFacade provides a facade of the Controller component.
public class ControllerFacade implements IController {

    //The view
    private final IView  view;

    //The model
    private final IModel model;

    //Instantiates a new controller facade.
    public ControllerFacade(final IView view, final IModel model) {
        super();
        this.view = view;
        this.model = model;
    }

    //Start
    public void start() throws SQLException {
    	this.view.run();
    	int i = 0;
    	while(i == 0){
        	Scanner sc = new Scanner(System.in);
        	System.out.println("Entrez un caractère (!,I,-,O,X,H,h,C) : ");
        	String str = sc.nextLine();
        	char entry = str.charAt(0);
        	System.out.println("Entrez coordonnée x < 20 : ");
        	int chrX = sc.nextInt();
        	System.out.println("Entrez coordonnée y < 15 : ");
        	int chrY = sc.nextInt();
        	
        	this.view.refreshFrame(entry,chrX, chrY);
        	System.out.println(this.view.getTabElement(chrX, chrY));
        	this.view.updateF();
    	}
    }

    //Gets the view.
    public IView getView() {
        return this.view;
    }

    //Gets the model.
    public IModel getModel() {
        return this.model;
    }
}
