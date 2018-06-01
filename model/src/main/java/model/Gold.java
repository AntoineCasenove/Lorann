package model;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Gold extends Element{

	private Image imgGold;
	private ImageIcon iconGold;
	
	public Gold(int x, int y) {
		super(x, y);
		
		this.iconGold = new ImageIcon(getClass().getResource("/images/purse.png"));
		this.setImgGold(this.iconGold.getImage());
	}

	public Image getImgGold() {
		return imgGold;
	}
	
	

	public void setImgGold(Image imgGold) {
		this.imgGold = imgGold;
	}

}
