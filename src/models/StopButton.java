import java.util.Random;

public abstract class StopButton {
	public Tuple position, direction;
	protected int speed;
	
	protected Random rand = new Random();
	
	protected int[] possibleDirections = {1,0,-1};
		
	public abstract void run();

}
