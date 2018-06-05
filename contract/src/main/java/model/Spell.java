package model;

import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spell extends Mobile{

	private Image imageSpell[];
	
	private int numberImage = 0;
	
	private Point position;
	
	private char direction;
	
	private boolean canSpell = true;
	
	public Spell(String imageName) throws IOException {
		super(imageName);
		
		this.imageSpell = new Image[8];
		int y = 0;
		for (int i = 1; i <= 5;i++)
		{
			this.imageSpell[y] = ImageIO.read(new File("sprites/fireball_" + i + ".png"));
			y++;
		}
	}
	
	public void changeColor(){
		
		if (numberImage == 5)
		{
			numberImage = 0;
		}
		this.setImage(imageSpell[numberImage]);
		numberImage++;	
	}
	
	@Override
	public int getX() {
		return this.getPosition().x;
	}
	
	@Override
	public int getY() {
		return this.getPosition().x;
	}
	
	@Override
	public Point getPosition() {
		return this.position;
	}
	
	//*******GETTERS AND SETTERS*****//
	
	public final void setPosition(final int x, final int y)
	{
		this.position = new Point(x,y);
	}
	
	public final void setPosition(Point position)
	{
		this.position = position;
	}
	
	@Override
	public void moveUp() {
		this.setPosition(this.getPosition().x , this.getPosition().y - 1);
	}
	
	@Override
	public void moveDown() {
	this.setPosition(this.getPosition().x , this.getPosition().y + 1);
	}
	
	@Override
	public void moveRight() {
	this.setPosition(this.getPosition().x + 1, this.getPosition().y);
	}
	
	@Override
	public void moveLeft() {
	this.setPosition(this.getPosition().x - 1, this.getPosition().y);
	}
	
	@Override
	public void moveRightUp() {
	this.setPosition(this.getPosition().x + 1, this.getPosition().y - 1);
	}
	
	@Override
	public void moveLeftUp() {
	this.setPosition(this.getPosition().x - 1 , this.getPosition().y - 1);
	}
	
	@Override
	public void moveRightDown() {
	this.setPosition(this.getPosition().x + 1 , this.getPosition().y + 1);
	}
	
	@Override
	public void moveLeftDown() {
	this.setPosition(this.getPosition().x - 1, this.getPosition().y + 1);
	}
	public void changeDirection(){
	 
	}
	
	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}
	
	public boolean isCanSpell() {
		return canSpell;
	}

	public void setCanSpell(boolean canSpell) {
		this.canSpell = canSpell;
	}
}