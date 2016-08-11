

import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 * Creates a button for selecting items.
 *
 */
public class FontComboBox extends JComboBox implements ActionListener {
	protected JPanel drawingPanel;
	protected View view;
	private MouseHandler mouseHandler;
	private FontCommand fontCommand;
	private static GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	private static String[] fonts = ge.getAvailableFontFamilyNames();

	/**
	 * Creates the button
	 * 
	 * @param jFrame
	 *            frame where the button lives
	 * @param jPanel
	 *            the panel where the items are
	 */
	public FontComboBox(View jFrame, JPanel jPanel) {
		super(fonts);
		addActionListener(this);
		view = jFrame;
		drawingPanel = jPanel;
	}

	/**
	 * Handles the click by listening to mouse clicks
	 * 
	 * @param event
	 *            the click event
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		//fontCommand = new FontCommand(getFont());
		drawingPanel.addMouseListener(mouseHandler = new MouseHandler());
	}

	/**
	 * Handles mouse clicks for selecting items
	 *
	 */
	private class MouseHandler extends MouseAdapter {
		/**
		 * Handles the clicks
		 * 
		 * @param event
		 *            the click event
		 */
		@Override
		public void mouseClicked(MouseEvent event) {
			fontCommand.setFont();
			drawingPanel.removeMouseListener(this);
			UndoManager.instance().endCommand(fontCommand);
		}
	}
}
