package controller;

import java.sql.SQLException;
import java.util.List;

import model.Example;
import model.IModel;
import view.IView;

//The Class ControllerFacade provides a facade of the Controller component.
public class ControllerFacade implements IController {

    //The view
    private final IView  view;

    //The model
    private final IModel model;

    //Instantiates a new controller facade.
    public ControllerFacade(final IView view, final IModel model) {
        super();
        this.view = view;
        this.model = model;
    }

    //Start
    public void start() throws SQLException {
        this.getView().displayMessage(this.getModel().getExampleById(1).toString());

        this.getView().displayMessage(this.getModel().getExampleByName("Example 2").toString());

        final List<Example> examples = this.getModel().getAllExamples();
        final StringBuilder message = new StringBuilder();
        for (final Example example : examples) {
            message.append(example);
            message.append('\n');
        }
        this.getView().displayMessage(message.toString());
    }

    //Gets the view.
    public IView getView() {
        return this.view;
    }

    //Gets the model.
    public IModel getModel() {
        return this.model;
    }
}
