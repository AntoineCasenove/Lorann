package model;

import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import showboard.IPawn;

public class Lorann extends Mobile{
	
	private int numberImage = 0;
	private Point Positon;
	//private Image imgLorann;
	//private ImageIcon iconLorann;
	private Image imageLorann[];
	private boolean move;
	//private int n;
	
	public Lorann(final String nameFile) throws IOException {
		super(nameFile);
		
		this.imageLorann = new Image[8];
		int y = 0;
		for (int i = 1; i <= 8;i++)
		{
			this.imageLorann[y] = ImageIO.read(new File("sprites/lorann_" + i + ".png"));
			y++;
		}
		
		//this.imageLorann = new Image[8];
		//this.move = false;
		//this.iconLorann = new ImageIcon(getClass().getResource("/images/lorann_l.png"));
		//this.imgLorann = this.iconLorann.getImage();
		//this.afk(); //Il tourne sur lui meme quand il est n'est pas en mouvement.
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
		return this.Positon;
	}
	
	public final void setPosition(final int x, final int y)
	{
		this.Positon = new Point(x,y);
	}
	
	public final void setPosition(Point position)
	{
		this.Positon = position;
	}
	
	@Override
	public void moveUp() {
		this.setPosition(getPosition().x, getPosition().y-1);
		this.move = true;
	}

	@Override
	public void moveDown() {
		this.setPosition(getPosition().x, getPosition().y+1);
		this.move = true;
	}

	@Override
	public void moveRight() {
		this.setPosition(getPosition().x+1, getPosition().y);
		this.move = true;
	}

	@Override
	public void moveLeft() {
		this.setPosition(getPosition().x-1, getPosition().y);
		this.move = true;	
	}

	@Override
	public void moveRightUp() {
		this.setPosition(getPosition().x+1, getPosition().y-1);
		this.move = true;
	}

	@Override
	public void moveLeftUp() {
		this.setPosition(getPosition().x-1, getPosition().y-1);
		this.move = true;
	}

	@Override
	public void moveRightDown() {
		this.setPosition(getPosition().x+1, getPosition().y+1);
		this.move = true;
	}

	@Override
	public void moveLeftDown() {
		this.setPosition(getPosition().x-1, getPosition().y+1);
		this.move = true;
	}
	
	//*******EFFET MOUVANT*****//
	
	public void afk(){
		
		if (numberImage == 8)
		{
			numberImage = 0;
		}
		this.setImage(imageLorann[numberImage]);
		numberImage++;
		
		/*String str = null;
		
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
			
			n++;*/
		
		
			
			//this.iconLorann = new ImageIcon(getClass().getResource(str));
			//this.imgLorann = this.iconLorann.getImage();
			
			
		//}

		//return this.imgLorann;
		
		
//		this.iconLorann = new ImageIcon(getClass().getResource(str));
//		this.imgLorann = this.iconLorann.getImage();
//		return this.imgLorann;
			
	}
	
	/*public void run(){
		
		while(this.move == false)
		{
			this.afk();
			try{
				Thread.sleep(10);
				}catch(InterruptedException e){}
		}
	}*/
	
	/*public boolean catchGold(Purse gold){
		
		if(this.getPosition().x == gold.getX() && this.getPosition().y == gold.getY())
			return true;
		else
			return false;
	}*/
		
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
