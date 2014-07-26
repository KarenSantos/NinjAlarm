package models;

/**
 * Tuple class
 * 
 * Encapsulates one pair of int numbers.
 * 
 * @author Ana, Felipe, Karen, Leticia, Marcos and Maysa.
 * 
 */
public class Tuple {

	private int x, y;

	/**
	 * Creates a new Tuple with the given coordinates.
	 * 
	 * @param x
	 *            The first coordinate.
	 * @param y
	 *            The second coordinate.
	 * 
	 **/
	public Tuple(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Returns the X value of the tuple.
	 * 
	 * @return The X value of the tuple.
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the X value of the tuple.
	 * 
	 * @param x
	 *            The new X value of the tuple.
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Returns the Y value of the tuple.
	 * 
	 * @return The Y value of the tuple.
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the Y value of the tuple.
	 * 
	 * @param y
	 *            The new Y value of the tuple.
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Verifies if the given object has the same coordinates of this one.
	 * 
	 * @param obj
	 *            The object to be compared.
	 * 
	 * @return True if it is equal or false otherwise.
	 * 
	 **/
	@Override
	public boolean equals(Object obj) {

		if (obj != null) {
			if (obj.getClass().equals(this.getClass())) {
				if (((Tuple) obj).x == this.x && ((Tuple) obj).y == this.y) {
					return true;
				}
			}
		}

		return false;
	}
}
