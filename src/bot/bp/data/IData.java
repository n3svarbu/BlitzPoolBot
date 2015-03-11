package bot.bp.data;

import java.util.List;

import bot.bp.ball.IBall;

public interface IData extends IReadOnlyData
{
	public void update();
	public void clearBalls();
	
	public void setWindowsEnumList(List<String> list);
	public void addBall(IBall ball);
	public void setBallPos(int number, float x, float y);
}
