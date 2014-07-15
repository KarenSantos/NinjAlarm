package models;


public class Tuple {

	public int x, y;
	
	public Tuple(int x, int y){
		this.x = x;
		this.y = y;	
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj.getClass().equals(this.getClass())){
			if(((Tuple) obj).x == this.x && ((Tuple) obj).y == this.y){
				return true;
			}
		}
		
		return false;
	}
}
