package bot.bp.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import bot.bp.ball.BallType;
import bot.bp.ball.IBall;
import bot.bp.data.IReadOnlyData;
import bot.bp.util.FloatPoint;

public class BallInfoPanel extends JPanel
{
	private static final long serialVersionUID = 8468606728452366004L;
	
	private IView parent;
	private int number;
	
	private static final int indicatorSize = 12;
	private static final int halfIndicatorSize = (int) (indicatorSize * 0.5);
	private static final int ballSize = 26;
	private static final int halfBallSize = (int) (ballSize * 0.5);
	private static final int ballXOffset = indicatorSize + 20;
	
	BallInfoPanel(IView parent, int ballNumber)
	{
		this.parent = parent;
		this.number = ballNumber;
		setBackground(Color.RED);
		setPreferredSize(new Dimension(110,35));
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = ((Graphics2D) g);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setFont(IView.font);
		IReadOnlyData data = parent.getData();
		IBall ball = data.getBall(number);
		
		// draw indicator
		if (ball.isOnTable())
			g.setColor(new Color(0, 200, 0));
		else g.setColor(new Color(200, 0, 0));
		g.fillOval(10, this.getHeight() / 2 - halfIndicatorSize, indicatorSize, indicatorSize);
		// --------------
		
		drawBall(g2, ball);
		
		g.setColor(Color.BLACK);
		FloatPoint p = ball.getPos();
		g.drawString(String.format("x: %.2f", p.x), ballXOffset + ballSize + 10, 12);
		g.drawString(String.format("y: %.2f", p.y), ballXOffset + ballSize + 10, 24);
	}
	
	private void drawBall(Graphics2D g, IBall b)
	{
		Color color = g.getColor();
		int ballYOffset = this.getHeight() / 2 - halfBallSize;
		
		g.setColor(b.getColor());
		g.setPaint(new RadialGradientPaint(ballXOffset + 10, ballYOffset + 5,ballSize,new float[]{0f, 0.5f, 1f},new Color[]{Color.WHITE, b.getColor(), Color.BLACK}));
		g.fillOval(ballXOffset, ballYOffset, ballSize, ballSize);
		
		g.setColor(Color.WHITE);
		if (b.getType() == BallType.STRIPED)
			g.fillRoundRect(ballXOffset, ballYOffset + halfBallSize - halfIndicatorSize, ballSize, indicatorSize, halfIndicatorSize, halfIndicatorSize);
		else g.fillOval(ballXOffset + halfBallSize - halfIndicatorSize, ballYOffset + halfBallSize - halfIndicatorSize, indicatorSize, indicatorSize);
		
		g.setColor(Color.BLACK);
		g.drawOval(ballXOffset, ballYOffset, ballSize, ballSize);
		String str = b.getNumber() + "";
		int strW = g.getFontMetrics(IView.font).stringWidth(str);
		if (b.getType() != BallType.WHITE)
			g.drawString(str, ballXOffset + halfBallSize - strW / 2, ballYOffset + halfBallSize + IView.font.getSize() / 3);
		g.setColor(color);
	}
}
