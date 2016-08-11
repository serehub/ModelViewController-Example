/**
Course:      ICS 372 
Semester:    Spring 2015
Instructor:  Brahma Dathan
Student:     Seretseab Kenaw
	 Project #3:  
Due date:    April 29, 2015
*/
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

/**
 * Implements a line; stores the end points.
 *
 */
public class Boldface extends JPanel  {
	//protected static Font font;
	private Label label;
	private boolean isChecked;
	public Boldface(Label label){
		
		this.label=label;
	}
	public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setFont(new Font(g.getFont().getFontName(),Font.BOLD,g.getFont().getSize()));
        //g.setColor(Color.black);
        System.out.println("yes");
        
    }
	
}
	