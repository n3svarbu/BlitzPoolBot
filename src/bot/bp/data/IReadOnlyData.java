package bot.bp.data;

import java.util.List;

import javafx.beans.Observable;
import bot.bp.ball.IBall;

public interface IReadOnlyData extends Observable
{
	public List<String> getWindowsNames();
	public IBall getBall(int number);
	public int getTurn();
	public int getPower();
}
