package model;

/**
 * An object representing a position in a 2D plane
 * @author Damien
 * */
public class Position {
	
	/**
	 * The x coordinate
	 */
	private double x;
	
	/**
	 * The y coordinate
	 */
	private double y;

	/**
	 * Constructor
	 * @param x	The x coordinate
	 * @param y	The y coordinate
	 * */
	public Position(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * returns x coordinate
	 * @return the x coordinate
	 * */
	public double getX() {
		return x;
	}
	
	/**
	 * returns y coordinate
	 * @return the y coordinate
	 * */
	public double getY() {
		return y;
	}

	/**
	 * Checks if two objects are equals.
	 * @param obj 	The Object the method compares to
	 * @return True if this is equal to the Object obj
	 * */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

	/**
	 * Converts the Position Object and his fields into a String
	 * @return The String describing the Object
	 * */
	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}
	
	
	/**
	 * Returns a Position with the fields having the exact same value as this Position.
	 * @return a Position Cloned
	 * */
	public Position clone() {
		return new Position(this.x,this.y);
	}

}
