package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Example;

//The Class ExampleDAO.
public abstract class ExampleDAO extends AbstractDAO {

    // The sql example by id.
    private static String sqlExampleById   = "{call findExampleById(?)}";

    // The sql example by name.
    private static String sqlExampleByName = "{call findExampleByName(?)}";

    // The sql all examples.
    private static String sqlAllExamples   = "{call findAllExamples()}";

    // The id column index.
    private static int    idColumnIndex    = 1;

    // The name column index.
    private static int    nameColumnIndex  = 2;

    /**
     * Gets the example by id.
     *
     * @param id
     *            the id
     * @return the example by id
     * @throws SQLException
     *             the SQL exception
     */
    public static Example getExampleById(final int id) throws SQLException {
        final CallableStatement callStatement = prepareCall(sqlExampleById);
        Example example = null;
        callStatement.setInt(1, id);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();
            if (result.first()) {
                example = new Example(result.getInt(idColumnIndex), result.getString(nameColumnIndex));
            }
            result.close();
        }
        return example;
    }

    /**
     * Gets the example by name.
     *
     * @param name
     *            the name
     * @return the example by name
     * @throws SQLException
     *             the SQL exception
     */
    public static Example getExampleByName(final String name) throws SQLException {
        final CallableStatement callStatement = prepareCall(sqlExampleByName);
        Example example = null;

        callStatement.setString(1, name);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();
            if (result.first()) {
                example = new Example(result.getInt(idColumnIndex), result.getString(nameColumnIndex));
            }
            result.close();
        }
        return example;
    }

    /**
     * Gets the all examples.
     *
     * @return the all examples
     * @throws SQLException
     *             the SQL exception
     */
    public static List<Example> getAllExamples() throws SQLException {
        final ArrayList<Example> examples = new ArrayList<Example>();
        final CallableStatement callStatement = prepareCall(sqlAllExamples);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();

            for (boolean isResultLeft = result.first(); isResultLeft; isResultLeft = result.next()) {
                examples.add(new Example(result.getInt(idColumnIndex), result.getString(nameColumnIndex)));
                if(result.getString(nameColumnIndex).equals("O")){
                	System.out.println("Barrier");
                }
                else if(result.getString(nameColumnIndex).equals("I")){
                	System.out.println("Vertical bone");
                }
                else if(result.getString(nameColumnIndex).equals("-")){
                	System.out.println("Horizontal bone");
                }
                else if(result.getString(nameColumnIndex).equals("H")){
                	System.out.println("Door");
                }
                else if(result.getString(nameColumnIndex).equals("X")){
                	System.out.println("Grant");
                }
                else{
                	System.out.println("<<False symbol>>");
                }
            }
            for (boolean isResultLeft = result.first(); isResultLeft; isResultLeft = result.next()) {
            	if(result.getInt(idColumnIndex)%13 == 0 || result.getInt(idColumnIndex) == 1)
            		System.out.println("");
            	
            	System.out.print(result.getString(nameColumnIndex));
            }
            result.close();
        }
        return examples;
    }
}
