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
import model.ExampleDAO;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */

public class ViewFacade implements IView {
	
	
	private final IModel model;
	private final int frameWidth = 1100;
	private final int frameHeight = 960;
	private final int width = 20;
	private final int height = 15;
	private Rectangle view = new Rectangle(0,0,width,height);
	//private Element element = new Element(1,"/bone.png");
	private final Tile verticalBone = new Tile("/vertical_bone.png");
	private final Tile horizontalBone = new Tile("/horizontal_bone.png");
	private final Tile bone = new Tile("/bone.png");
	private final Tile doorClose = new Tile("/gate_closed.png");
	private final Tile purse = new Tile("/purse.png");
	private final Tile empty = new Tile("");
	public String tabElement[][] = new String[width][height];
	
    /**
     * Instantiates a new view facade.
     * @throws IOException 
     */

    public ViewFacade(final IModel model) throws IOException {
        super();
        this.verticalBone.loadImage();
        this.horizontalBone.loadImage();
        this.bone.loadImage();
        this.doorClose.loadImage();
        this.purse.loadImage();
        this.model = model;
        //this.setMap(map);
        //this.setView(new Rectangle(5,5, 700, 700));
    }
    
    public void runView() throws SQLException{
		final BoardFrame frame = new BoardFrame("Lorann");
		//this.getMap().getObservable().addObserver(frame.getObserver());
		//frame.setDimension(new Dimension(this.getMap().getWidth(),this.getMap().getHeight()));
		frame.setDimension(new Dimension(width,height));
		frame.setDisplayFrame(view);
		//frame.setWidthLooped(true);
		//frame.setHeightLooped(true);
		frame.setSize(frameWidth,frameHeight);
		frame.getDisplayFrame();
		//frame.addPawn(element);
		frame.setLocationRelativeTo(null);
		this.configureBoardFrame(frame);
    }
    
    public void configureBoardFrame(BoardFrame frame) throws SQLException{
    	
    	final List<Element> entity = this.getModel().getAllExamples();
    	
    	int i = 0;
    	
	    for (int y = 0; y < height; y++) {
	        for (int x = 0; x < width; x++) {
				if(entity.get(i).getName().equals("O")){
					tabElement[x][y] = "O";
					frame.addSquare(bone, x, y);
				}
			    else if(entity.get(i).getName().equals("I")){
			    	tabElement[x][y] = "I";
			    	frame.addSquare(verticalBone, x, y);
			    }
			    else if(entity.get(i).getName().equals("-")){
			    	tabElement[x][y] = "-";
			    	frame.addSquare(horizontalBone, x, y);
			    }
			    else if(entity.get(i).getName().equals("H")){
			    	tabElement[x][y] = "H";
			    	frame.addSquare(doorClose, x, y);
			    }
			    else if(entity.get(i).getName().equals("X")){
			    	tabElement[x][y] = "X";
			    	frame.addSquare(purse, x, y);
			    }
			    else if(entity.get(i).getName().equals("!")){
			    	tabElement[x][y] = "!";
			    	frame.addSquare(empty, x, y);
			    }
				i++;
	        }
	    }
	frame.setVisible(true);
	System.out.print("Hey" + tabElement[9][12]);
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
}
