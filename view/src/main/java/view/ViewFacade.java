package view;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controller.Element;
import showboard.BoardFrame;
import java.util.List;
import java.util.Observable;
import model.*;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Antoine CASENOVE antoine.casenove@viacesi.fr
 * @version 1.0
 */

public class ViewFacade extends Observable implements IView, Runnable {

	private IModel model;
	private Lorann lorann = new Lorann("lorann_1.png");
	private Monster monster1 = new Monster("monster_1.png");
	private Monster monster2 = new Monster("monster_2.png");
	private Monster monster3 = new Monster("monster_3.png");
	private Monster monster4 = new Monster("monster_4.png");
	private final int frameWidth = 1056;
	private final int frameHeight = 922;
	private final int width = 20;
	private final int height = 15;
	public Rectangle view = new Rectangle(0,0,width,height+1);
	private final Obstacle verticalBone = new Obstacle("vertical_bone.png");
	private final Obstacle horizontalBone = new Obstacle("horizontal_bone.png");
	private final Obstacle bone = new Obstacle("bone.png");
	private final Obstacle doorClosed = new Obstacle("gate_closed.png");
	private final Obstacle doorOpened = new Obstacle("gate_open.png");
	private final Obstacle purse = new Obstacle("purse.png");
	private final Obstacle crystalBall = new Obstacle("crystal_ball.png");
	private final Obstacle empty = new Obstacle("empty.png");
	private char[][] tabElement = new char[width][height];
    Spell fireball = new Spell("fireball_1.png");
	private BoardFrame frame;
	
	/**
     * Instantiates a new view facade.
     * @throws IOException 
	 * @throws SQLException 
     */

    public ViewFacade(IModel model) throws IOException, SQLException {
        super();
        this.model = model;
    	this.verticalBone.loadImage();
        this.horizontalBone.loadImage();
        this.bone.loadImage();
        this.doorClosed.loadImage();
        this.doorOpened.loadImage();
        this.crystalBall.loadImage();
        this.purse.loadImage();
        this.empty.loadImage();
        this.getLorann().loadImage();
        this.monster1.loadImage();
        this.monster2.loadImage();
        this.monster3.loadImage();
        this.monster4.loadImage();
        this.fireball.loadImage();
    }
    
    @Override
    public void run(){
		this.frame = new BoardFrame("Lorann");
		frame.setDimension(new Dimension(width,height));
		frame.setDisplayFrame(view);
		
		try {
			this.configureBoardFrame(frame, 0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		frame.setSize(frameWidth,frameHeight);
		frame.setLocationRelativeTo(null);
    }

	@Override
    public void configureBoardFrame(BoardFrame frame, int i) throws SQLException{

    	final List<Element> entity = this.getModel().getAllExamples();

    	char tmp;

	    for (int y = 0; y < height; y++) {
	        for (int x = 0; x < width; x++) {
	        	tmp = entity.get(i).getName().charAt(0);
	        	this.refreshFrame(tmp, x, y);
				i++;
	        }
	    }
	this.addObserver(frame.getObserver());
		frame.setVisible(true);
	}

    public void refreshFrame(char entry,int x, int y){
    	
    	switch(entry){
    	case 'O' :
        	setTabElement('O',x,y);
        	frame.addSquare(bone, x, y);
        break;
		case '-' :
	    	setTabElement('-',x,y);
	    	frame.addSquare(horizontalBone, x, y);
	    break;
		case 'I' :
			setTabElement('I',x,y);
			frame.addSquare(verticalBone, x, y);
		break;
		case 'X' :
			setTabElement('X',x,y);
			frame.addSquare(purse, x, y);
		break;
		case 'H' :
			setTabElement('H',x,y);
			frame.addSquare(doorClosed, x, y);
		break;
		case 'h' :
			setTabElement('h',x,y);
			frame.addSquare(doorOpened, x, y);
		break;
		case 'C' :
			setTabElement('C',x,y);
			frame.addSquare(crystalBall, x, y);
		break;
		case 'L' :
			setTabElement('L',x,y);
			frame.addSquare(lorann,x,y);
			lorann.setPosition(x, y);
		break;
		case '1' :
			setTabElement('1',x,y);
			frame.addSquare(monster1, x, y);
			monster1.setPosition(x,y);
		break;
		case '2' :
			setTabElement('2',x,y);
			frame.addSquare(monster2, x, y);
			monster2.setPosition(x,y);
		break;
		case '3' :
			setTabElement('3',x,y);
			frame.addSquare(monster3, x, y);
			monster3.setPosition(x,y);
		break;
		case '4' :
			setTabElement('4',x,y);
			frame.addSquare(monster4, x, y);
			monster4.setPosition(x,y);
			//System.out.println(monster4.getX() + " " + monster4.getY());
		break;
		case 'S' :
			setTabElement('L',x,y);
			frame.addSquare(fireball, x, y);
		break;
		default :
			setTabElement('!', x,y);
			frame.addSquare(empty, x, y);
		break;
		}

    }
    
    public void updateF(){
    	this.setChanged();
    	this.notifyObservers();
    }
	/*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public Rectangle getView(){
    	return view;
    }
    
	public Lorann getLorann() {
		return lorann;
	}
    
    public void setView(Rectangle view){
    	this.view = view;
    }
    
    public IModel getModel() {
        return this.model;
    }
	
	public char getTabElement(final int x, final int y) {
		return this.tabElement[x][y];
	}

	public int getWidth(){
		return width;
	}
	
    public BoardFrame getBoardFrame() {
		return frame;
	}
	
	public void setTabElement(final char tabElement,final int x,final int y){
		this.tabElement[x][y] = tabElement;
	}
	
    public Monster getMonster1() {
		return monster1;
	}

	public Monster getMonster2() {
		return monster2;
	}

	public Monster getMonster3() {
		return monster3;
	}

	public Monster getMonster4() {
		return monster4;
	}

	@Override
	public Spell getSpell() {
		return fireball;
	}
}
