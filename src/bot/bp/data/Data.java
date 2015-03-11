package bot.bp.data;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.InvalidationListener;
import bot.bp.ball.IBall;

public class Data implements IData
{
	private InvalidationListener listener;
	private List<String> windowsNames;
	private List<IBall> balls;
	
	public Data()
	{
		balls = new ArrayList<IBall>();
	}
	
	public void setWindowsEnumList(List<String> list)
	{
		if (list == null)
			throw new NullPointerException();
		
		windowsNames = list;
	}
	
	public List<String> getWindowsNames()
	{
		return windowsNames;
	}
	
	public void addListener(InvalidationListener listener)
	{
		if (this.listener == null)
			this.listener = listener;
		else System.out.println(this + ": Listener already exists");
	}

	public void removeListener(InvalidationListener listener)
	{
		if (this.listener.equals(listener))
			listener = null;
	}
	
	public void update()
	{
		if (listener != null)
			listener.invalidated(this);
	}

	public void clearBalls()
	{
		balls.clear();
	}
	
	public void addBall(IBall ball)
	{
		if (ball == null)
			throw new NullPointerException();
		
		balls.add(ball);
	}
	
	public IBall getBall(int number)
	{
		IBall ball = getTrueBall(number);
		if (ball != null)
			return ball.clone();
		return ball;
	}
	
	private IBall getTrueBall(int number)
	{
		for (IBall b : balls)
			if (b.getNumber() == number)
				return b;
		
		return null;
	}
	
	public void setBallPos(int number, float x, float y)
	{
		IBall ball = getTrueBall(number);
		if (ball != null)
			ball.setPos(x, y);
	}
}
