package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import model.IMap;

//The Class ModelFacade provides a facade of the Model component.
public final class ModelFacade implements IModel {

	private IMap map;

	//Instantiates a new model facade.
    public ModelFacade() throws SQLException, IOException {
        /*this.setMap(new Map());
        this.getMap().loadFile();*/
    }

    /*
     * (non-Javadoc)
     * @see model.IModel#getExampleById(int)
     */
    @Override
    public Element getExampleById(final int id) throws SQLException {
        return ExampleDAO.getExampleById(id);
    }

    /*
     * (non-Javadoc)
     * @see model.IModel#getExampleByName(java.lang.String)
     */
    @Override
    public Element getExampleByName(final String name) throws SQLException {
        return ExampleDAO.getExampleByName(name);
    }

    /*
     * (non-Javadoc)
     * @see model.IModel#getAllExamples()
     */
    @Override
    public List<Element> getAllExamples() throws SQLException {
        return ExampleDAO.getAllExamples();
    }
    
	public IMap getMap() {
		return map;
	}

	public void setMap(IMap map) {
		this.map = map;
	}
    
}
