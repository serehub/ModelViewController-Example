
import java.awt.Cursor;
import java.awt.Font;
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
public class FontSizeComboBox extends JComboBox implements ActionListener {
	protected JPanel drawingPanel;
	protected View view;
	//private MouseHandler mouseHandler;
	private FontCommand fontCommand;
	private static GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	static String[] fonts = {"8","10","12","14","16","18","20"};
	Font font;
	private String selectedFont;
	/**
	 * Creates the button
	 * 
	 * @param jFrame
	 *            frame where the button lives
	 * @param jPanel
	 *            the panel where the items are
	 */
	public FontSizeComboBox(View jFrame, JPanel jPanel) {
		super(fonts);
		addActionListener(this);
		view = jFrame;
		drawingPanel = jPanel;
		//selectedFont=fonts[0];
		/*selectedFont=fonts[10];
		font=new Font(selectedFont,12,12);
		fontCommand = new FontCommand(font);*/
		//for(int i=0;i<fonts.length;i++)
		
		//font=new Font(selectedFont,12,12);
			
	}
	
	

	/**
	 * Handles the click by listening to mouse clicks
	 * 
	 * @param event
	 *            the click event
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		int index=super.getSelectedIndex();
		//selectedFont=event.getActionCommand();  
		//selectedFont=fonts[index];
		//fontCommand = new FontCommand(new Fonts(font));
		//drawingPanel.addMouseListener(mouseHandler = new MouseHandler());
		font=new Font(selectedFont,12,12);
		//fontCommand.setFont(font);
		System.out.println(selectedFont);
		
	}
	
	public String getSelectedFont(){
		return this.selectedFont;
	}
	public Font getSelectedFonts(){
		System.out.println(font.toString());
		return  font;
		
	}

	/**
	 * Handles mouse clicks for selecting items
	 *
	 */
/*	private class MouseHandler extends MouseAdapter {
		/**
		 * Handles the clicks
		 * 
		 * @param event
		 *            the click event
		 */
		//@Override
		/*public void mouseClicked(MouseEvent event) {
			
			view.setCursor(new Cursor(Cursor.TEXT_CURSOR));
			if (fontCommand != null) {
				UndoManager.instance().endCommand(fontCommand);
			}
			fontCommand = new FontCommand(new Fonts(font));
			UndoManager.instance().beginCommand(fontCommand);
			//drawingPanel.addFocusListener(keyHandler);
			drawingPanel.requestFocusInWindow();
			//drawingPanel.addKeyListener(keyHandler);
			drawingPanel.removeMouseListener(this);
			UndoManager.instance().endCommand(fontCommand);
		}
	}*/
}

