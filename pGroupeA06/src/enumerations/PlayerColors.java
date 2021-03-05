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
		this.color=1;
	}
	
	public static PlayerColors getColor(int i) {
		for (PlayerColors p : PlayerColors.values()) {
	        if (p.color==i) {
	            return p;
	        }
	    }
		return null;
	}
}
