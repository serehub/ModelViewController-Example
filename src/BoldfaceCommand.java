/**
Course:      ICS 372 
Semester:    Spring 2015
Instructor:  Brahma Dathan
Student:     Seretseab Kenaw
	  
	 Project #3:  
Due date:    April 29, 2015
*/
import java.awt.Point;

/**
 * Implements the Label command, so label creations can be undone.
 *
 */
public class BoldfaceCommand  {
	private boolean isChecked;
	BoldfaceCommand(){
		isChecked=false;
	}
	
	public boolean setIsCheckedTrue(){
		isChecked=true;
		return isChecked;
	}
	public boolean getIsChecked(){
		return isChecked;
	}
	
}
