package controller;

import java.awt.Point;

import model.Obstacle;
import showboard.IPawn;

//The Class Example
public class Element{

    //The id
    private final int id;

    //The name
    private String    name;

    //Instantiates a new example.
    public Element(final int id, final String name) {
        super();
        this.id = id;
        this.name = name;
    }

    //Gets the id
    public int getId() {
        return this.id;
    }

    //Gets the name
    public String getName() {
        return this.name;
    }

    //Sets the name
    public void setName(final String name) {
        this.name = name;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.getId() + " : " + this.getName();
    }
}
