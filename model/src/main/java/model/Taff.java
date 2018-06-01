package model;

import java.awt.Point;

import model.Element;
import showboard.IPawn;

public abstract class Taff extends Obstacle implements IPawn{
    /** The position. */
    private Point        position;
    
	protected boolean move;

	public Taff(final String imageName) {
		super(imageName);
		this.move = false;
		// TODO Auto-generated constructor stub
	}
	
	//******GETTERS****//
	
	public boolean isMove() {
		return move;
	}

	public void setMove(boolean move) {
		this.move = move;
	}

	protected abstract void moveUp();
	protected abstract void moveDown();
	protected abstract void moveRight();
	protected abstract void moveLeft();
	
	protected abstract void moveUpRight();
	protected abstract void moveUpLeft();
	protected abstract void moveDownRight();
	protected abstract void moveDownLeft();

	 public boolean isLeftCollision(Element element) {
	       
		 
		 if (((this.getPosition().y - 32) == element.x) &&
	            (getPosition().y == element.y)) {
	            return true;
	        } else {
	            return false;
	        }
	    }

	    public boolean isRightCollision(Element element) {
	        if (((this.getPosition().x + 32) == element.x)
	                && (this.getPosition().y == element.y)) {
	            return true;
	        } else {
	            return false;
	        }
	    }

	    public boolean isTopCollision(Element element) {
	        if (((this.getPosition().y - 32) == element.y) &&
	            (this.getPosition().x == element.x)) {
	            return true;
	        } else {
	            return false;
	        }
	    }

	    public boolean isBottomCollision(Element element) {
	        if (((this.getPosition().y + 32) == element.y
	                && (this.getPosition().x== element.x))) {
	            return true;
	        } else {
	            return false;
	        }
	    }
	    
	    /*
	     * (non-Javadoc)
	     * @see fr.exia.showboard.IPawn#getX()
	     */
	    @Override
	    public final int getX() {
	        return this.getPosition().x;
	    }

	    /*
	     * (non-Javadoc)
	     * @see fr.exia.showboard.IPawn#getY()
	     */
	    @Override
	    public final int getY() {
	        return this.getPosition().y;
	    }

	    /*
	     * (non-Javadoc)
	     * @see fr.exia.showboard.IPawn#getPosition()
	     */
	    @Override
	    public final Point getPosition() {
	        return this.position;
	    }

	    /**
	     * Sets the position.
	     *
	     * @param position
	     *            the position to set
	     */
	    public final void setPosition(final Point position) {
	        this.position = position;
	    }

	    /**
	     * Sets the position.
	     *
	     * @param x
	     *            the x
	     * @param y
	     *            the y
	     */
	    public final void setPosition(final int x, final int y) {
	        this.position = new Point(x, y);
	    }

	    /**
	     * <p>
	     * Move randomly the monster on the board.
	     * </p>
	     */
}
