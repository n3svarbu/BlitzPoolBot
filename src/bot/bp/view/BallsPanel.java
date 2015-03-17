package bot.bp.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class BallsPanel extends JPanel
{
	private static final long serialVersionUID = 632898029213027310L;
	
	private List<BallInfoPanel> balls;
	
	BallsPanel(IView parent)
	{
		balls = new ArrayList<BallInfoPanel>();
		
		GridBagLayout gbl_ballsPanel = new GridBagLayout();
		gbl_ballsPanel.columnWidths = new int[]{0, 0, 0};
		gbl_ballsPanel.rowHeights = new int[]{10, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_ballsPanel.columnWeights = new double[]{1.0, 1.0, 1.0};
		gbl_ballsPanel.rowWeights = new double[]{0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		setLayout(gbl_ballsPanel);
//		setLayout(new GridBagLayout());

		// label
		JLabel label = new JLabel("Balls");
		label.setFont(IView.font.deriveFont(20f).deriveFont(Font.BOLD));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 20, 0, 0);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(label, gbc);
		
		// white
		BallInfoPanel ball = new BallInfoPanel(parent, 0);
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(ball, gbc);
		
		// black
		ball = new BallInfoPanel(parent, 8);
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.add(ball, gbc);
		
		JSeparator sep = new JSeparator(JSeparator.HORIZONTAL);
		gbc.insets = new Insets(0, 10, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
//		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(sep, gbc);
		
		gbc.gridwidth = 1;
		gbc.insets = new Insets(0, 0, 0, 0);
		
		for (int i = 1; i < 16; i++)
		{
			if (i == 8) continue;
			ball = new BallInfoPanel(parent, i);
			gbc.gridx = i > 8 ? 1 : 0;
			gbc.gridy = 2 + (i % 8);
			this.add(ball, gbc);
		}
	}
}
