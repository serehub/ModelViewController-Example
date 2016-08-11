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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class ImageButton extends JButton implements ActionListener{
	protected JPanel drawingPanel;
	protected View view;
	private MouseHandler mouseHandler;
	private ImageCommand imagecommand;
	final JFileChooser fc = new JFileChooser();
	
	/**
	 * Creates the button for the image
	 * 
	 * @param jFrame
	 *            the frame where the label is put
	 * @param jPanel
	 *            the panel within the frame
	 */
	public ImageButton(View jFrame, JPanel jPanel) {
		super("Image");
		addActionListener(this);
		view = jFrame;
		drawingPanel = jPanel;
		mouseHandler = new MouseHandler();
	}

	/**
	 * Handle click for creating a new image
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
		private int pointCount = 0;
		Point point1=null;
		Point point2=null;
		@Override
		public void mouseClicked(MouseEvent event) {
			if (++pointCount == 1) {
				point1=View.mapPoint(event.getPoint());
			} else if (pointCount == 2) {
				pointCount = 0;
				point2 =View.mapPoint(event.getPoint());
				drawingPanel.removeMouseListener(this);
				view.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				if (fc.showOpenDialog(ImageButton.this) == JFileChooser.APPROVE_OPTION) {
		            File file = fc.getSelectedFile();
		            BufferedImage image=null;
					try {
						image = ImageIO.read(file);
					} catch (IOException e) {
						e.printStackTrace();
					}
		            imagecommand= new ImageCommand(point1,point2,image);
					UndoManager.instance().beginCommand(imagecommand);
					UndoManager.instance().endCommand(imagecommand);
		        }
			}
		}
	}
}
