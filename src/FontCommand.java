
import java.awt.Font;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.Map;

/**
 * Implements the Label command, so label creations can be undone.
 *
 */
public class FontCommand extends Command {
	private Fonts font;
	/**
	 * Creates the label
	 * 
	 * @param Font
	 *            starting Font
	 */
	public FontCommand(Fonts font2) {
		//font = new Font((Map<? extends Attribute, ?>) font2);
		this.font=font2;
	}


	/**
	 * Re-creates the label by supplying it to the model
	 */
	@Override
	public boolean redo() {
		execute();
		return true;
	}

	public void setFont() {
		Label.setUIContext((UIContext) font);
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean undo() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		model.addItem(font);
	}
}
