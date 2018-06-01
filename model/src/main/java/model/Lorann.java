package model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Lorann extends Mobile{

	private Image imgLorann;
	private ImageIcon iconLorann;
	private int n;

	
	
	public Lorann(int x, int y) {
		super(x, y);
//		this.iconLorann = new ImageIcon(getClass().getResource("/images/lorann_l.png"));
//		this.imgLorann = this.iconLorann.getImage();
		this.imgLorann = this.bouge(); //Il tourne sur lui meme quand il est n'est pas en mouvement
	}
	
	public Image getLorann(){
		return imgLorann;
		}

	@Override
	public void moveUp() {
		this.iconLorann = new ImageIcon(getClass().getResource("/images/lorann_u.png"));
		this.imgLorann = this.iconLorann.getImage();
		this.y = this.y - 32;
		
	}

	@Override
	public void moveDown() {
		
		this.iconLorann = new ImageIcon(getClass().getResource("/images/lorann_b.png"));
		this.imgLorann = this.iconLorann.getImage();
		this.y = this.y + 32;
		this.move = true;
		
	}

	@Override
	public void moveRight() {
		this.iconLorann = new ImageIcon(getClass().getResource("/images/lorann_r.png"));
		this.imgLorann = this.iconLorann.getImage();
		this.x = this.x + 32;
		this.move = true;
		
	}

	@Override
	public void moveLeft() {
		this.iconLorann = new ImageIcon(getClass().getResource("/images/lorann_l.png"));
		this.imgLorann = this.iconLorann.getImage();
		this.x = this.x - 32;
		this.move = true;
		
	}

	@Override
	protected void moveUpRight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void moveUpLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void moveDownRight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void moveDownLeft() {
		// TODO Auto-generated method stub
		
	}
	
	//*******EFFET MOUVANT*****//
	
	public Image bouge(){
		
		String str = null;
		
		
			
		while(this.move == false){
			if(this.n == 1)
				str = "/images/lorann_b.png";
			else if(this.n == 2)
				str = "/images/lorann_bl.png";
			else if(n == 3)
				str = "/images/lorann_l.png";
			else if(n == 4)
				str = "/images/lorann_ul.png";
			else if(n == 5)
				str = "/images/lorann_u.png";
			else if(n == 6)
				str = "/images/lorann_ur.png";
			else if(n == 7)
				str = "/images/lorann_r.png";
			else 
				str = "/images/lorann_br.png";
			
			if(this.n == 8)
				this.n = 0;
			
			n++;
			
			this.iconLorann = new ImageIcon(getClass().getResource(str));
			this.imgLorann = this.iconLorann.getImage();
			
			
		}

		return this.imgLorann;
		
		
//		this.iconLorann = new ImageIcon(getClass().getResource(str));
//		this.imgLorann = this.iconLorann.getImage();
//		return this.imgLorann;
			
	}
	
	public void run(){
		
		while(this.move == false)
		{
			this.bouge();
			try{
				Thread.sleep(10);
				}catch(InterruptedException e){}
		}
	}
	
	public boolean catchGold(Gold gold){
		
		if(this.x == gold.getX() && this.y == gold.getY())
			return true;
		else
			return false;
	}
		
//		public void move(String order){
//			
//			if(order = "U")
//				this.moveUp();
//			else if(order = "D")
//				this.moveDown();();
//			else if(order = "R")
//				this.moveRight();
//			else if(order = "L")
//				this.moveLeft();
//			else
//				this.bouge();
//			
//		}
	
	
	

}
