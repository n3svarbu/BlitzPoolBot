package bot.bp.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javafx.beans.Observable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import bot.bp.data.IData;
import bot.bp.data.IReadOnlyData;

public class MainWindow extends JFrame implements IView
{
	private static final long serialVersionUID = 3134541786393884636L;
	
	private BallsPanel ballsPanel;
	
	private IReadOnlyData data;

	public MainWindow()
	{
		super("Blitz Pool Bot");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		ballsPanel = new BallsPanel(this);
		GridBagConstraints gbc_ballsPanel = new GridBagConstraints();
		gbc_ballsPanel.insets = new Insets(0, 0, 0, 0);
		gbc_ballsPanel.fill = GridBagConstraints.BOTH;
		gbc_ballsPanel.gridx = 0;
		gbc_ballsPanel.gridy = 0;
		getContentPane().add(ballsPanel, gbc_ballsPanel);
		
		// -----
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		getContentPane().add(panel_1, gbc_panel_1);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridx = 2;
		gbc_separator.gridy = 1;
		getContentPane().add(separator, gbc_separator);
		
		pack();
		setVisible(true);
	}

	@Override
	public void invalidated(Observable o)
	{
		data = (IReadOnlyData) o;
		repaint();
	}
	
	public IReadOnlyData getData()
	{
		return data;
	}
}
