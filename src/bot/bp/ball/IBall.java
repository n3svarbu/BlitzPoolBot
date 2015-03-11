package bot.bp.ball;

import java.awt.Color;

import bot.bp.util.FloatPoint;

public interface IBall
{
	public BallType getType();
	public int getNumber();
	public FloatPoint getPos();
	public boolean isOnTable();
	public Color getColor();
	
	public void setPos(float x, float y);
	public void setOnTable(boolean onTable);
	public void setColor(Color color);
	
	public IBall clone();
}
