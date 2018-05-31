package view;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import showboard.BoardFrame;
import java.util.List;
import model.IModel;
import model.Tile;
import model.Element;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */

public class ViewFacade implements IView {
	
	
	private IModel model;
	private final int frameWidth = 1100;
	private final int frameHeight = 960;
	private final int width = 20;
	private final int height = 15;
	private Rectangle view = new Rectangle(0,0,width,height);
	//private Element element = new Element(1,"/bone.png");
	private final Tile verticalBone = new Tile("vertical_bone.png");
	private final Tile horizontalBone = new Tile("horizontal_bone.png");
	private final Tile bone = new Tile("bone.png");
	private final Tile doorClose = new Tile("gate_closed.png");
	private final Tile purse = new Tile("purse.png");
	private final Tile empty = new Tile("empty.png");
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
        this.doorClose.loadImage();
        this.purse.loadImage();
    }
    
    @Override
    public void runView() throws SQLException{
		this.frame = new BoardFrame("LorannEUH");
		frame.setDimension(new Dimension(width,height));
		frame.setDisplayFrame(view);
		this.configureBoardFrame(frame);
		frame.setSize(frameWidth,frameHeight);
		frame.setLocationRelativeTo(null);
    }
    
    @Override
    public void configureBoardFrame(BoardFrame frame) throws SQLException{
    	
    	final List<Element> entity = this.getModel().getAllExamples();
    	
    	int i = 0;
    	//System.out.println(entity.get(0).getName());
	    for (int y = 0; y < height; y++) {
	        for (int x = 0; x < width; x++) {
				if(entity.get(i).getName().equals("O")){
					setTabElement('O',x,y);
					frame.addSquare(this.bone, x, y);
				}
			    else if(entity.get(i).getName().equals("I")){
			    	setTabElement('I',x,y);
			    	frame.addSquare(this.verticalBone, x, y);
			    }
			    else if(entity.get(i).getName().equals("-")){
			    	setTabElement('-',x,y);
			    	frame.addSquare(this.horizontalBone, x, y);
			    }
			    else if(entity.get(i).getName().equals("H")){
			    	setTabElement('H',x,y);
			    	frame.addSquare(this.doorClose, x, y);
			    }
			    else if(entity.get(i).getName().equals("X")){
			    	setTabElement('X',x,y);
			    	frame.addSquare(this.purse, x, y);
			    }
			    else{
			    	setTabElement('!',x,y);
			    	frame.addSquare(this.empty, x, y);
			    }
			    
				i++;
	        }
	    }
	frame.setVisible(true);
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
