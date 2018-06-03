package controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.awt.event.*;

import model.*;
import view.*;

//The Class ControllerFacade provides a facade of the Controller component.
public class ControllerFacade implements IController, KeyListener {

    //The view
    private final IView  view;

    //The model
    private final IModel model;

    Thread_Lorann thread;
    
    private int i = 0;
    
    //Instantiates a new controller facade.
    public ControllerFacade(final IView view, final IModel model) {
        super();
        this.view = view;
        this.model = model;
        this.thread = new Thread_Lorann ("test", this);
    }

    //Start
    public void start() throws SQLException {
    	this.view.run();
    	this.thread.start();
    	this.getView().getBoardFrame().addKeyListener(this);
    	this.getView().getBoardFrame().requestFocus();
    	//this.view.updateF();
    	//int i = 0;
    	/*while(i == 0){
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
    	}*/
    	//this.view.getTabElement(2, 2);
    	
    	/*this.view.refreshFrame('!',view.getLorann().getX(), view.getLorann().getY());
    	System.out.println(view.getLorann().getX() + " " + view.getLorann().getY());
    	this.view.getLorann().moveRight();
    	System.out.println(view.getLorann().getX() + " " + view.getLorann().getY());
    	this.view.refreshFrame('L', this.view.getLorann().getX(), this.view.getLorann().getY());
    	this.view.updateF();*/
    }

    //Gets the view.
    public IView getView() {
        return this.view;
    }

    //Gets the model.
    public IModel getModel() {
        return this.model;
    }

	@Override
	public void keyTyped(KeyEvent e) {
	}

	public void openDoor(){
		for(int y = 0; y < 15; y++){
			for(int x = 0; x < 20; x++){
				if(this.view.getTabElement(x, y) == 'H'){
					this.view.setTabElement('h', x, y);
			    	this.view.refreshFrame('h', x, y);
			    	this.view.updateF();
				}
			}
		}
	}
	
