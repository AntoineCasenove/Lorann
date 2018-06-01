package model;

public abstract class Element {
	protected int x;
	protected int y;
//	ImageIcon imgicon;
//	Image img;
	
	
	//****Constructeur****//
	public Element (int x, int y){
		this.x = x;
		this.y = y;
	}

	//*****GETTER**//
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	//****SETTERS****//

	public void setX(int x) {
		this.x = x;
	}


	public void setY(int y) {
		this.y = y;
	}
	
	
}
