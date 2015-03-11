package bot.bp.memory;

import com.sun.jna.Memory;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinNT.HANDLE;
import com.sun.jna.ptr.IntByReference;

public class MemoryAccess
{
	private static final User32 user32 = User32.INSTANCE;
	private static final K32 kernel32 = K32.INSTANCE;
	private static final int readRight = 0x0010;  
    private static final int writeRight = 0x0020;
	
	private HANDLE readprocess;
	private HANDLE writeprocess;
	
	public MemoryAccess(String windowName)
	{
		int pid = ProcessFinder.getProcessId(windowName);
		System.out.println("Creating MemoryAccess for process number " + pid);
		readprocess = ProcessFinder.openProcess(readRight, pid);
		writeprocess = ProcessFinder.openProcess(writeRight, pid);
	}
	
	public MemoryAccess()
	{
		
	}
	
//	public static int writeMemory(HANDLE process, int address, short[] data)
//	{
//		IntByReference written = new IntByReference(0);
//		Memory toWrite = new Memory(data.length);
//		for (long i = 0; i < data.length; i++)
//			toWrite.setShort(0, data[new Integer(Long.toString(i))]);
//		
//		boolean b = kernel32.WriteFile(process, address, toWrite,
//				data.length, written);
//		System.out.println("kernel32.WriteProcessMemory : " + b); // Retorna
//																	// false
//		return written.getValue();
//	}

	public Memory readMemory(int address, int bytesToRead)
	{
		IntByReference read = new IntByReference(0);
		Memory output = new Memory(bytesToRead);
		kernel32.ReadProcessMemory(readprocess.getPointer(), address, output, bytesToRead, read);
		return output;
	}
}
