
public enum Color {
	RED(255,0,0), GREEN(0,255,0), BLUE(0,0,255), YELLOW(255,255,0), CYAN(0,255,255), MAGENTA(255,0,255);
	
	private int r;
	private int g;
	private int b;
	
	/**
	 * Constructor for a color object that takes three values, one for red, one for green, and one for blue
	 * @param r
	 * @param g
	 * @param b
	 */
	private Color(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}

	/**
	 * Method to get the red value of a color
	 * @return r
	 */
	public int getR() {
		return r;
	}

	/**
	 * Method to get the green value of a color
	 * @return g
	 */
	public int getG() {
		return g;
	}

	/**
	 * Method to get the blue value of a color
	 * @return b
	 */
	public int getB() {
		return b;
	}
}


