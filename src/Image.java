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
 * Represents an Image
 *
 */
public class Image extends Item {
	private static final long serialVersionUID = 1L;
	private Point point1;
	private Point point2;
	private BufferedImage image;
	
	/**
	 * Creates a new Image with the given endpoints
	 * 
	 * @param point1
	 *            one endpoint
	 * @param point2
	 *            another endpoint
	 */
	public Image(Point point1, Point point2, BufferedImage image) {
		this.point1 = point1;
		this.point2 = point2;
		this.setImage(image);
	}
	/**
	 * Checks whether the given point falls within the image
	 * 
	 * @return true iff the given point is close to one of the endpoints
	 */
	@Override
	public boolean includes(Point point) {
		return ((distance(point, point1) < 10.0) || (distance(point, point2) < 10.0)|| (distance(point, new Point(point2.x,point1.y)) < 10.0)|| (distance(point, new Point(point1.x,point2.y))< 10.0));
	}
	/**
	 * Returns one of the endpoints
	 * 
	 * @return an endpoint
	 */
	public Point getPoint1() {
		return point1;
	}
	/**
	 * Sets the first endpoint
	 * 
	 * @param point
	 *            an endpoint
	 */
	public void setPoint1(Point point1) {
		this.point1 = point1;
	}
	/**
	 * Returns the second endpoint
	 * 
	 * @return endpoint
	 */
	public Point getPoint2() {
		return point2;
	}
	/**
	 * Sets the second endpoint
	 * 
	 * @param point
	 *            an endpoint
	 */
	public void setPoint2(Point point) {
		point2 = point;
	}
	/**
	 * Displays the image
	 */
	@Override
	public void render() {
		uiContext.draw(this);
	}
	/**
	 * Returns the buffered image
	 * 
	 * @return image
	 */
	public BufferedImage getImage() {
		return image;
	}
	/**
	 * Sets the buffered image to be drawn
	 * 
	 * @param image
	 *            a buffered image
	 */
	public void setImage(BufferedImage image) {
		this.image = image;
	}
}
