
public enum GamePiece {
	RED_RACER(new GamePieceAppearance(Color.RED, Shape.RACECAR), 0), BLUE_RACER(new GamePieceAppearance(Color.BLUE, Shape.RACECAR), 2), 
	MAGENTA_RACER(new GamePieceAppearance(Color.MAGENTA, Shape.RACECAR), 1), RED_THIMBLE(new GamePieceAppearance(Color.RED, Shape.THIMBLE), 10), 
	BLUE_BOOT(new GamePieceAppearance(Color.BLUE, Shape.BOOT), 5), GREEN_BOOT(new GamePieceAppearance(Color.GREEN, Shape.BOOT), 8), 
	YELLOW_BOOT(new GamePieceAppearance(Color.YELLOW, Shape.BOOT), 7);
	
	private GamePieceAppearance appearance;
	
	private int priority; 
	
	/**
	 * Constructor for a GamePiece object that takes the appearance of a game piece and its priority
	 * @param appearance
	 * @param priority
	 */
	private GamePiece(GamePieceAppearance appearance, int priority) {
		this.appearance = appearance;
		this.priority = priority;
	}
	
	/**
	 * Method to get the color of the game piece
	 * @return appearance.getColor()
	 */
	public Color getColor() {
		return appearance.getColor();
	}
	
	/**
	 * Method to get the shape of the game piece
	 * @return appearance.getShape()
	 */
	public Shape getShape() {
		return appearance.getShape();
	}
	
	/**
	 * Method to determine which game piece should move first given their priorities
	 * @param a
	 * @param b
	 * @return a or b, whichever has the lower priority
	 */
	public static GamePiece movesFirst(GamePiece a, GamePiece b) {
		if(a.priority < b.priority) {
			return a;
		}
		else {
			return b;
		}
	}
	
	/**
	 * Method to return the GamePiece object as a string
	 */
	public String toString() {
		return String.format("%s: a %s %s with priority %d", this.name(), this.getColor(), this.getShape(), priority);
	}

}
