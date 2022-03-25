// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;


import frc.robot.commands.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

//comment out if too bulky
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxRelativeEncoder;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;

/**
 *
 */
public class Chassis extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private MotorControllerGroup m_right;
private MotorControllerGroup m_left;  

    private CANSparkMax rightFront;
    private CANSparkMax leftFront;
    private CANSparkMax rightRear;
    private CANSparkMax leftRear;

    public RelativeEncoder rfEncoder, lfEncoder, rrEncoder, lrEncoder;
    public PIDController rfController, lfController, rrController, lrController;

    private final double kp = 0.01;
    private final double ki = 0.0;
    private final double kd = 0.0;

    public WaitCommand wait;

    private DifferentialDrive differentialDrive;

    /**
    *
    */
    public Chassis() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    rightFront = new CANSparkMax(5, MotorType.kBrushless);
    leftFront = new CANSparkMax(3, MotorType.kBrushless); 
    rightRear = new CANSparkMax(1, MotorType.kBrushless);
    leftRear = new CANSparkMax(4, MotorType.kBrushless);   
    
    // ensures sparks start at default config every time the robot is on, must be declared after constructors
    rightFront.restoreFactoryDefaults();
    rightRear.restoreFactoryDefaults();
    leftFront.restoreFactoryDefaults();
    leftRear.restoreFactoryDefaults();

    m_right = new MotorControllerGroup(rightFront, rightRear);
    m_left = new MotorControllerGroup(leftFront, leftRear);

    differentialDrive = new DifferentialDrive(m_left, m_right);
    // .setSafetyEnabled(false): fixed skipping in drive train - smooth sailin drive
    differentialDrive.setSafetyEnabled(false);
    differentialDrive.setExpiration(0.1);
    differentialDrive.setMaxOutput(1.0);
    
    // inverts
    rightFront.setInverted(true);
    rightRear.setInverted(true);
    //leftRear.setInverted(true);

    rightFront.setOpenLoopRampRate(0.3);
    rightRear.setOpenLoopRampRate(0.3);
    leftFront.setOpenLoopRampRate(0.3);
    leftRear.setOpenLoopRampRate(0.3);

    //sets encoder positions to 0.0 and enables PID controller for sensor
    //Comment out if interfering with original code
    rfEncoder = rightFront.getEncoder();
    rfEncoder.setPosition(0.0);
    lfEncoder = leftFront.getEncoder();
    lfEncoder.setPosition(0.0);
    rrEncoder = rightRear.getEncoder();
    rrEncoder.setPosition(0.0);
    lrEncoder = leftRear.getEncoder();
    lrEncoder.setPosition(0.0);

    rfController = new PIDController(kp, ki, kd);
    lfController = new PIDController(kp, ki, kd);
    rrController = new PIDController(kp, ki, kd);
    lrController = new PIDController(kp, ki, kd);

    }

    @Override
    public void periodic() {
        //testing in periodic is the same as testing with command
        /**leftFront.set(1);
        leftRear.set(1);
        rightRear.set(1);
        rightFront.set(1);**/

        //periodically updates the positioning of the robot
        //if interfering with normal code, comment out
        rightFront.set(rfController.calculate(rfEncoder.getPosition())*0.5);
        leftFront.set(lfController.calculate(lfEncoder.getPosition())*0.5);
        rightRear.set(rrController.calculate(rrEncoder.getPosition())*0.5);
        leftRear.set(lrController.calculate(lrEncoder.getPosition())*0.5);
        
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void setMotorPower(double leftPower, double rightPower){
        m_right.set(rightPower);
        m_left.set(leftPower);
    }

    public void setTankPower(double leftPower, double rightPower){
        differentialDrive.tankDrive(-1*leftPower, -1*rightPower);
    }

    public void setArcadePower(double yPower, double xPower){
        differentialDrive.arcadeDrive(-1*yPower, xPower);
    }

    public void setRightFrontMotorPower(double power){
        rightFront.set(power);
    }
    public void setLeftFrontMotorPower(double power){
        leftFront.set(power);
    }
    public void setRightRearMotorPower(double power){
        rightRear.set(power);
    }
    public void setLeftRearMotorPower(double power){
        leftRear.set(power);
    }

    //if below interferes with code, comment out
    public void setRightFrontMotorPos(double positionGoal){
        rfController.setSetpoint(positionGoal);
        rightFront.set(rfController.calculate(rfEncoder.getPosition())*0.5);
    }
    public void setLeftFrontMotorPos(double positionGoal){
        lfController.setSetpoint(positionGoal);
        leftFront.set(lfController.calculate(lfEncoder.getPosition())*0.5);
    }
    public void setRightRearMotorPos(double positionGoal){
        rrController.setSetpoint(positionGoal);
        rightRear.set(rrController.calculate(rrEncoder.getPosition())*0.5);
    }
    public void setLeftRearMotorPos(double positionGoal){
        lrController.setSetpoint(positionGoal);
        leftRear.set(lrController.calculate(lrEncoder.getPosition())*0.5);
    }

    public boolean rfAtPosGoal(){
        return rfController.atSetpoint();
    }
    public boolean lfAtPosGoal(){
        return rfController.atSetpoint();
    }
    public boolean rrAtPosGoal(){
        return rfController.atSetpoint();
    }
    public boolean lrAtPosGoal(){
        return rfController.atSetpoint();
    }

    public void waitSeconds(double seconds){
        wait = new WaitCommand(seconds);
        wait.initialize();
    }

}

