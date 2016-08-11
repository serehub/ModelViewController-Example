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
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * A UI that uses the swing package
 *
 */
public class NewSwingUI implements UIContext {
	protected Graphics graphics;
	private static NewSwingUI swingUI;
	//private BoldfaceCheckBox boldfaceCB;
	protected LabelOperation operation;
	protected boolean boldSelected=false;
	private JPanel p;
	/**
	 * For the singleton pattern
	 */
	private NewSwingUI() {
	}

	/**
	 * Returns the instance
	 * 
	 * @return the instance
	 */
	public static NewSwingUI getInstance() {
		if (swingUI == null) {
			swingUI = new NewSwingUI();
		}
		return swingUI;
	}

	/**
	 * The Graphics object for drawing
	 * 
	 * @param graphics
	 *            the Graphics object
	 */
	public void setGraphics(Graphics graphics) {
		this.graphics = graphics;
	}

	/**
	 * Draws a label
	 * 
	 * @param label
	 *            the label
	 */
	@Override
	public void draw(Label label) {
		
		if (label.getStartingPoint() != null) {
			if (label.getText() != null) {
				
				if(boldSelected==true){
					p=new Boldface(label);
					
					
					graphics.setColor(Color.red);
				}
				
				
				graphics.drawString(label.getText(), (int) label
						.getStartingPoint().getX(), (int) label
						.getStartingPoint().getY());
			}
		}
		
		int length = graphics.getFontMetrics().stringWidth(label.getText());
		graphics.drawString("_",
				(int) label.getStartingPoint().getX() + length, (int) label
						.getStartingPoint().getY());
	}
	/**
	 * Draws a label
	 * 
	 * @param label
	 *            the label
	 */
	
	/**
	 * Draws a polygon
	 * 
	 * @param polygon
	 *            the polygon to be drawn
	 */
	@Override
	public void draw(Polygon polygon) {
		ArrayList<Point> vertices = polygon.getVertices();
		if(vertices!=null&&vertices.size()>0)
		{
			int nPoints=vertices.size();
			int []xPoints= new int[nPoints];
			int []yPoints= new int[nPoints];
			for(int i= 0; i<nPoints;i++)
			{
				xPoints[i]= vertices.get(i).x;
				yPoints[i]= vertices.get(i).y;
			}			
			graphics.drawPolygon(xPoints, yPoints, nPoints);
		}
	}
	/**
	 * Draws a line
	 * 
	 * @param line
	 *            the line to be drawn
	 */
	@Override
	public void draw(Line line) {
		int i1 = 0;
		int i2 = 0;
		int i3 = 0;
		int i4 = 0;
		if (line.getPoint1() != null) {
			i1 = Math.round((float) (line.getPoint1().getX()));
			i2 = Math.round((float) (line.getPoint1().getY()));
			if (line.getPoint2() != null) {
				i3 = Math.round((float) (line.getPoint2().getX()));
				i4 = Math.round((float) (line.getPoint2().getY()));
			} else {
				i3 = i1;
				i4 = i2;
			}
			graphics.drawLine(i1, i2, i3, i4);
		}
	}
	/**
	 * Draws an image
	 * 
	 * @param image
	 *            the image to be drawn
	 */
	@Override
	public void draw(Image image) {
		java.awt.Image drawImage;
		int x1,y1,x2,y2;
		BufferedImage img= image.getImage();
		if (img != null) {
            drawImage = img.getScaledInstance( -1, - 1, BufferedImage.SCALE_DEFAULT);
            x1=image.getPoint1().x;
            y1=image.getPoint1().y;
            x2=image.getPoint2().x;
            y2=image.getPoint2().y;
            graphics.drawImage(drawImage,x1,y1,x2-x1,y2-y1, null);
        }
	}
	/**
	 * Captures undefined items
	 * 
	 * @param item
	 *            the item
	 */
	@Override
	public void draw(Item item) {
		System.out.println("Cant draw unknown Item \n");
	}

	@Override
	public void bold(Graphics g) {
		// TODO Auto-generated method stub
		// bld = null;
		if(boldSelected==true)
			//p=new Boldface();
		    p.paintComponents(g);
		    p.repaint();
		//g.getFont().deriveFont(Font.BOLD);
	}

	@Override
	public void underline(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void italicize(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}