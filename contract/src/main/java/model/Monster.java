package model;

import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
* @author Antoine CASENOVE antoine.casenove@viacesi.fr
*/

public class Monster extends Mobile {
	
    /** The image. */
    public Image  image;

    /** The image name. */
    public String imageName;
    
	private Point Position;
	
	private boolean isInLife = true;
	
	public boolean isInLife() {
		return isInLife;
	}

	public void setInLife(boolean isInLife) {
		this.isInLife = isInLife;
	}

	public Monster(String imageName) throws IOException {
		super(imageName);
	}
	
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
