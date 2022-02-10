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
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.AnalogAccelerometer;
import edu.wpi.first.wpilibj.Encoder;

/**
 *
 */
public class Acquisition extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    private CANSparkMax angleMotor;

    private RelativeEncoder m_encoder;
    private CANSparkMax acquisitionMotor;

    private static double kDt = 0.02;// test

    private double positionGoal; // test

    private final double Kp = 0.1;
    private final double Ki = 0.0;
    private final double Kd = 0.0;

    // private final TrapezoidProfile.Constraints m_constraints = new TrapezoidProfile.Constraints(1.75, 0.75);// test

    // private final ProfiledPIDController m_controller = new ProfiledPIDController(Kp, Ki, Kd, m_constraints, kDt);// test
    private final PIDController m_controller = new PIDController(Kp, Ki, Kd);
    private Extension extensionState;

    private final int kForward = 1;// test
    private final int kReverse = -1; // test

    private int direction;

    /**
    *
    */
    public Acquisition() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        angleMotor = new CANSparkMax(6, MotorType.kBrushless);
        acquisitionMotor = new CANSparkMax(1, MotorType.kBrushless);
        m_encoder = angleMotor.getEncoder();
        reset();
        extensionState = Extension.NOT_EXTENDED;

        direction = kForward;
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
    public void setGoal() {
        if (extensionState == Extension.EXTENDED) {
            m_controller.setSetpoint(Extension.NOT_EXTENDED.getValue());
            // positionGoal = Extension.NOT_EXTENDED.getValue();
            // direction = kReverse;
            extensionState = Extension.NOT_EXTENDED;
        } else if (extensionState == Extension.NOT_EXTENDED) {
            m_controller.setSetpoint(Extension.EXTENDED.getValue());
            // positionGoal = Extension.EXTENDED.getValue();
            // direction = kForward;
            extensionState = Extension.EXTENDED;
        }
    }

    public void setAngleMotorPID() {
        angleMotor.set(m_controller.calculate(m_encoder.getPosition()));
    }

    public void setAcquisitionMotor(double power) {
        acquisitionMotor.set(power);

    }

    public boolean atPositionGoal(){
        return m_controller.atSetpoint();
    }

    public void setAngleMotorManual(double power) {
        angleMotor.set(power);
    }

    public double getAngleMotorPosition() {
        return angleMotor.getEncoder().getPosition();
    }

    // public void setPositionGoal(double position) {
    //     positionGoal = position;
    // }

    // public double getPositionGoal(){
    //     return positionGoal;
    // }
    
    public void reset() {
        m_encoder.setPosition(0);
    }

    public void printCurrentPosition() {
        System.out.println("Current angle motor position: " + angleMotor.getEncoder().getPosition()
                + " Current angle motor speed: " + angleMotor.get());
    }
}
