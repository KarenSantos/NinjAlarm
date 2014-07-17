package models;

public class StopButton {
	
	private Difficulty level;
	private Direction direction;
	
	Tuple position = new Tuple(0,0);
	
	public StopButton(){
		level = Difficulty.Normal;
	}
			
	public void setLevel(Difficulty level) throws Exception{
		if(level == null){
			throw new Exception("Level couldn't be null");
		}
		
		this.level = level;
	}
	
	public void changeDirection(){
		direction.setDirection();	
	}
	
	public void walk() {				
		position.x += level.getSpeed()*direction.getX();
		position.y += level.getSpeed()*direction.getY();		
	}
	

}
