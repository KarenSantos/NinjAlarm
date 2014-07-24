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

	public int x, y;

	/**
	 * Creates a new Tuple with the given coordinates.
	 * 
	 * @param x
	 *            The first coordinate.
	 * @param y
	 *            The second coordinate.     
	 *  
	 **/
	public Tuple(int x, int y){
		this.x = x;
		this.y = y;	
	}

	/**
	 * Verify is the given object have the coordinates of this one.
	 * 
	 * @param obj
	 *            The object to be compared.
	 *            
	 * @return True if it is equal or false otherwise.
	 * 
	 **/
	@Override
	public boolean equals(Object obj) {

		if(obj != null){
			if(obj.getClass().equals(this.getClass())){
				if(((Tuple) obj).x == this.x && ((Tuple) obj).y == this.y){
					return true;
				}
			}
		}
		
		return false;
	}
}
