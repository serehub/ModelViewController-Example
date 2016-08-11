/**
Course:      ICS 372 
Semester:    Spring 2015
Instructor:  Brahma Dathan
Student:     Seretseab Kenaw
	 Project #3:  
Due date:    April 29, 2015
*/
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * The button to create polygons. Processes the mouse movements and clicks calling
 * the appropriate methods of controller.
 *
 */
public class PolygonButton extends JButton implements ActionListener, KeyListener{
	//private static final long serialVersionUID = 1L;
	protected JPanel drawingPanel;
	protected View view;
	private MouseHandler mouseHandler;
	private PolygonCommand polygonCommand;
	private ArrayList<Point> points;
	private int pointCount;

	/**
	 * Creates the button for the polygon
	 * 
	 * @param jFrame
	 *            the frame where the polygon is put
	 * @param jPanel
	 *            the panel within the frame
	 */
	public PolygonButton(View jFrame, JPanel jPanel) {
		super("Polygon");
		pointCount = 0;
		points= new ArrayList<Point>();
		addActionListener(this);
		addKeyListener(this);
		view = jFrame;
		drawingPanel = jPanel;
		mouseHandler = new MouseHandler();
	}

	/**
	 * Handle click for creating a new polygon
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		view.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		drawingPanel.addMouseListener(mouseHandler);
	}
	
	/**
	 * Handles mouse click so that the points can now be captured.
	 * 
	 */
	private class MouseHandler extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent event) {
				points.add(View.mapPoint(event.getPoint()));
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		polygonCommand = new PolygonCommand(points);
		UndoManager.instance().beginCommand(polygonCommand);
		drawingPanel.removeMouseListener(mouseHandler);
		view.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		UndoManager.instance().endCommand(polygonCommand);
		pointCount = 0;
		points=new ArrayList<Point>();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
