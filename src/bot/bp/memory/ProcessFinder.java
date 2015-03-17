package bot.bp.memory;

import java.util.ArrayList;
import java.util.List;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinNT.HANDLE;
import com.sun.jna.platform.win32.WinUser.WNDENUMPROC;
import com.sun.jna.ptr.IntByReference;

public class ProcessFinder
{
	private static final User32 user32 = User32.INSTANCE;
	private static final Kernel32 kernel32 = Kernel32.INSTANCE;
	
	public static List<String> getAllWindowNames(String name)
	{
		final List<String> windowNames = new ArrayList<String>();
		user32.EnumWindows(new WNDENUMPROC()
		{
			@Override
			public boolean callback(HWND hWnd, Pointer data)
			{
				char[] windowText = new char[512];
				user32.GetWindowText(hWnd, windowText, 512);
				String wText = Native.toString(windowText).trim();
				if (wText.contains(name)){
					windowNames.add(wText);
				}
				return true;
			}
		}, null);

		return windowNames;
	}
	
	public static HWND getProcess(String windowName)
    {  
        HWND window = user32.FindWindow(null, windowName);
        System.out.println(window);
        return window;  
    }
	
	public static int getProcessId(HWND window)
    {  
        IntByReference pid = new IntByReference();
        user32.GetWindowThreadProcessId(window, pid);  
        return pid.getValue();  
    }
	
	public static HANDLE openProcess(int permissions, int pid)
    {  
        HANDLE process = kernel32.OpenProcess(permissions, true, pid);  
        return process;  
    }
}
