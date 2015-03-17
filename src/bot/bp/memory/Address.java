package bot.bp.memory;


public class Address
{
	private int baseAddress;
	private int[] offsets;
	
	private int address;
	
	private boolean initialized;
	
	private static boolean autoInit = false;
	private static MemoryAccess ma;
	
	public static void setAutoInit(MemoryAccess ma)
	{
		autoInit = true;
		Address.ma = ma;
	}
	
	public Address(int baseAddress)
	{
		this.baseAddress = baseAddress;
		address = baseAddress;
		initialized = true;
	}
	
	public Address(int baseAddress, int[] offsets)
	{
		address = 0x0;
		this.baseAddress = baseAddress;
		this.offsets = offsets;
		initialized = false;
		if (Address.autoInit)
			init(Address.ma);
	}
	
	public void init(MemoryAccess ma)
	{
		initialized = true;
		address = baseAddress;
		for (int off : offsets)
			address = ma.readMemory(address, 4).getInt(0) + off;
	}
	
	public int getAddress() throws RuntimeException
	{
		if (!initialized)
			throw new RuntimeException("Not initialized");
		return address;
	}
	
	public int getBaseAddress()
	{
		return baseAddress;
	}
}
