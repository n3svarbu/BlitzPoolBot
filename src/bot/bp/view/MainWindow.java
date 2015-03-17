package bot.bp.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javafx.beans.Observable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import bot.bp.data.IData;
import bot.bp.data.IReadOnlyData;
import javax.swing.SwingConstants;
import java.awt.Color;

public class MainWindow extends JFrame implements IView
{
	private static final long serialVersionUID = 3134541786393884636L;
	
	private BallsPanel ballsPanel;
	private StatsPanel statsPanel;
	
	private IReadOnlyData data;

	public MainWindow()
	{
		super("Blitz Pool Bot");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
		catch (ClassNotFoundException | InstantiationException
			| IllegalAccessException | UnsupportedLookAndFeelException e)
		{ e.printStackTrace(); }
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
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

		JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.VERTICAL;
		gbc_separator.gridx = 1;
		gbc_separator.gridy = 0;
		gbc_separator.gridheight = 1;
		getContentPane().add(separator, gbc_separator);
		
		// -----
		
		statsPanel = new StatsPanel(this);
		GridBagConstraints gbc_statsPanel = new GridBagConstraints();
		gbc_statsPanel.insets = new Insets(0, 0, 0, 0);
		gbc_statsPanel.fill = GridBagConstraints.BOTH;
		gbc_statsPanel.gridx = 2;
		gbc_statsPanel.gridy = 0;
		getContentPane().add(statsPanel, gbc_statsPanel);
		
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
