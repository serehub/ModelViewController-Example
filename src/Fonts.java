
/**
 * 
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
import java.awt.Point;

/**
 * Implements a line; stores the end points.
 *
 */
public class Fonts extends Item {
	private static final long serialVersionUID = 1L;
	protected Label text;

	/**
	 * Creates a Font object with the starting point determined.
	 * 
	 * @param point
	 *            the start of the Font
	 */
	public Fonts(Label label) {
		text = label;
	}

	/**
	 * Adds one more character to the Font
	 * 
	 * @param character
	 *            a new character in the Font
	 */
	public void addCharacter(Label character) {
		text = character;
	}

	/**
	 * Displays the Font
	 */
	@Override
	public void render() {
		uiContext.draw(this);
	}

	/**
	 * Returns the actual text in the Font
	 * -
	 * @return the text in the Font
	 */
	public Label getText() {
		return text;
	}

	@Override
	public boolean includes(Point point) {
		// TODO Auto-generated method stub
		return false;
	}


}
