package model;

import java.awt.Image;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Observable;

import model.dao.*;
import showboard.*;

public class Map extends Observable implements ISquare, IMap {
	
    private int width = 700;
    private int height = 700;
	private int	i;
	private Image image;
	

	public Map(){
	}
	
	public void loadFile() throws SQLException, IOException {
		
		final List<Example> entity = ExampleDAO.getAllExamples();
		
		for(i = 0; i<entity.size();i++){
			
			if(i%13 == 0 || i == 0)
				System.out.println();
			
			if(entity.get(i).getName().equals("O")){
				System.out.print("O");
			}
		    else if(entity.get(i).getName().equals("I")){
		    	System.out.print("I");
		    }
		    else if(entity.get(i).getName().equals("-")){
		    	System.out.print("-");
		    }
		    else if(entity.get(i).getName().equals("H")){
		    	System.out.print("H");
		    }
		    else if(entity.get(i).getName().equals("X")){
		    	System.out.print("X");
		    }
		    else{
		    	System.out.println("<<False symbol>>");
		    }
		}
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
