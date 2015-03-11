package bot.bp.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class BallsPanel extends JPanel
{
	private static final long serialVersionUID = 632898029213027310L;
	
	private List<BallInfoPanel> balls;
	
	BallsPanel(IView parent)
	{
		balls = new ArrayList<BallInfoPanel>();
		
		GridBagLayout gbl_ballsPanel = new GridBagLayout();
		gbl_ballsPanel.columnWidths = new int[]{0, 0, 0};
		gbl_ballsPanel.rowHeights = new int[]{1, 0, 1, 0, 0, 0, 0, 0, 0, 0};
		gbl_ballsPanel.columnWeights = new double[]{1.0, 1.0, 1.0};
		gbl_ballsPanel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		setLayout(gbl_ballsPanel);
//		setLayout(new GridBagLayout());
		
		// white
		BallInfoPanel ball = new BallInfoPanel(parent, 0);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(ball, gbc);
		
		// black
		ball = new BallInfoPanel(parent, 8);
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.add(ball, gbc);
		
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
