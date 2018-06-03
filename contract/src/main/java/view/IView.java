package view;

import java.io.IOException;
import java.sql.SQLException;

import model.IModel;
import model.Lorann;
import model.Obstacle;
import showboard.BoardFrame;

/**
 * <h1>The Interface IView.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
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
    public void run();
    public void updateF();
    public void configureBoardFrame(BoardFrame frame, int i) throws SQLException;
    public void setTabElement(final char tabElement,final int x,final int y);
    public char getTabElement(final int x,final int y);
    public void refreshFrame(char entry, int x, int y);
    public Lorann getLorann();
    public BoardFrame getBoardFrame();
}
