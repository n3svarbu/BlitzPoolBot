package bot.bp.model;

import javafx.beans.InvalidationListener;

public interface IModel
{
	public void addObserver(InvalidationListener observer);
}
