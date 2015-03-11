package bot.bp.data;

import java.awt.Color;

import bot.bp.ball.BallType;

public enum Ball8
{
	
	WHITE
	{
		public int posAddress() { return 0x007BB35C; }
		public int number() { return 0; }
		public BallType type() { return BallType.WHITE; }
		public Color getColor() { return Color.WHITE; }
	},
	SOLID_YELLOW
	{
		public int posAddress() { return 0x007BB794; }
		public int number() { return 1; }
		public BallType type() { return BallType.SOLID; }
		public Color getColor() { return Color.YELLOW; }
	},
	SOLID_BLUE
	{
		public int posAddress() { return 0x007BB59C; }
		public int number() { return 2; }
		public BallType type() { return BallType.SOLID; }
		public Color getColor() { return Color.BLUE; }
	},
	SOLID_RED
	{
		public int posAddress() { return 0x007BB434; }
		public int number() { return 3; }
		public BallType type() { return BallType.SOLID; }
		public Color getColor() { return Color.RED; }
	},
	SOLID_PURPLE
	{
		public int posAddress() { return 0x007BB4C4; }
		public int number() { return 4; }
		public BallType type() { return BallType.SOLID; }
		public Color getColor() { return new Color(200, 0, 200); }
	},
	SOLID_ORANGE
	{
		public int posAddress() { return 0x007BB6BC; }
		public int number() { return 5; }
		public BallType type() { return BallType.SOLID; }
		public Color getColor() { return Color.ORANGE; }
	},
	SOLID_GREEN
	{
		public int posAddress() { return 0x007BB3A4; }
		public int number() { return 6; }
		public BallType type() { return BallType.SOLID; }
		public Color getColor() { return Color.GREEN; }
	},
	SOLID_BORDO
	{
		public int posAddress() { return 0x007BB50C; }
		public int number() { return 7; }
		public BallType type() { return BallType.SOLID; }
		public Color getColor() { return new Color(155, 0, 0); }
	},
	BLACK
	{
		public int posAddress() { return 0x007BB674; }
		public int number() { return 8; }
		public BallType type() { return BallType.BLACK; }
		public Color getColor() { return Color.BLACK; }
	},
	STRIPES_YELLOW
	{
		public int posAddress() { return 0x007BB74C; }
		public int number() { return 9; }
		public BallType type() { return BallType.STRIPED; }
		public Color getColor() { return Color.YELLOW; }
	},
	STRIPES_BLUE
	{
		public int posAddress() { return 0x007BB47C; }
		public int number() { return 10; }
		public BallType type() { return BallType.STRIPED; }
		public Color getColor() { return Color.BLUE; }
	},
	STRIPES_RED
	{
		public int posAddress() { return 0x007BB3EC; }
		public int number() { return 11; }
		public BallType type() { return BallType.STRIPED; }
		public Color getColor() { return Color.RED; }
	},
	STRIPES_PURPLE
	{
		public int posAddress() { return 0x007BB554; }
		public int number() { return 12; }
		public BallType type() { return BallType.STRIPED; }
		public Color getColor() { return new Color(200, 0, 200); }
	},
	STRIPES_ORANGE
	{
		public int posAddress() { return 0x007BB704; }
		public int number() { return 13; }
		public BallType type() { return BallType.STRIPED; }
		public Color getColor() { return Color.ORANGE; }
	},
	STRIPES_GREEN
	{
		public int posAddress() { return 0x007BB62C; }
		public int number() { return 14; }
		public BallType type() { return BallType.STRIPED; }
		public Color getColor() { return Color.GREEN; }
	},
	STRIPES_BORDO
	{
		public int posAddress() { return 0x007BB5E4; }
		public int number() { return 15; }
		public BallType type() { return BallType.STRIPED; }
		public Color getColor() { return new Color(155, 0, 0); }
	};
	
	public abstract int posAddress();
	public abstract int number();
	public abstract BallType type();
	public abstract Color getColor();
}
