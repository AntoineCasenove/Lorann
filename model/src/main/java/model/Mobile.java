package model;

public abstract class Mobile extends Element{

	protected boolean move;
	
	
	public Mobile(int x, int y) {
		super(x, y);
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
	       
		 
		 if (((this.x - 32) == element.x) &&
	            (this.y == element.y)) {
	            return true;
	        } else {
	            return false;
	        }
	    }

	    public boolean isRightCollision(Element element) {
	        if (((this.x + 32) == element.x)
	                && (this.y == element.y)) {
	            return true;
	        } else {
	            return false;
	        }
	    }

	    public boolean isTopCollision(Element element) {
	        if (((this.y - 32) == element.y) &&
	            (this.x == element.x)) {
	            return true;
	        } else {
	            return false;
	        }
	    }

	    public boolean isBottomCollision(Element element) {
	        if (((this.y + 32) == element.y
	                && (this.x== element.x))) {
	            return true;
	        } else {
	            return false;
	        }
	    }
	    
	   
}
