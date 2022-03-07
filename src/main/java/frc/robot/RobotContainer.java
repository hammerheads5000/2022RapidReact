// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants;
import frc.robot.commands.*;


public class RobotContainer {
  /*
  --------------------------------------------------------Subsystems-------------------------------------------------------------------------
  */

  //Drive subsystems

  private final DriveTrainSubsystem sub_driveTrainSubsystem = new DriveTrainSubsystem();
  
  //Feed subsystems

  private final FeedSubsystem sub_feedSubsystem = new FeedSubsystem();

  //Intake subsystems

  private final IntakeSubsystem sub_intakeSubsystem = new IntakeSubsystem();
  
  
  //Shooter subsystems

  private final ShooterSubsystem sub_shooterSubsystem = new ShooterSubsystem();

  /*
  ---------------------------------------------------------Commands------------------------------------------------------------------------
  */


  //Feed commands
  
 // private final FeedInCommand cmd_feedInCommand = new FeedInCommand(sub_feedSubsystem);
  private final FeedInManualCommand cmd_feedInManualCommand = new FeedInManualCommand(sub_feedSubsystem);
  private final FeedOutCommand cmd_feedOutCommand = new FeedOutCommand(sub_feedSubsystem);

  //Intake commands
  private final IntakeCommand cmd_intakeCommand = new IntakeCommand(sub_intakeSubsystem, sub_feedSubsystem);
  private final RaiseIntakeCommand cmd_raiseIntakeCommand = new RaiseIntakeCommand(sub_intakeSubsystem);

  //Shooter commands

  private final ShooterCommand cmd_shooterCommand = new ShooterCommand(sub_shooterSubsystem);



  //Auto commands
  private final AutoCommand cmd_autoCommand = new AutoCommand(sub_driveTrainSubsystem);



  /*
  --------------------------------------------------------Joysticks-----------------------------------------------------------------------------
  */
  private final Joystick driveJoystick = new Joystick(Constants.DRIVE_JOYSTICK_PORT);
  private final Joystick buttonsJoystick = new Joystick(Constants.BUTTONS_JOYSTICK_PORT);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

        sub_driveTrainSubsystem.setDefaultCommand(
      new DriveCommand(sub_driveTrainSubsystem, 
      () -> -driveJoystick.getRawAxis(Constants.X),
      () -> -driveJoystick.getRawAxis(Constants.Y), 
      () -> -driveJoystick.getRawAxis(Constants.Z)));

     // sub_feedSubsystem.setDefaultCommand(cmd_feedInCommand);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
 

    //Feed buttons!
    JoystickButton b_feedInButton = new JoystickButton(buttonsJoystick, Constants.FEED_IN_BUTTON);
    b_feedInButton.whenHeld(cmd_feedInManualCommand, Constants.NOT_INTERRUPTIBLE);

    JoystickButton b_feedOutButton = new JoystickButton(buttonsJoystick, Constants.FEED_OUT_BUTTON);
    b_feedOutButton.whenHeld(cmd_feedOutCommand, Constants.NOT_INTERRUPTIBLE);

    //Intake buttons!
    JoystickButton b_intakeButton = new JoystickButton(driveJoystick, Constants.INTAKE_BUTTON);
    b_intakeButton.whenHeld(cmd_intakeCommand, Constants.NOT_INTERRUPTIBLE);
    b_intakeButton.whenInactive(cmd_raiseIntakeCommand, Constants.INTERRUPTIBLE);

    //Shooter buttons!
    JoystickButton b_shootButton = new JoystickButton(buttonsJoystick, Constants.SHOOT_BUTTON);
    b_shootButton.whileHeld(cmd_shooterCommand, Constants.NOT_INTERRUPTIBLE);


  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return cmd_autoCommand;
  }
}
