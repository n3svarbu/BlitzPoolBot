package bot.bp.memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.W32APIOptions;
// by deject3d  
public interface K32 extends Kernel32  
{  
	K32 INSTANCE = (K32) Native.loadLibrary("kernel32",
			K32.class, W32APIOptions.UNICODE_OPTIONS);
	
    // description from msdn  
    //BOOL WINAPI WriteProcessMemory(  
    //__in   HANDLE hProcess,  
    //__in   LPVOID lpBaseAddress,  
    //__in   LPCVOID lpBuffer,  
    //__in   SIZE_T nSize,  
    //__out  SIZE_T *lpNumberOfBytesWritten  
    //);  
    boolean WriteProcessMemory(Pointer p, int address, Pointer buffer, int size, IntByReference written);  
     
     
    //BOOL WINAPI ReadProcessMemory(  
    //          __in   HANDLE hProcess,  
    //          __in   LPCVOID lpBaseAddress,  
    //          __out  LPVOID lpBuffer,  
    //          __in   SIZE_T nSize,  
    //          __out  SIZE_T *lpNumberOfBytesRead  
    //        );  
    boolean ReadProcessMemory(Pointer hProcess, int inBaseAddress, Pointer outputBuffer, int nSize, IntByReference outNumberOfBytesRead);
    
    //BOOL WINAPI VirtualLock(
    //		  _In_  LPVOID lpAddress,
    // 		  _In_  SIZE_T dwSize
    // 		);
    boolean VirtualLock(int address, int size);
    
    //BOOL WINAPI VirtualUnlock(
    //		  _In_  LPVOID lpAddress,
    // 		  _In_  SIZE_T dwSize
    // 		);
    boolean VirtualUnlock(int address, int size);
}  