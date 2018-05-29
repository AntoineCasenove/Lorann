package model;

import java.sql.SQLException;
import java.util.List;

import model.dao.ExampleDAO;

//The Class ModelFacade provides a facade of the Model component.
public final class ModelFacade implements IModel {

	IMap map;

	//Instantiates a new model facade.
    public ModelFacade() {
        super();
        this.getMap();
        this.setMap(map);
    }

    /*
     * (non-Javadoc)
     * @see model.IModel#getExampleById(int)
     */
    @Override
    public Example getExampleById(final int id) throws SQLException {
        return ExampleDAO.getExampleById(id);
    }

    /*
     * (non-Javadoc)
     * @see model.IModel#getExampleByName(java.lang.String)
     */
    @Override
    public Example getExampleByName(final String name) throws SQLException {
        return ExampleDAO.getExampleByName(name);
    }

    /*
     * (non-Javadoc)
     * @see model.IModel#getAllExamples()
     */
    @Override
    public List<Example> getAllExamples() throws SQLException {
        return ExampleDAO.getAllExamples();
    }
    
	public IMap getMap() {
		return map;
	}

	public void setMap(IMap map) {
		this.map = map;
	}
    
}
