package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
* @author Antoine CASENOVE antoine.casenove@viacesi.fr
*/

public class Menu implements WindowListener, KeyListener {

	private final int frameWidth = 600;
	private final int frameHeight = 750;
	private JFrame frame;
	private boolean isClose = false;
	private ImageIcon image;

	public Menu() throws IOException{
		this.frame = new JFrame("Welcome!");
		this.frame.setSize(frameWidth,frameHeight);
		this.frame.setLocationRelativeTo(null);
		this.frame.addKeyListener(this);
		this.frame.requestFocus();
	    this.frame.setVisible(true);
	    this.image = new ImageIcon("sprites/menu.png");
        JLabel image = new JLabel(this.image);
        frame.add(image);
        frame.setVisible(true);
	    
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {	
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	public boolean getClose() {
		return isClose;
	}

	public void setClose(boolean isClose) {
		this.isClose = isClose;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			this.setClose(true);
			this.frame.dispose();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}
