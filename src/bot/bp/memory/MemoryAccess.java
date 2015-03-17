package bot.bp.memory;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.LPARAM;
import com.sun.jna.platform.win32.WinDef.WPARAM;
import com.sun.jna.platform.win32.WinNT.HANDLE;
import com.sun.jna.ptr.IntByReference;

public class MemoryAccess
{
	private static final User32 user32 = User32.INSTANCE;
	private static final K32 kernel32 = K32.INSTANCE;
	private static final int readRight = 0x0010;  
    private static final int writeRight = 0x0020 | 0x0008;
	
	private HANDLE readprocess;
	private HANDLE writeprocess;
	
	private HWND window;
	private HWND table;
	
	public MemoryAccess(String windowName)
	{
		window = ProcessFinder.getProcess(windowName);
		table = ProcessFinder.getProcess(windowName + " [practice]");
		int pid = ProcessFinder.getProcessId(window);
		System.out.println("Creating MemoryAccess for process number " + pid);
		readprocess = ProcessFinder.openProcess(readRight, pid);
		writeprocess = ProcessFinder.openProcess(writeRight, pid);
	}
	
	public MemoryAccess()
	{
		
	}
	
	public int writeMemory(int address, byte data)
	{
		Memory toWrite = new Memory(Byte.BYTES);
		toWrite.setByte(0, data);
		return write(toWrite, address);
	}
	
	public int writeMemory(int address, int data)
	{
		Memory toWrite = new Memory(Integer.BYTES);
		toWrite.setInt(0, data);
		return write(toWrite, address);
	}
	
	private int write(Memory mem, int address)
	{
		IntByReference written = new IntByReference(0);
		boolean b = kernel32.WriteProcessMemory(writeprocess.getPointer(), address, mem, (int)mem.size(), written);
		System.out.println("kernel32.WriteProcessMemory : " + b + " : " + kernel32.GetLastError());
		System.out.println(kernel32.VirtualLock(address, (int)mem.size()));
		return written.getValue();
	}

	public Memory readMemory(int address, int bytesToRead)
	{
		IntByReference read = new IntByReference(0);
		Memory output = new Memory(bytesToRead);
		kernel32.ReadProcessMemory(readprocess.getPointer(), address, output, bytesToRead, read);
		return output;
	}
	
	public void sendMouseClick(boolean down)
	{
		WPARAM wparam = new WPARAM(1);
		LPARAM lparam = new LPARAM((10L) | ( (10L) << 16 ));
//		IntByReference read = new IntByReference(0);
//		Memory pointer = new Memory(4);
//		kernel32.ReadProcessMemory(readprocess.getPointer(), 0x00788558, pointer, 4, read);
		// 0x00788558
//		System.out.println(user32.GetWindowThreadProcessId(table, null) + " :) " + user32.GetWindowThreadProcessId(new HWND(pointer), null));
//		System.out.println(table + " :( " + new HWND(pointer));
		user32.PostMessage(table, down ? 0X0201 : 0x0202, wparam, lparam);
		System.out.println("user32.PostMessage : " + kernel32.GetLastError());
	}
}
