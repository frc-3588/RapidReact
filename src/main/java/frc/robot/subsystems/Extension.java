package frc.robot.subsystems;

public enum Extension {
    EXTENDED (10),
    NOT_EXTENDED(0)
    ; 

    private int value; 
    Extension(int value){
        this.value = value; 
    }

    public int getValue(){
        return this.value; 
    }
}
