package models;

public enum AlarmType {
	
	MELODY(1), MELODY_VIBRATION(2), VIBRATION(3);
	
	private int typeNum;
	
	private AlarmType(int type){
		this.typeNum = type;
	}

	public int getValue(){
		return typeNum;
	}
}
