package model;

import java.awt.Point;

public class Spell extends Mobile{

	Point position;
	
	char direction;
	
	boolean canSpell = true;

	private boolean back;
	
	public Spell(String imageName) {
		super(imageName);
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
	
	public boolean isBack() {
	return back;
	}
	
	public void setBack(boolean back) {
	this.back = back;
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