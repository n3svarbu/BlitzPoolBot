package bot.bp.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.beans.InvalidationListener;

import javax.swing.Timer;

import bot.bp.ball.Ball;
import bot.bp.ball.IBall;
import bot.bp.data.Ball8;
import bot.bp.data.Data;
import bot.bp.data.IData;
import bot.bp.memory.MemoryAccess;
import bot.bp.memory.ProcessFinder;

import com.sun.jna.Memory;

public class Model implements IModel 
{
	private IData data;
	private MemoryAccess ma;
	
	public Model()
	{
		data = new Data();
		data.setWindowsEnumList(ProcessFinder.getAllWindowNames("BlitzPool "));
		ma = new MemoryAccess("BlitzPool");
		
		initBalls();
		Memory ret = ma.readMemory(0x007BB35C, 4);
		System.out.println(ret.getFloat(0));
		
		new Timer(33, new ActionListener() { public void actionPerformed(ActionEvent e) { loop(); }; }).start();
	}
	
	@Override
	public void addObserver(InvalidationListener observer)
	{
		data.addListener(observer);
		data.update();
	}
	
	private void initBalls()
	{
		data.clearBalls();
		for (Ball8 b : Ball8.values())
		{
			IBall ball = new Ball(b.number(), b.type());
			int address = b.posAddress();
			ball.setPos(ma.readMemory(address, 4).getFloat(0), ma.readMemory(address + 4, 4).getFloat(0));
			ball.setColor(b.getColor());
			data.addBall(ball);
		}
	}
	
	private void loop()
	{
		for (Ball8 b : Ball8.values())
		{
			int address = b.posAddress();
			data.setBallPos(b.number(), ma.readMemory(address, 4).getFloat(0), ma.readMemory(address + 4, 4).getFloat(0));
		}
		data.update();
	}
}
