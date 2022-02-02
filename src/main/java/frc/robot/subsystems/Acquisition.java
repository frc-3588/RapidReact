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
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
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
    private CANSparkMax acquisitionMotor;

    private static double kDt = 0.02;//test

    private final Encoder m_encoder = new Encoder(1, 2);//test

    private final TrapezoidProfile.Constraints m_constraints =
      new TrapezoidProfile.Constraints(1.75, 0.75);//test

  private final ProfiledPIDController m_controller =
      new ProfiledPIDController(1.3, 0.0, 0.7, m_constraints, kDt);//test

  private Extension extensionState;

  private final int kExtended = 5;//test
  private final int kNotExtended = 0; //test

  public final double kMotorStopped = 0.05;//test

    /**
    *
    */
    public Acquisition() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        angleMotor = new CANSparkMax(0, MotorType.kBrushless);
        acquisitionMotor = new CANSparkMax(1, MotorType.kBrushless);
        m_encoder.setDistancePerPulse(1.0 / 360.0 * 2.0 * Math.PI * 1.5);

        extensionState = Extension.NOT_EXTENDED;
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
    public void setGoal(){
        if (extensionState == Extension.EXTENDED) {
            m_controller.setGoal(kNotExtended);
            extensionState=Extension.NOT_EXTENDED;
        } else if (extensionState == Extension.NOT_EXTENDED) {
            m_controller.setGoal(kExtended);
            extensionState=Extension.EXTENDED;
        }
    }

    public void setAngleMotor(){
        angleMotor.set(m_controller.calculate(m_encoder.getDistance()));
    }


    public double getMotorPower(){
        return angleMotor.get();
    }

    public void setAcquisitionMotor(double power){
        acquisitionMotor.set(power); 

    }
}
