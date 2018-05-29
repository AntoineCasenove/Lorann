package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.imageio.ImageIO;

import model.dao.*;
import showboard.*;

public class Map {
	
	private int i;

	public Map(){
	}
	
	public void mapGenerator() throws SQLException, IOException{
		int x = 0;
		int y = 0;
		final List<Example> entity = ExampleDAO.getAllExamples();
		final BoardFrame frame = new BoardFrame("Lorann");
		Image bone = ImageIO.read(new File("sprites/bone.png"));
		final ISquare square = null;
		square.getImage();
		
		for(i = 0; i<entity.size();i++){
			
			if(i%13 == 0 || i == 0)
				System.out.println();
			
			if(entity.get(i).getName().equals("O")){
				System.out.print("O");
				frame.addSquare(square, 2, 2);
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
}
