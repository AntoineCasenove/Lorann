package model;

import java.awt.Image;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Observable;

public interface IMap {
	public void loadFile() throws SQLException, IOException;
	public Image getImage();
	public void setImage(Image image);
	public Observable getObservable();
	public int getWidth();
	public int getHeight();
}