	public void move(char chr){
		this.view.refreshFrame('!',view.getLorann().getX(), view.getLorann().getY());
		
		switch(chr){
		case 'U' :
			this.view.getLorann().moveUp();
			break;
		case 'D' :
			this.view.getLorann().moveDown();
			break;
		case 'L' :
			this.view.getLorann().moveLeft();
			break;
		case 'R' :
			this.view.getLorann().moveRight();
			break;
		case 'A' :
			this.view.getLorann().moveLeftUp();
			break;
		case 'E' :
			this.view.getLorann().moveRightUp();
			break;
		case 'Q' :
			this.view.getLorann().moveLeftDown();
			break;
		case 'd' : 
			this.view.getLorann().moveRightDown();
			break;
		}
		
    	this.view.refreshFrame('L', this.view.getLorann().getX(), this.view.getLorann().getY());
    	this.view.updateF();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		switch(keyCode){
		
		case KeyEvent.VK_UP:
			if(this.getView().getTabElement(view.getLorann().getX(), view.getLorann().getY()-1) == '!'){
				this.move('U');
			}
			else if(this.getView().getTabElement(view.getLorann().getX(), view.getLorann().getY()-1) == 'X'){
				this.move('U');
			}
			else if(this.getView().getTabElement(view.getLorann().getX(), view.getLorann().getY()-1) == 'C'){
				this.move('U');
				this.openDoor();
			}
			else if(this.getView().getTabElement(view.getLorann().getX(), view.getLorann().getY()-1) == 'h'){
				this.move('U');
				this.setI(i+=300);
				try {
					this.view.configureBoardFrame(this.view.getBoardFrame(), this.getI());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
	    	break;
	    	
		case KeyEvent.VK_DOWN:
			if(this.getView().getTabElement(view.getLorann().getX(), view.getLorann().getY()+1) == '!'){
				this.move('D');
			}
			else if(this.getView().getTabElement(view.getLorann().getX(), view.getLorann().getY()+1) == 'X'){
				this.move('D');
			}
			else if(this.getView().getTabElement(view.getLorann().getX(), view.getLorann().getY()+1) == 'C'){
				this.move('D');
				this.openDoor();
			}
			else if(this.getView().getTabElement(view.getLorann().getX(), view.getLorann().getY()+1) == 'h'){
				this.move('D');
				this.setI(i+=300);
				try {
					this.view.configureBoardFrame(this.view.getBoardFrame(), this.getI());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
	    	break;
	    	
		case KeyEvent.VK_LEFT:
			if(this.getView().getTabElement(view.getLorann().getX()-1, view.getLorann().getY()) == '!'){
				this.move('L');
			}
			else if(this.getView().getTabElement(view.getLorann().getX()-1, view.getLorann().getY()) == 'X'){
				this.move('L');
			}
			else if(this.getView().getTabElement(view.getLorann().getX()-1, view.getLorann().getY()) == 'C'){
				this.move('L');
				this.openDoor();
			}
			else if(this.getView().getTabElement(view.getLorann().getX()-1, view.getLorann().getY()) == 'h'){
				this.move('L');
				this.setI(i+=300);
				try {
					this.view.configureBoardFrame(this.view.getBoardFrame(), this.getI());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
	    	break;
	    	
		case KeyEvent.VK_RIGHT:
			if(this.getView().getTabElement(view.getLorann().getX()+1, view.getLorann().getY()) == '!'){
				this.move('R');
			}
			else if (this.getView().getTabElement(view.getLorann().getX()+1, view.getLorann().getY()) == 'X'){
				this.move('R');
			}
			else if (this.getView().getTabElement(view.getLorann().getX()+1, view.getLorann().getY()) == 'C'){
				this.move('R');
				this.openDoor();
			}
			else if(this.getView().getTabElement(view.getLorann().getX()+1, view.getLorann().getY()) == 'h'){
				this.move('R');
				this.setI(i+=300);
				try {
					this.view.configureBoardFrame(this.view.getBoardFrame(), this.getI());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
	    	break;
	    	
		case KeyEvent.VK_E:
			if(this.getView().getTabElement(view.getLorann().getX()+1, view.getLorann().getY()-1) == '!'){
				this.move('E');
			}
			else if(this.getView().getTabElement(view.getLorann().getX()+1, view.getLorann().getY()-1) == 'X'){
				this.move('E');
			}
			else if(this.getView().getTabElement(view.getLorann().getX()+1, view.getLorann().getY()-1) == 'C'){
				this.move('E');
				this.openDoor();
			}
			else if(this.getView().getTabElement(view.getLorann().getX()+1, view.getLorann().getY()-1) == 'h'){
				this.move('E');
				this.setI(i+=300);
				try {
					this.view.configureBoardFrame(this.view.getBoardFrame(), this.getI());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
	    	break;
	    	
		case KeyEvent.VK_A:
			if(this.getView().getTabElement(view.getLorann().getX()-1, view.getLorann().getY()-1) == '!'){
				this.move('A');
			}
			else if(this.getView().getTabElement(view.getLorann().getX()-1, view.getLorann().getY()-1) == 'X'){
				this.move('A');
			}
			else if(this.getView().getTabElement(view.getLorann().getX()-1, view.getLorann().getY()-1) == 'C'){
				this.move('A');
				this.openDoor();
			}
			else if(this.getView().getTabElement(view.getLorann().getX()-1, view.getLorann().getY()-1) == 'h'){
				this.move('A');
				this.setI(i+=300);
				try {
					this.view.configureBoardFrame(this.view.getBoardFrame(), this.getI());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
	    	break;
	    	
		case KeyEvent.VK_D:
			if(this.getView().getTabElement(view.getLorann().getX()+1, view.getLorann().getY()+1) == '!'){
				this.move('d');
			}
			else if(this.getView().getTabElement(view.getLorann().getX()+1, view.getLorann().getY()+1) == 'X'){
				this.move('d');
			}
			else if(this.getView().getTabElement(view.getLorann().getX()+1, view.getLorann().getY()+1) == 'C'){
				this.move('d');
				this.openDoor();
			}
			else if(this.getView().getTabElement(view.getLorann().getX()+1, view.getLorann().getY()+1) == 'h'){
				this.move('d');
				this.setI(i+=300);
				try {
					this.view.configureBoardFrame(this.view.getBoardFrame(), this.getI());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
	    	break;
	    	
		case KeyEvent.VK_Q:
			if(this.getView().getTabElement(view.getLorann().getX()-1, view.getLorann().getY()+1) == '!'){
				this.move('Q');
			}
			else if(this.getView().getTabElement(view.getLorann().getX()-1, view.getLorann().getY()+1) == 'X'){
				this.move('Q');
			}
			else if(this.getView().getTabElement(view.getLorann().getX()-1, view.getLorann().getY()+1) == 'C'){
				this.move('Q');
				this.openDoor();
			}
			else if(this.getView().getTabElement(view.getLorann().getX()-1, view.getLorann().getY()+1) == 'h'){
				this.move('Q');
				this.setI(i+=300);
				try {
					this.view.configureBoardFrame(this.view.getBoardFrame(), this.getI());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
	    	break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
}
