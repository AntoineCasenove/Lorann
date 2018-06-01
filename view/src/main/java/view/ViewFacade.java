package view;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controller.Element;
import showboard.BoardFrame;
import java.util.List;
import java.util.Observable;
import model.IModel;
import model.Obstacle;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */

public class ViewFacade extends Observable implements IView, Runnable {

	private IModel model;
	private final int frameWidth = 1056;
	private final int frameHeight = 922;
	private final int width = 20;
	private final int height = 15;
	public Rectangle view = new Rectangle(0,0,width,height);
	//private Element element = new Element(1,"/bone.png");
	private final Obstacle verticalBone = new Obstacle("vertical_bone.png");
	private final Obstacle horizontalBone = new Obstacle("horizontal_bone.png");
	private final Obstacle bone = new Obstacle("bone.png");
	private final Obstacle doorClosed = new Obstacle("gate_closed.png");
	private final Obstacle doorOpened = new Obstacle("gate_open.png");
	private final Obstacle purse = new Obstacle("purse.png");
	private final Obstacle crystalBall = new Obstacle("crystal_ball.png");
	private final Obstacle empty = new Obstacle("empty.png");
	private final Obstacle lolo = new Obstacle("lorann_b.png");
	//private Lorann lorann = new Lorann("lorann_bl.png");
	private char[][] tabElement = new char[width][height];
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
        this.lolo.loadImage();
    }
    
    @Override
    public void run(){
		this.frame = new BoardFrame("Lorann");
		frame.setDimension(new Dimension(width,height));
		frame.setDisplayFrame(view);
		
		try {
			this.configureBoardFrame(frame);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		frame.setSize(frameWidth,frameHeight);
		frame.setLocationRelativeTo(null);
    }
    
    @Override
    public void configureBoardFrame(BoardFrame frame) throws SQLException{
    	
    	final List<Element> entity = this.getModel().getAllExamples();
    	
    	int i = 900;
    	char tmp;
    	//System.out.println(entity.get(0).getName());
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
	    	setTabElement('!',x,y);
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
			frame.addSquare(lolo, x, y);
		break;
		default :
			setTabElement('!', x,y);
			frame.addSquare(empty, x, y);
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
	
	public void setTabElement(final char tabElement,final int x,final int y){
		this.tabElement[x][y] = tabElement;
	}

}
