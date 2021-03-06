package view;

import java.io.IOException;
import java.sql.SQLException;

import model.IModel;
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
    public void runView() throws SQLException;
    public void configureBoardFrame(BoardFrame frame) throws SQLException;
}
