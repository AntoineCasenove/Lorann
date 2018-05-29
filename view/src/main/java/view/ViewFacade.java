package view;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JOptionPane;

import showboard.BoardFrame;
import showboard.ISquare;
import model.IMap;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */

public class ViewFacade implements IView {
	
    private int width;
    private int height;
	private ISquare square;
	private Rectangle view;
	private IMap map;
	
	
    /**
     * Instantiates a new view facade.
     */

    public ViewFacade() {
        super();
        this.setMap(map);
        this.setView(new Rectangle(500,500, 2, 2));
    }
    
    public void runView(){
		final BoardFrame frame = new BoardFrame("Lorann");
		frame.setDimension(new Dimension(this.getMap().getWidth(),this.getMap().getHeight()));
		frame.setDisplayFrame(view);
		frame.setWidthLooped(true);
		frame.setHeightLooped(true);
		frame.setSize(this.view.width,this.view.height);
		frame.getDisplayFrame();
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
    
    public void setView(Rectangle rectangle){
    	this.view = view;
    }
    
	public ISquare getSquare() {
		return square;
	}

	public void setSquare(ISquare square) {
		this.square = square;
	}

	public IMap getMap() {
		return map;
	}

	public void setMap(IMap map) {
		this.map = map;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
