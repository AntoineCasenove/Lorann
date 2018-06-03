package controller;

import model.IModel;
import view.IView;

//The interface IController
public interface IController {
	public IView getView();
	public IModel getModel();
}
