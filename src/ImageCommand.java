/**
Course:      ICS 372 
Semester:    Spring 2015
Instructor:  Brahma Dathan
Student:     Seretseab Kenaw
	 Project #3:  
Due date:    April 29, 2015
*/
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 * For undoing line creations
 *
 */

public class ImageCommand extends Command {
    private Image image;

    /**
     * Creates a image command
     * 
     * @param point
     *            first endpoint
     * @param point2
     *            second endpoint
     * @param image
     *            image to be drawn
     */
    public ImageCommand(Point point, Point point2, BufferedImage image) {
	this.image = new Image(point, point2, image);
    }

    /**
     * Sets the second end point
     * 
     * @param point
     *            the second point
     */
    public void setSecondPoint(Point point) {
	image.setPoint2(point);
    }

    /**
     * Executes the command to add the item to the model
     */
    @Override
    public void execute() {
	model.addItem(image);
    }

    /**
     * Undoes the command by removing the image from the model
     */
    @Override
    public boolean undo() {
	model.removeItem(image);
	return true;
    }

    /**
     * Brings the image back by calling execute
     */
    @Override
    public boolean redo() {
	execute();
	return true;
    }
}
