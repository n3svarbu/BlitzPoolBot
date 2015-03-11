package bot.bp.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bot.bp.model.IModel;
import bot.bp.view.IView;

public class Controller implements ActionListener
{
	private IModel model;
	
	Controller(IModel model, IView view)
	{
		this.model = model;
		model.addObserver(view);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
	}

}
