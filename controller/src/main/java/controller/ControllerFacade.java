package controller;

import java.sql.SQLException;
import java.util.Scanner;
import java.awt.event.*;
import java.io.IOException;

import model.*;
import view.*;

/**
* @author Antoine CASENOVE antoine.casenove@viacesi.fr
*/

//The Class ControllerFacade provides a facade of the Controller component.
public class ControllerFacade implements IController, KeyListener {

    //The view
    private final IView view;

    //The model
    private final IModel model;

    Thread_Lorann threadLorann;
    
    Thread_Monster threadMonster;
    
    Thread_Spell threadSpell;
    
    private char direction;

    private boolean spellOnMap = false;
    
    private int score = 0;

	private int i = 0;
   
    //Instantiates a new controller facade.
    public ControllerFacade(final IView view, final IModel model) {
        super();
        this.view = view;
        this.model = model;
        this.threadLorann = new Thread_Lorann ("Lorann", this);
        this.threadMonster = new Thread_Monster ("1", this);
    }

    //Start
    public void start() throws SQLException, IOException, InterruptedException {
    	
    	final Menu menu = new Menu();
    	
    	while(menu.getClose() == false){
    		Thread.sleep(0);
    	}
    	
    	this.view.run();
    	this.threadLorann.start();
		this.threadMonster.start();

    	this.getView().getBoardFrame().addKeyListener(this);
    	this.getView().getBoardFrame().requestFocus();
    	
    	//this.view.updateF();
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
			chr = 'L';
			break;
		case 'E' :
			this.view.getLorann().moveRightUp();
			chr = 'R';
			break;
		case 'Q' :
			this.view.getLorann().moveLeftDown();
			chr = 'L';
			break;
		case 'd' : 
			this.view.getLorann().moveRightDown();
			chr = 'R';
			break;
		}
		
