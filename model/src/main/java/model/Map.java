package model;

import java.awt.Image;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Observable;

import showboard.*;

public class Map extends Observable implements ISquare, IMap {
	
    private static final int width = 700;
    private static final int height = 700;
	private int	i;
	private Image image;

	public Map(){
	}
	
	public void loadFile() throws SQLException, IOException {
	}
	
	@Override
	public Image getImage() {
		return image;
	}

	@Override
	public void setImage(Image image) {
		this.image = image;
	}
	
	@Override
    public Observable getObservable() {
        return this;
    }

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}
}
