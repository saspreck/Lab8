
public class GamePieceAppearance {
	
	private Color color;
	
	private Shape shape;
	
	/**
	 * Constructor to make a new GamePieceAppearance object
	 * @param color
	 * @param shape
	 */
	public GamePieceAppearance(Color color, Shape shape) {
		this.color = color;
		this.shape = shape;
	}

	/**
	 * Method to get the color of the GamePiece
	 * @return color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Method to get the shape of the GamePiece
	 * @return shape
	 */
	public Shape getShape() {
		return shape;
	}
}