		this.setDirection(chr);
    	this.view.refreshFrame('L', this.view.getLorann().getX(), this.view.getLorann().getY());
    	this.view.updateF();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {

		int keyCode = e.getKeyCode();

		final char elementUp = this.getView().getTabElement(view.getLorann().getX(), view.getLorann().getY()-1);
		final char elementDown = this.getView().getTabElement(view.getLorann().getX(), view.getLorann().getY()+1);
		final char elementLeft = this.getView().getTabElement(view.getLorann().getX()-1, view.getLorann().getY());
		final char elementRight = this.getView().getTabElement(view.getLorann().getX()+1, view.getLorann().getY());
		final char elementRightUp = this.getView().getTabElement(view.getLorann().getX()+1, view.getLorann().getY()-1);
		final char elementLeftUp = this.getView().getTabElement(view.getLorann().getX()-1, view.getLorann().getY()-1);
		final char elementRightDown = this.getView().getTabElement(view.getLorann().getX()+1, view.getLorann().getY()+1);
		final char elementLeftDown = this.getView().getTabElement(view.getLorann().getX()-1, view.getLorann().getY()+1);

		switch(keyCode){

		case KeyEvent.VK_UP:
			if(elementUp == '!'){
				this.move('U');
			}
			else if(elementUp == 'X'){
				this.move('U');
				score+=100;
			}
			else if(elementUp == 'C'){
				this.move('U');
				this.openDoor();
			}
			else if(elementUp == 'h'){
				this.move('U');
				this.setI(i+=300);
				if(i >= 1500){
					this.youWin();
				}
				try {
					this.view.configureBoardFrame(this.view.getBoardFrame(), this.getI());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(i == 300){
			        this.threadMonster = new Thread_Monster ("2", this);
				}
				else if(i == 600){
					this.threadMonster = new Thread_Monster ("3", this);
				}
				else if(i == 900){
					this.threadMonster = new Thread_Monster ("4", this);
				}
				if(i == 1200){
			        this.threadMonster = new Thread_Monster ("5", this);
			        this.view.getMonster2().setInLife(true);
				}
				this.threadMonster.start();
			}
			else if(elementUp == '1' || elementUp == '2' || elementUp == '3' || elementUp == '4' || elementUp == 'H'){
				this.view.getLorann().setInLife(false);
			}
	    	break;

		case KeyEvent.VK_DOWN:
			if(elementDown == '!'){
				this.move('D');
			}
			else if(elementDown == 'X'){
				this.move('D');
				score+=100;
			}
			else if(elementDown == 'C'){
				this.move('D');
				this.openDoor();
			}
			else if(elementDown == 'h'){
				this.move('D');
				this.setI(i+=300);
				if(i >= 1500){
					this.youWin();
				}
				try {
					this.view.configureBoardFrame(this.view.getBoardFrame(), this.getI());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(i == 300){
			        this.threadMonster = new Thread_Monster ("2", this);
				}
				else if(i == 600){
					this.threadMonster = new Thread_Monster ("3", this);
				}
				else if(i == 900){
					this.threadMonster = new Thread_Monster ("4", this);
				}
				if(i == 1200){
			        this.threadMonster = new Thread_Monster ("5", this);
			        this.view.getMonster2().setInLife(true);
				}
				this.threadMonster.start();
			}
			else if(elementDown == '1' || elementDown == '2' || elementDown == '3' || elementDown == '4' || elementDown == 'H'){
				this.view.getLorann().setInLife(false);
			}
	    	break;
	    	
		case KeyEvent.VK_LEFT:
			if(elementLeft == '!'){
				this.move('L');
			}
			else if(elementLeft == 'X'){
				this.move('L');
				score+=100;
			}
			else if(elementLeft == 'C'){
				this.move('L');
				this.openDoor();
			}
			else if(elementLeft == 'h'){
				this.move('L');
				this.setI(i+=300);
				if(i >= 1500){
					this.youWin();
				}
				try {
					this.view.configureBoardFrame(this.view.getBoardFrame(), this.getI());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(i == 300){
			        this.threadMonster = new Thread_Monster ("2", this);
				}
				else if(i == 600){
					this.threadMonster = new Thread_Monster ("3", this);
				}
				else if(i == 900){
					this.threadMonster = new Thread_Monster ("4", this);
				}
				if(i == 1200){
			        this.threadMonster = new Thread_Monster ("5", this);
			        this.view.getMonster2().setInLife(true);
				}
				this.threadMonster.start();
			}
			else if(elementLeft == '1' || elementLeft == '2' || elementLeft == '3' || elementLeft == '4' || elementLeft == 'H'){
				this.view.getLorann().setInLife(false);
			}
	    	break;
	    	
		case KeyEvent.VK_RIGHT:
			if(elementRight == '!'){
				this.move('R');
			}
			else if(elementRight == 'X'){
				this.move('R');
				score+=100;
			}
			else if (elementRight == 'C'){
				this.move('R');
				this.openDoor();
			}
			else if(elementRight == 'h'){
				this.move('R');
				this.setI(i+=300);
				if(i >= 1500){
					this.youWin();
				}
				try {
					this.view.configureBoardFrame(this.view.getBoardFrame(), this.getI());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(i == 300){
			        this.threadMonster = new Thread_Monster ("2", this);
				}
				else if(i == 600){
					this.threadMonster = new Thread_Monster ("3", this);
				}
				else if(i == 900){
					this.threadMonster = new Thread_Monster ("4", this);
				}
				if(i == 1200){
			        this.threadMonster = new Thread_Monster ("5", this);
			        this.view.getMonster2().setInLife(true);
				}
				this.threadMonster.start();
			}
			else if(elementRight == '1' || elementRight == '2' || elementRight == '3' || elementRight == '4' || elementRight == 'H'){
				this.view.getLorann().setInLife(false);
			}
	    	break;
	    	
		case KeyEvent.VK_E:
			if(elementRightUp == '!'){
				this.move('E');
			}
			else if(elementRightUp == 'X'){
				this.move('E');
				score+=100;
			}
			else if(elementRightUp == 'C'){
				this.move('E');
				this.openDoor();
			}
			else if(elementRightUp == 'h'){
				this.move('E');
				this.setI(i+=300);
				if(i >= 1500){
					this.youWin();
				}
				try {
					this.view.configureBoardFrame(this.view.getBoardFrame(), this.getI());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(i == 300){
			        this.threadMonster = new Thread_Monster ("2", this);
				}
				else if(i == 600){
					this.threadMonster = new Thread_Monster ("3", this);
				}
				else if(i == 900){
					this.threadMonster = new Thread_Monster ("4", this);
				}
				if(i == 1200){
			        this.threadMonster = new Thread_Monster ("5", this);
			        this.view.getMonster2().setInLife(true);
				}
				this.threadMonster.start();
			}
			else if(elementRightUp == '1' || elementRightUp == '2' || elementRightUp == '3' || elementRightUp == '4' || elementRightUp == 'H'){
				this.view.getLorann().setInLife(false);
			}
	    	break;
	    	
		case KeyEvent.VK_A:
			if(elementLeftUp == '!'){
				this.move('A');
			}
			else if(elementLeftUp == 'X'){
				this.move('A');
				score+=100;
			}
			else if(elementLeftUp == 'C'){
				this.move('A');
				this.openDoor();
			}
			else if(elementLeftUp == 'h'){
				this.move('A');
				this.setI(i+=300);
				if(i >= 1500){
					this.youWin();
				}
				try {
					this.view.configureBoardFrame(this.view.getBoardFrame(), this.getI());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(i == 300){
			        this.threadMonster = new Thread_Monster ("2", this);
				}
				else if(i == 600){
					this.threadMonster = new Thread_Monster ("3", this);
				}
				else if(i == 900){
					this.threadMonster = new Thread_Monster ("4", this);
				}
				if(i == 1200){
			        this.threadMonster = new Thread_Monster ("5", this);
			        this.view.getMonster2().setInLife(true);
				}
				this.threadMonster.start();
			}
			else if(elementLeftUp == '1' || elementLeftUp == '2' || elementLeftUp == '3' || elementLeftUp == '4' || elementLeftUp == 'H'){
				this.view.getLorann().setInLife(false);
			}
	    	break;
	    	
		case KeyEvent.VK_D:
			if(elementRightDown == '!'){
				this.move('d');
			}
			else if(elementRightDown == 'X'){
				this.move('d');
				score+=100;
			}
			else if(elementRightDown == 'C'){
				this.move('d');
				this.openDoor();
			}
			else if(elementRightDown == 'h'){
				this.move('d');
				this.setI(i+=300);
				if(i >= 1500){
					this.youWin();
				}
				try {
					this.view.configureBoardFrame(this.view.getBoardFrame(), this.getI());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(i == 300){
			        this.threadMonster = new Thread_Monster ("2", this);
				}
				else if(i == 600){
					this.threadMonster = new Thread_Monster ("3", this);
				}
				else if(i == 900){
					this.threadMonster = new Thread_Monster ("4", this);
				}
				if(i == 1200){
			        this.threadMonster = new Thread_Monster ("5", this);
			        this.view.getMonster2().setInLife(true);
				}
				this.threadMonster.start();
			}
			else if(elementRightDown == '1' || elementRightDown == '2' || elementRightDown == '3' || elementRightDown == '4' || elementRightDown == 'H'){
				this.view.getLorann().setInLife(false);
			}
	    	break;
	    	
		case KeyEvent.VK_Q:
			if(elementLeftDown == '!'){
				this.move('Q');
			}
			else if(elementLeftDown == 'X'){
				this.move('Q');
				score+=100;
			}
			else if(elementLeftDown == 'C'){
				this.move('Q');
				this.openDoor();
			}
			else if(elementLeftDown == 'h'){
				this.move('Q');
				this.setI(i+=300);
				if(i >= 1500){
					this.youWin();
				}
				try {
					this.view.configureBoardFrame(this.view.getBoardFrame(), this.getI());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				if(i == 300){
			        this.threadMonster = new Thread_Monster ("2", this);
				}
				else if(i == 600){
					this.threadMonster = new Thread_Monster ("3", this);
				}
				else if(i == 900){
					this.threadMonster = new Thread_Monster ("4", this);
				}
				if(i == 1200){
			        this.threadMonster = new Thread_Monster ("5", this);
			        this.view.getMonster2().setInLife(true);
				}
				this.threadMonster.start();
			}
			else if(elementLeftDown == '1' || elementLeftDown == '2' || elementLeftDown == '3' || elementLeftDown == '4' || elementLeftDown == 'H'){
				this.view.getLorann().setInLife(false);
			}
	    	break;
	    	
		case KeyEvent.VK_SPACE:
			if(this.isSpellOnMap() == false){
				this.threadSpell = new Thread_Spell(this, this.getDirection());
				
				int x = this.getView().getLorann().getX();
				int y = this.getView().getLorann().getY();
				
				if(this.getDirection() == 'U' && this.getView().getTabElement(x, y-1) == '!')
					this.getView().getSpell().setPosition(x, y-1);
				else if(this.getDirection() == 'D' && this.getView().getTabElement(x, y+1) == '!')
					this.getView().getSpell().setPosition(x, y+1);
				else if(this.getDirection() == 'L' && this.getView().getTabElement(x-1, y) == '!')
					this.getView().getSpell().setPosition(x-1, y);
				else if(this.getDirection() == 'R' && this.getView().getTabElement(x+1, y) == '!')
					this.getView().getSpell().setPosition(x+1, y);
				
				this.threadSpell.start();
				
				this.setSpellOnMap(true);
			}
	    	break;
		}
	}
	
	public int getScore() {
		return score;
	}

	public void gameOver(){
    	if(this.view.getLorann().getInLife() == false){
    		this.view.setTabElement('!', this.view.getLorann().getX(), this.view.getLorann().getY());
    		this.view.refreshFrame('!', this.view.getLorann().getX(), this.view.getLorann().getY());
    		this.view.getBoardFrame().dispose();
    		this.view.displayMessage("Game Over" + "Score : " + this.getScore());
    		System.exit(0);
    	}
	}
	
	public void youWin(){
		this.view.setTabElement('!', this.view.getLorann().getX(), this.view.getLorann().getY());
		this.view.refreshFrame('!', this.view.getLorann().getX(), this.view.getLorann().getY());
		this.view.getBoardFrame().dispose();
		this.view.displayMessage("You win !\n" + "Score : " + this.getScore());
		System.exit(0);
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

    public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	
	public boolean isSpellOnMap() {
		return spellOnMap;
	}

	public void setSpellOnMap(boolean spellOnMap) {
		this.spellOnMap = spellOnMap;
	}
}
