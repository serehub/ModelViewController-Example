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
 * Represents a Polygon
 *
 */
public class Polygon extends Item {
	private static final long serialVersionUID = 1L;
	private ArrayList<Point> vertices;
	
	/**
	 * Creates a polygon with n vertices
	 * 
	 * @param vertices
	 *            list of vertices of the polygon
	 */
	public Polygon(ArrayList<Point> vertices){
		this.setVertices(vertices);
	}

	/**
	 * Checks whether the given point falls within the polygon
	 * 
	 * @return true iff the given point is close to one of the polygon
	 */
	@Override
	public boolean includes(Point point) {
		for(int i=0; i<vertices.size();i++){
			if(distance(point, vertices.get(i)) < 10.0)
				return true;
		}
		return false;
	}

	/**
	 * Adds one vertice to the polygon
	 * 
	 * @param point
	 *            point to add to the list of vertices
	 */
	public void addVertice(Point vertice) {
		this.vertices.add(vertice);
	}
	
	/**
	 * Returns the list of vertices
	 * 
	 * @return the vertices of the polygon
	 */
	public ArrayList<Point> getVertices() {
		return vertices;
	}
	
	/**
	 * Sets the vertices of the polygon
	 * 
	 * @param vertices
	 *            list of vertices of the polygon
	 */
	public void setVertices(ArrayList<Point> vertices) {
		this.vertices = vertices;
	}
	
	/**
	 * Displays the polygon
	 */
	@Override
	public void render() {
		uiContext.draw(this);
	}
	
	/**
	 * Returns a string representation of the polygon
	 * 
	 * @return a string representation
	 */
	@Override
	public String toString() {
		return "Polygon  MISSING IMPLEMENTATION ";
	}
}