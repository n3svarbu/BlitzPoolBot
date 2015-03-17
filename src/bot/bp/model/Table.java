package bot.bp.model;

import bot.bp.data.Addresses;
import bot.bp.data.IData;
import bot.bp.memory.MemoryAccess;

public class Table
{
	private boolean ready;
	
	private IData data;
	private MemoryAccess ma;
	
	int clickTime = 100;
	
	private boolean powINC;
	
	Table(IData data, MemoryAccess ma)
	{
		this.data = data;
		this.ma = ma;
		this.ready = false;
		this.powINC = true;
	}
	
	public boolean update()
	{
		// if table is opened
		if (1 == ma.readMemory(Addresses.ISTABLEOPEN.getAddress(), 1).getByte(0))
		{
			// if table is focused
			if (1 != ma.readMemory(Addresses.ISTABLEFOCUSED.getAddress(), 1).getByte(0))
				ma.writeMemory(Addresses.ISTABLEFOCUSED.getAddress(), (byte) 1);
			{
				if (1 == ma.readMemory(Addresses.ISBALLSTANDING.getAddress(), 1).getByte(0))
				{
					if (1 == ma.readMemory(Addresses.ISTABLEREADY.getAddress(), 1).getByte(0))
					{
//						if (1 == ma.readMemory(Addresses.CLICK.getAddress(), 1).getByte(0))
//						{
//							if (50 < data.getPower())
//								ma.sendMouseClick(false);
//						}
//						else if (clickTime < 0)
//						{
//							ma.sendMouseClick(true);
//							clickTime = 100;
//						}
//						clickTime--;
						ma.writeMemory(Addresses.POWER.getAddress(), 50);
						ma.sendMouseClick(true);
						ma.writeMemory(Addresses.POWER.getAddress(), 50);
						ma.sendMouseClick(false);
						ma.writeMemory(Addresses.POWER.getAddress(), 50);
//						ma.writeMemory(Addresses.CLICK.getAddress(), (byte) 1);
					}
				}
			}
			//ma.writeMemory(Addresses.POWER.getAddress(), 50);
		}
		return ready;
	}
	
	public boolean togglePowerIncrease()
	{
		// address = 0x0047DC05;
		// ON = 0x42;
		// OFF = 0x90;
		powINC = !powINC;
		ma.writeMemory(0x0047DC05, (byte) (powINC ? 0x42 : 0x90));
		return powINC;
	}
	
	/*
	 * inc edx -- BlitzPool.exe+7DC05 - 42                   

	 */
}
