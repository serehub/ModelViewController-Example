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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;




class ItalicizeCheckBox extends JCheckBox implements ActionListener {
	protected JPanel drawingPanel;
	protected View view;
	private Label label;
	private UIContext con;
	private BoldfaceCommand boldfaceCommand;

	/**
	 * Creates the button for the label
	 * 
	 * @param jFrame
	 *            the frame where the label is put
	 * @param jPanel
	 *            the panel within the frame
	 */
	public ItalicizeCheckBox(View jFrame, JPanel jPanel) {
		super("Italicize");
		addActionListener(this);
	}

	/**
	 * Handle click for creating a new label
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		//con.boldface(label);
		 
	}

	
}

