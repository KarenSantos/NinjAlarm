
public class HardStop extends StopButton{

	public HardStop(){
		position = new Tuple(0,0);
		direction = new Tuple(0,0);
		speed = 2;
	}
		
	@Override
	public void run() {
		
		int randX = possibleDirections[rand.nextInt(3)];
		int randY = possibleDirections[rand.nextInt(3)];
		
		position.x += speed*randX;
		position.y += speed*randY;
		
	}	
}
