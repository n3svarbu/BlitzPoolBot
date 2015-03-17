package bot.bp.view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import bot.bp.data.IReadOnlyData;

public class StatsPanel extends JPanel
{
	private static final long serialVersionUID = 5747726128328285581L;
	
	private IView parent;
	
	private JLabel turn;
	private JLabel power;
	
	public StatsPanel(IView parent)
	{
		this.parent = parent;
		
		GridBagLayout gbl_statsPanel = new GridBagLayout();
		gbl_statsPanel.columnWidths = new int[]{0, 0};
		gbl_statsPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_statsPanel.columnWeights = new double[]{1.0, 1.0};
		gbl_statsPanel.rowWeights = new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 1.0};
		setLayout(gbl_statsPanel);
		
		// label
		JLabel label = new JLabel("Stats");
		label.setFont(IView.font.deriveFont(20f).deriveFont(Font.BOLD));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 20, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(label, gbc);
		
		// table
		gbc.gridy++;
		JLabel table = new JLabel("Table: ");
		table.setFont(IView.font);
		gbc.insets = new Insets(0, 0, 0, 0);
		this.add(table, gbc);
		
		// ball type
		gbc.gridy++;
		JLabel bType = new JLabel("Ball type: ");
		bType.setFont(IView.font);
		this.add(bType, gbc);
		
		// turn
		gbc.gridy++;
		turn = new JLabel("Turn: ");
		turn.setFont(IView.font);
		this.add(turn, gbc);

		// deadTimer
		gbc.gridy++;
		JLabel deadTimer = new JLabel("Dead timer: ");
		deadTimer.setFont(IView.font);
		this.add(deadTimer, gbc);
				
		// Last ball hit
		gbc.gridy++;
		JLabel lastBHit = new JLabel("Last ball hit: ");
		lastBHit.setFont(IView.font);
		this.add(lastBHit, gbc);
				
		// power
		gbc.gridy++;
		power = new JLabel("Power: ");
		power.setFont(IView.font);
		this.add(power, gbc);
		
		// point coord
		gbc.gridy++;
		JLabel pointer = new JLabel("Pointer: ");
		pointer.setFont(IView.font);
		this.add(pointer, gbc);
		
		// fitness
		gbc.gridy++;
		JLabel fitness = new JLabel("Fitness: ");
		fitness.setFont(IView.font);
		this.add(fitness, gbc);
	}
	
	public void paintComponent(Graphics g)
	{
		IReadOnlyData data = parent.getData();
		turn.setText("Turn: " + data.getTurn());
		power.setText("Power: " + data.getPower());
	}
}
