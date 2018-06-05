package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import showboard.IPawn;

/**
* @author Antoine CASENOVE antoine.casenove@viacesi.fr
*/

public abstract class Mobile implements IPawn{
	
    /** The image. */
    public Image  image;

    /** The image name. */
    public String imageName;
	
	protected abstract void moveUp();
	protected abstract void moveDown();
	protected abstract void moveRight();
	protected abstract void moveLeft();
	
	protected abstract void moveRightUp();
	protected abstract void moveLeftUp();
	protected abstract void moveRightDown();
	protected abstract void moveLeftDown();
    
    public Mobile(final String imageName) {
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
    public void setImage(final Image image) {
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