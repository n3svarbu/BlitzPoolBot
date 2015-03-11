package bot.bp.ball;

import java.awt.Color;

import bot.bp.util.FloatPoint;

public class Ball implements IBall
{
	private BallType type;
	
	private int number;
	
	private float x;
	private float y;
	
	private boolean onTable;
	
	private Color color;
	
	public Ball(int number, BallType type)
	{
		this.number = number;
		this.type = type;
		this.onTable = true;
		this.color = Color.WHITE;
	}
	
	@Override
	public BallType getType()
	{
		return type;
	}

	@Override
	public int getNumber()
	{
		return number;
	}

	@Override
	public FloatPoint getPos()
	{
		return new FloatPoint(x, y);
	}

	@Override
	public boolean isOnTable()
	{
		return onTable;
	}
	
	public Ball clone()
	{
		Ball clone = new Ball(number, type);
		clone.setOnTable(onTable);
		clone.setPos(x, y);
		clone.setColor(color);
		return clone;
	}

	@Override
	public void setPos(float x, float y)
	{
		this.x = x;
		this.y = y;
		onTable = x > 30 ? true : false;
	}

	@Override
	public void setOnTable(boolean onTable)
	{
		this.onTable = onTable;
	}
	
	public void setColor(Color color)
	{
		this.color = color;
	}
	
	public Color getColor()
	{
		return color;
	}

}
