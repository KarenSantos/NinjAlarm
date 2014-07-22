package models;

public enum Difficulty{
    
    Normal("Normal", 1),
    Hard("Hard", 2),
    Ninja("Ninja", 3);

    private int speed;
    private String level;
    
    Difficulty(String level, int speed){
        this.speed = speed;
        this.level = level;
    }

    public double getSpeed(){
        return this.speed;
    }
    
    public String getLevel(){
        return this.level;
    }
}
