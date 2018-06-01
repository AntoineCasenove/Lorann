package model;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

import model.Element;

public class Wall extends Element {

    private Image imgWall;
    private ImageIcon iconWall;

    public Wall(int x, int y) {
        super(x, y);

        URL loc = this.getClass().getResource("wall.png");
         this.iconWall = new ImageIcon(loc);
        this.setImgWall(iconWall.getImage());
      

    }

	public Image getImgWall() {
		return imgWall;
	}

	public void setImgWall(Image imgWall) {
		this.imgWall = imgWall;
	}
}