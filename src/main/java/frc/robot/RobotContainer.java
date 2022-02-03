// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: RobotContainer.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
// The robot's subsystems
    // public final Elevator m_elevator = new Elevator();
    // public final Acquisition m_acquisition = new Acquisition();
    public final Chassis m_chassis = new Chassis();

// Joysticks
private final XboxController operatorController = new XboxController(2);
private final Joystick rightJoystick = new Joystick(1);
private final Joystick leftJoystick = new Joystick(0);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

  
  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
  private RobotContainer() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Smartdashboard Subsystems


    // SmartDashboard Buttons
    SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
    SmartDashboard.putData("Drive", new Drive( m_chassis ));
    // SmartDashboard.putData("ActivateElevator", new ActivateElevator( m_elevator ));
    // SmartDashboard.putData("CollectBalls", new CollectBalls( m_acquisition ));
    // SmartDashboard.putData("ToggleAcquisitionAngle", new ToggleAcquisitionAngle( m_acquisition ));
    // SmartDashboard.putData("ActivateLowerElevatorManual", new ActivateLowerElevatorManual( m_elevator ));
    // SmartDashboard.putData("ActivateUpperElevatorManual", new ActivateUpperElevatorManual( m_elevator ));
    // SmartDashboard.putData("ExtensionAcquisition", new ExtensionAcquisition( m_acquisition ));
    // SmartDashboard.putData("NotExtendAcquisition", new NotExtendAcquisition( m_acquisition ));

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND
    // m_acquisition.setDefaultCommand(new CollectBalls( m_acquisition ) );
    m_chassis.setDefaultCommand(new Drive( m_chassis ) );


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND

    // Configure autonomous sendable chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    m_chooser.setDefaultOption("Autonomous Command", new AutonomousCommand());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    SmartDashboard.putData("Auto Mode", m_chooser);
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }


  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
// Create some buttons
// final JoystickButton notExtendAcqusitionButton = new JoystickButton(operatorController, XboxController.Button.kA.value);        
// notExtendAcqusitionButton.whileHeld(new NotExtendAcquisition( m_acquisition ) ,true);
//     SmartDashboard.putData("notExtendAcqusitionButton",new NotExtendAcquisition( m_acquisition ) );

// final JoystickButton extentionAcquisitionButton = new JoystickButton(operatorController, XboxController.Button.kA.value);        
// extentionAcquisitionButton.whileHeld(new ExtensionAcquisition( m_acquisition ) ,true);
//     SmartDashboard.putData("extentionAcquisitionButton",new ExtensionAcquisition( m_acquisition ) );

// final JoystickButton toggleElevatorButton = new JoystickButton(operatorController, XboxController.Button.kA.value);        
// toggleElevatorButton.whenPressed(new ActivateElevator( m_elevator ) ,true);
//     SmartDashboard.putData("toggleElevatorButton",new ActivateElevator( m_elevator ) );

// final JoystickButton manualUpperElevatorButton = new JoystickButton(operatorController, XboxController.Button.kA.value);        
// manualUpperElevatorButton.whileHeld(new ActivateUpperElevatorManual( m_elevator ) ,true);
//     SmartDashboard.putData("manualUpperElevatorButton",new ActivateUpperElevatorManual( m_elevator ) );

// final JoystickButton manualLowerElevatorButton = new JoystickButton(operatorController, XboxController.Button.kA.value);        
// manualLowerElevatorButton.whileHeld(new ActivateLowerElevatorManual( m_elevator ) ,true);
//     SmartDashboard.putData("manualLowerElevatorButton",new ActivateLowerElevatorManual( m_elevator ) );

// final JoystickButton toggleAcquisitionAngleButton = new JoystickButton(operatorController, XboxController.Button.kA.value);        
// toggleAcquisitionAngleButton.whenPressed(new ToggleAcquisitionAngle( m_acquisition ) ,true);
//     SmartDashboard.putData("toggleAcquisitionAngleButton",new ToggleAcquisitionAngle( m_acquisition ) );



    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
  }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
public Joystick getleftJoystick() {
        return leftJoystick;
    }

public Joystick getrightJoystick() {
        return rightJoystick;
    }

public XboxController getoperatorController() {
      return operatorController;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return m_chooser.getSelected();
  }


}

