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

import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Encoder;

import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkMax;

/**
 *
 */
public class Elevator extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    // the two constants below describe the individual MOTOR positions, NOT the
    // ball's position

    private double exitPosition = 10;
    private double entryPosition = 10;

    public final double Kp = 0.1;
    public final double Ki = 0.0;
    public final double Kd = 0.0;

    private Level elevatorState;

    private boolean ballWantsToComeIn;

    // belong to the entry motor
    private CANSparkMax entryMotor;

    private final PIDController entryPIDController;

    private RelativeEncoder entryEncoder;

    // belong to the exit motor
    private CANSparkMax exitMotor;

    private final PIDController exitPIDController;

    private RelativeEncoder exitEncoder;

    /**
    *
    */
    public Elevator() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

       

        entryPIDController = new PIDController(Kp, Ki, Kd);
        exitPIDController = new PIDController(Kp, Ki, Kd);

        elevatorState = Level.START_LEVEL;
        ballWantsToComeIn = false;

        entryMotor = new CANSparkMax(1, MotorType.kBrushless);
        exitMotor = new CANSparkMax(6, MotorType.kBrushless);

        entryEncoder = entryMotor.getEncoder();
        exitEncoder = exitMotor.getEncoder();

        reset();

    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void setEntryMotorPower() {
        entryMotor.set(entryPIDController.calculate(entryEncoder.getPosition()));
    }

    public void setExitMotorPower() {
        exitMotor.set(exitPIDController.calculate(exitEncoder.getPosition()));
    }

    public double getExitMotorPower() {
        return exitMotor.get();
    }

    public double getEntryMotorPower() {
        return entryMotor.get();
    }

    public void setGoal() {

        switch (elevatorState) {
            case START_LEVEL:

                entryPIDController.setSetpoint(entryPosition);
                updateEntryPosition();

                elevatorState = Level.FIRST_LEVEL;
                break;

            case FIRST_LEVEL:

                entryPIDController.setSetpoint(entryPosition);
                updateEntryPosition();
                exitPIDController.setSetpoint(exitPosition);
                updateExitPosition();

                elevatorState = Level.SECOND_LEVEL;
                break;

            case SECOND_LEVEL:
            exitPIDController.setSetpoint(exitPosition);
            updateExitPosition();
                elevatorState = Level.START_LEVEL;
                break;

        }

        if (ballWantsToComeIn) {
            if (elevatorState == Level.FIRST_LEVEL) {
                entryPIDController.setSetpoint(entryPosition);
                updateEntryPosition();
                exitPIDController.setSetpoint(exitPosition);
                updateExitPosition();
            } else if (elevatorState == Level.SECOND_LEVEL) {
                entryPIDController.setSetpoint(entryPosition);
                updateEntryPosition();
            }
        }

    }

    public void setEntryMotorPowerManual(double power) {
        entryMotor.set(power);
    }

    public void setExitMotorPowerManual(double power) {
        exitMotor.set(power);
    }

    public void reset(){
        entryEncoder.setPosition(0.0);
        exitEncoder.setPosition(0.0);
    }

    public void printCurrentPosition() {
        System.out.println(
                "Entry Current Position: " + entryEncoder.getPosition() + " Entry Current Speed: " + entryMotor.get());
        System.out.println(
                "Exit Current Position: " + exitEncoder.getPosition() + " Exit Current Speed: " + exitMotor.get());
    }

    public boolean atEntrySetPoint(){
        return entryPIDController.atSetpoint();
    }

    public boolean atExitSetPoint(){
        return exitPIDController.atSetpoint();
    }

    public void updateEntryPosition(){
        entryPosition+=5;
    }

    public void updateExitPosition(){
        exitPosition+=5;
    }
}
