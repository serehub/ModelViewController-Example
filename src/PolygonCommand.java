/**
Course:      ICS 372 
Semester:    Spring 2015
Instructor:  Brahma Dathan
Student:     Seretseab Kenaw
	 Project #3:  
Due date:    April 29, 2015
*/
import java.awt.Point;
import java.util.ArrayList;

/**
 * For undoing polygons creations
 *
 */
public class PolygonCommand extends Command{

	Polygon polygon;
	
	/**
	 * Creates a Polygon command.
	 * 
	 * @param points
	 *            list of the vertices
	 */
	public PolygonCommand(ArrayList<Point> points) {
		polygon = new Polygon(points);
	}
	
	/**
	 * Adds one vertice to the polygon
	 * 
	 * @param point
	 *            the extra vertice
	 */
	public void addVerticePoint(Point point) {
		polygon.addVertice(point);
	}
	
	/**
	 * Undoes the command by removing the item from the model
	 */
	@Override
	public boolean undo() {
		model.removeItem(polygon);
		return true;
	}

	/**
	 * Brings the polygon back by calling execute
	 */
	@Override
	public boolean redo() {
		execute();
		return true;
	}

	/**
	 * Executes the command to add the item to the model
	 */
	@Override
	public void execute() {
		model.addItem(polygon);
	}
}
