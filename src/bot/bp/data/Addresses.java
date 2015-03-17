package bot.bp.data;

import bot.bp.memory.Address;

public class Addresses
{
	public static final Address TURN = new Address(0x007BC9F0, new int[]{ 0x524 });
	public static final Address POWER = new Address(0x007BC9F0, new int[]{ 0x388, 0x1B0 });
	public static final Address CLICK = new Address(0x007BC9F0, new int[]{ 0x4AC });
	public static final Address ISTABLEOPEN = new Address(0x007BC9F0, new int[]{ 0x1E2 });
	public static final Address ISTABLEFOCUSED = new Address(0x007BC9F0, new int[]{ 0x4B3 });
	public static final Address ISBALLSTANDING = new Address(0x007BC9F0, new int[]{ 0x4AE });
	public static final Address ISTABLEREADY = new Address(0x007BC9F0, new int[]{ 0x4B7 });
	
	public static final Address POINT_X = new Address(0x007BB030);
	public static final Address POINT_Y = new Address(0x007BB030);
	
	public static final int[] list =
	{
		// mouse					0
		0x007BAE1C,
		// power					1
		0x028D7850,
		
		// insert anything before balls and change the index!
		
		// ball white				2
		0x007BB35C,
		// ball 1 solid yellow		3
		0x007BB794,
		// ball 2 solid blue		4
		0x007BB59C,
		// ball 3 solid red			5
		0x007BB434,
		// ball 4 solid purple		6
		0x007BB4C4,
		// ball 5 solid orange		7
		0x007BB6BC,
		// ball 6 solid green		8
		0x007BB3A4,
		// ball 7 solid bordo		9
		0x007BB50C,
		// ball 8 solid black		10
		0x007BB674,
		// ball 9 stripes yellow	11
		0x007BB74C,
		// ball 10 stripes blue		12
		0x007BB47C,
		// ball 11 stripes red		13
		0x007BB3EC,
		// ball 12 stripes purple	14
		0x007BB554,
		// ball 13 stripes orange	15
		0x007BB704,
		// ball 14 stripes green	16
		0x007BB62C,
		// ball 15 stripes bordo	17
		0x007BB5E4
	};
}
