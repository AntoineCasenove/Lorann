package model;

/**
* @authors Antoine CASENOVE antoine.casenove@viacesi.fr, Antonin PRETET antoine.pretet@viacesi.fr
*/

import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import showboard.IPawn;

public class Lorann extends Mobile{
	
	private int numberImage = 0;
	private Point Position;
	private Image imageLorann[];
	private boolean inLife = true;
	
	public boolean getInLife() {
		return inLife;
	}

	public void setInLife(boolean inLife) {
		this.inLife = inLife;
	}

	public Lorann(final String nameFile) throws IOException {
		super(nameFile);
		
		this.imageLorann = new Image[8];
		int y = 0;
		for (int i = 1; i <= 8;i++)
		{
			this.imageLorann[y] = ImageIO.read(new File("sprites/lorann_" + i + ".png"));
			y++;
		}
	}

	//*******AFK ANIMATION*****//
	
	public void afk(){
		
		if (numberImage == 8)
		{
			numberImage = 0;
		}
		this.setImage(imageLorann[numberImage]);
		numberImage++;	
	}
	
	//*******GETTERS AND SETTERS*****//
	
	@Override
	public int getX() 
	{
		return this.getPosition().x;
	}

	@Override
	public int getY() 
	{
		return this.getPosition().y;
	}

	@Override
	public Point getPosition() 
	{
		return this.Position;
	}
	
	public final void setPosition(final int x, final int y)
	{
		this.Position = new Point(x,y);
	}
	
	public final void setPosition(Point position)
	{
		this.Position = position;
	}
	
	@Override
	public void moveUp() {
		this.setPosition(getPosition().x, getPosition().y-1);
	}

	@Override
	public void moveDown() {
		this.setPosition(getPosition().x, getPosition().y+1);
	}

	@Override
	public void moveRight() {
		this.setPosition(getPosition().x+1, getPosition().y);
	}

	@Override
	public void moveLeft() {
		this.setPosition(getPosition().x-1, getPosition().y);
	}

	@Override
	public void moveRightUp() {
		this.setPosition(getPosition().x+1, getPosition().y-1);
	}

	@Override
	public void moveLeftUp() {
		this.setPosition(getPosition().x-1, getPosition().y-1);
	}

	@Override
	public void moveRightDown() {
		this.setPosition(getPosition().x+1, getPosition().y+1);
	}

	@Override
	public void moveLeftDown() {
		this.setPosition(getPosition().x-1, getPosition().y+1);
	}
}
