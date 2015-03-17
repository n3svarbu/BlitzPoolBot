package bot.bp.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.beans.InvalidationListener;

import javax.swing.Timer;

import bot.bp.ball.Ball;
import bot.bp.ball.IBall;
import bot.bp.data.Addresses;
import bot.bp.data.Ball8;
import bot.bp.data.Data;
import bot.bp.data.IData;
import bot.bp.memory.Address;
import bot.bp.memory.MemoryAccess;
import bot.bp.memory.ProcessFinder;

import com.sun.jna.Memory;

public class Model implements IModel 
{
	private IData data;
	private MemoryAccess ma;
	private Table table;
	
	public Model()
	{
		data = new Data();
		data.setWindowsEnumList(ProcessFinder.getAllWindowNames("BlitzPool "));
		ma = new MemoryAccess("BlitzPool");
		table = new Table(data, ma);
		
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
		Address.setAutoInit(ma);
		System.out.println(ma.readMemory(Addresses.POWER.getAddress(), 4).toString());
		for (Ball8 b : Ball8.values())
		{
			IBall ball = new Ball(b.number(), b.type());
			int address = b.posAddress();
			ball.setPos(ma.readMemory(address, 4).getFloat(0), ma.readMemory(address + 4, 4).getFloat(0));
			ball.setColor(b.getColor());
			data.addBall(ball);
		}
		
//		ma.writeMemory(Addresses.POINT_X.getAddress(), 500);
//		ma.writeMemory(Addresses.POINT_Y.getAddress(), 200);
		table.togglePowerIncrease();
	}
	
	private void loop()
	{
		//ma.writeMemory(Addresses.CLICK.getAddress(), 0);
		for (Ball8 b : Ball8.values())
		{
			int address = b.posAddress();
			data.setBallPos(b.number(), ma.readMemory(address, 4).getFloat(0), ma.readMemory(address + 4, 4).getFloat(0));
		}
		data.setTurn(ma.readMemory(Addresses.TURN.getAddress(), 4).getInt(0));
		data.setPower(ma.readMemory(Addresses.POWER.getAddress(), 4).getInt(0));
	//	ma.writeMemory(Addresses.POWER.getAddress(), 100);
	//	ma.writeMemory(Addresses.CLICK.getAddress(), 1);
		data.update();
		table.update();
	}
}
