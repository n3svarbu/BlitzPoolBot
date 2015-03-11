package bot.bp.view;

import java.awt.Font;

import javafx.beans.InvalidationListener;
import bot.bp.data.IReadOnlyData;


public interface IView extends InvalidationListener
{
	public static final Font font = new Font("Calibri", Font.PLAIN, 10);
	public IReadOnlyData getData();
}
