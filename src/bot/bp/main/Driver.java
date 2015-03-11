package bot.bp.main;

import bot.bp.model.IModel;
import bot.bp.model.Model;
import bot.bp.view.IView;
import bot.bp.view.MainWindow;

public class Driver
{
	public static void main(String[] args)
	{
		IModel model = new Model();
		IView view = new MainWindow();
		Controller c = new Controller(model, view);
	}
}
