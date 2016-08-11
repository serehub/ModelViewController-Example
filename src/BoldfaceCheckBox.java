/**
Course:      ICS 372 
Semester:    Spring 2015
Instructor:  Brahma Dathan
Student:     Seretseab Kenaw
	 Project #3:  
Due date:    April 29, 2015
*/
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;


class BoldfaceCheckBox extends JCheckBox implements ActionListener  {
	protected JPanel drawingPanel;
	protected View view;
	protected NewSwingUI ui;
	private Label label;
	private UIContext con;
	private BoldfaceCommand boldfaceCommand;
	protected Boldface bold;
	//private MouseHandler mouseHandler;
	//private KeyHandler keyHandler;
	//private MouseHandler mouseHandler;
	private LabelCommand labelCommand;
	protected boolean boldfaceChecked;

	/**
	 * Creates the button for the label
	 * 
	 * @param jFrame
	 *            the frame where the label is put
	 * @param jPanel
	 *            the panel within the frame
	 */
	public BoldfaceCheckBox(View jFrame, JPanel jPanel) {
		super("Boldface");
		addActionListener(this);
		boldfaceChecked=false;
		view=jFrame;
		drawingPanel=jPanel;
	}

	/**
	 * Handle click for creating a new label
	 */
	
		/**
		 * Handle click for creating a new label
		 */
		@Override
		public void actionPerformed(ActionEvent event) {
			
			NewSwingUI.getInstance().boldSelected=isSelected();
			if(isSelected()==true){
			
			}
			
			repaint();
			System.out.println(isSelected());
		}


	}

