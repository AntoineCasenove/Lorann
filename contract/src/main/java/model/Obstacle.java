package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import showboard.ISquare;

/**
 * <h1>The Class Square.</h1>
 *
 * @author Anne-Emilie DIET
 * @version 1.0
 */

public class Obstacle implements ISquare {

    /** The image. */
    public Image  image;

    /** The image name. */
    public String imageName;

    /**
     * Instantiates a new square.
     *
     * @param imageName the image name
     */
    public Obstacle(final String imageName) {
        this.setImageName(imageName);
    }
    
    /**
     * Gets the image.
     *
     * @return the image
     */
    /*
     * (non-Javadoc)
     * @see fr.exia.showboard.ISquare#getImage()
     */
    @Override
    public Image getImage() {
        return this.image;
    }

    /**
     * Load image.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public final void loadImage() throws IOException {
        this.setImage(ImageIO.read(new File("sprites/" + this.getImageName())));
    }

    /**
     * Sets the image.
     *
     * @param image the new image
     */
    private void setImage(final Image image) {
        this.image = image;
    }

    /**
     * Gets the image name.
     *
     * @return the image name
     */
    private String getImageName() {
        return this.imageName;
    }

    /**
     * Sets the image name.
     *
     * @param imageName the imageName to set
     */
    private void setImageName(final String imageName) {
        this.imageName = imageName;
    }

}

