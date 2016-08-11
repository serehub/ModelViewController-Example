/**
 * @author Brahma Dathan and Sarnath Ramnath
 * @Copyright (c) 2010
 * Redistribution and use with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - the use is for academic purpose only
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   - Neither the name of Brahma Dathan or Sarnath Ramnath
 *     may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * The authors do not make any claims regarding the correctness of the code in this module
 * and are not responsible for any loss or damage resulting from its use.  
 */
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The view of the MC architecture
 *
 */
public class View extends JFrame implements Observer {
	private static final long serialVersionUID = 1L;
	private UIContext uiContext;
	private JPanel drawingPanel;
	private JPanel buttonPanel;
	private JPanel newButtonPanel;
	private JButton lineButton;
	private JButton polygonButton;
	private JButton deleteButton;
	private JButton labelButton;
	private JButton imageButton;
	private JButton selectButton;
	private JButton saveButton;
	private JButton openButton;
	private JButton undoButton;
	private JButton redoButton;
	private JCheckBox underlineButton;
	private JCheckBox itlaicizeButon;
	private JCheckBox boldfaceButton;
	private JComboBox fontButton;
	private JComboBox fontSizeButton;
	

	private String fileName;
	// other buttons to be added as needed;
	private static Model model;

	/**
	 * Returns the UIContext
	 * 
	 * @return the UIContext
	 */
	public UIContext getUI() {
		return uiContext;
	}

	/**
	 * Sets the UIContext
	 * 
	 * @param uiContext
	 *            the UIContext to be used
	 */
	private void setUI(UIContext uiContext) {
		this.uiContext = uiContext;
	}

	/**
	 * Sets the mode
	 * 
	 * @param model
	 *            the model
	 */
	public static void setModel(Model model) {
		View.model = model;
	}

	/**
	 * The panel where drawing occurs
	 *
	 */
	private class DrawingPanel extends JPanel {
		private MouseListener currentMouseListener;
		private KeyListener currentKeyListener;
		private FocusListener currentFocusListener;

		/**
		 * Paints the panel
		 * 
		 * @param graphics
		 *            the Graphics object
		 */
		@Override
		public void paintComponent(Graphics graphics) 
		{
			model.setUI(NewSwingUI.getInstance());
			super.paintComponent(graphics);
			(NewSwingUI.getInstance()).setGraphics(graphics);
			graphics.setColor(Color.BLUE);
			Iterator<Item> iterator = model.getItems();
			while (iterator.hasNext()) {
				iterator.next().render();
			}
			graphics.setColor(Color.RED);
			iterator = model.getSelectedItems();
			while (iterator.hasNext()) {
				iterator.next().render();
			}
		}

		/**
		 * Makes the given object the listener to mouse events
		 * 
		 * @param newListener
		 *            the new listener
		 */
		@Override
		public void addMouseListener(MouseListener newListener) {
			removeMouseListener(currentMouseListener);
			currentMouseListener = newListener;
			super.addMouseListener(newListener);
		}

		/**
		 * Makes the given object the listener to keyboard events
		 * 
		 * @param newListener
		 *            the new listener
		 */
		@Override
		public void addKeyListener(KeyListener newListener) {
			removeKeyListener(currentKeyListener);
			currentKeyListener = newListener;
			super.addKeyListener(newListener);
		}

		/**
		 * When the component gains or loses the keyboard focus, the relevant
		 * method in the listener object is invoked
		 * 
		 * @param newListener
		 *            the new listener
		 */
		@Override
		public void addFocusListener(FocusListener newListener) {
			removeFocusListener(currentFocusListener);
			currentFocusListener = newListener;
			super.addFocusListener(newListener);
		}
	}

	/**
	 * Remembers the file name for storing in the title
	 * 
	 * @param fileName
	 *            file name
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
		setTitle("Drawing Program 1.1  " + fileName);
	}

	/**
	 * returns the file name
	 * 
	 * @return file name
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Initializes the view by creating all the widgets
	 */
	public View() {
		super("Drawing Program 1.2");
		fileName = null;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent event) {
				System.exit(0);
			}
		});
		model.setUI(NewSwingUI.getInstance());
		drawingPanel = new DrawingPanel();
		buttonPanel = new JPanel();
		newButtonPanel=new JPanel();
		Container contentpane = getContentPane();
		contentpane.add(buttonPanel, "North");
		contentpane.add(drawingPanel,"Center");
		contentpane.add(newButtonPanel,"South");
		lineButton = new LineButton(this, drawingPanel);
		polygonButton = new PolygonButton(this, drawingPanel);
		labelButton = new LabelButton(this, drawingPanel);
		imageButton = new ImageButton(this, drawingPanel);
		underlineButton=new UnderlineCheckBox(this, drawingPanel);
		boldfaceButton=new BoldfaceCheckBox(this, drawingPanel);
		itlaicizeButon=new ItalicizeCheckBox(this, drawingPanel);
		fontSizeButton=new FontSizeComboBox(this, drawingPanel);
		fontButton=new FontComboBox(this, drawingPanel);
		selectButton = new SelectButton(this, drawingPanel);
		deleteButton = new DeleteButton();
		saveButton = new SaveButton(this);
		openButton = new OpenButton(this);
		undoButton = new UndoButton();
		redoButton = new RedoButton();
		buttonPanel.add(lineButton);
		buttonPanel.add(polygonButton);
		buttonPanel.add(labelButton);
		buttonPanel.add(imageButton);
		newButtonPanel.add(underlineButton);
		newButtonPanel.add(boldfaceButton);
		newButtonPanel.add(itlaicizeButon);
		newButtonPanel.add(fontSizeButton);
		newButtonPanel.add(fontButton);
		buttonPanel.add(selectButton);
		buttonPanel.add(deleteButton);
		buttonPanel.add(saveButton);
		buttonPanel.add(openButton);
		buttonPanel.add(undoButton);
		buttonPanel.add(redoButton);
		this.setSize(750, 500);
	}

	/**
	 * Catches updates from the controller
	 */
	public void refresh() {
		// code to access the Model update the contents of the drawing panel.
		drawingPanel.repaint();
	}

	/**
	 * maps a point on the drawing panel to a point on the figure being created.
	 * 
	 * @param point
	 *            the GUI point
	 * @return translated point
	 */
	public static Point mapPoint(Point point) {
		return point;
	}

	/**
	 * Catches updates from model
	 */
	@Override
	public void update(Observable model, Object info) {
		refresh();
	}
}