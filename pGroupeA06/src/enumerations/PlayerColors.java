package enumerations;

public enum PlayerColors {
	RED(0),
	GREEN(1),
	YELLOW(2),
	BLUE(3),
	PURPLE(4),
	PINK(5),
	ORANGE(6),
	DARKBLUE(7);

	private int color;
	
	PlayerColors(int i) {
		this.color=i;
	}
	
	public static PlayerColors getColor(int i) {
		for (PlayerColors p : values()) {
	        if (p.color==i) {
	            return p;
	        }
	    }
		System.out.println("pas trouvé");
		return null;
	}
	
	public static int getValue(PlayerColors p) {
		return p.color;
	}
	
}
