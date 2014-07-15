package models;

public class InvalidAlarmConfiguration extends Exception {
	
	private static final long serialVersionUID = 1L;

	public InvalidAlarmConfiguration(String message){
		super(message);
	}

}
