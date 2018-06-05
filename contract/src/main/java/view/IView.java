package view;

import java.sql.SQLException;
import model.*;
import showboard.BoardFrame;

/**
 * <h1>The Interface IView.</h1>
 *
 * @authors Antoine CASENOVE antoine.casenove@viacesi.fr, Antonin PRETET antoine.pretet@viacesi.fr
 *
 * @version 1.0
 */

public interface IView {

    /**
     * Display message.
     *
     * @param message
     *            the message
     */
	
    void displayMessage(String message);
    
    /**
     * Run the view 
     *
     */
    
    public void run();
    public void updateF();
    public void configureBoardFrame(BoardFrame frame, int i) throws SQLException;
    public void setTabElement(final char tabElement,final int x,final int y);
    public char getTabElement(final int x,final int y);
    public void refreshFrame(char entry, int x, int y);
    public Lorann getLorann();
    public BoardFrame getBoardFrame();
    public Monster getMonster1();
    public Monster getMonster2();
    public Monster getMonster3();
    public Monster getMonster4();
    public Spell getSpell();
}
