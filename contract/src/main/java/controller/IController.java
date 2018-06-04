package controller;

import model.IModel;
import view.IView;

//The interface IController
public interface IController {
	public IView getView();
	public IModel getModel();
	public void gameOver();
	public char getDirection();
	public void setDirection(char direction);
	public void setSpellOnMap(boolean spellOnMap);
	public boolean isSpellOnMap();
}
