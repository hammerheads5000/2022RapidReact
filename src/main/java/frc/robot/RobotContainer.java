// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.EventImportance;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants;
import frc.robot.commands.*;


public class RobotContainer {
  /*
  --------------------------------------------------------Subsystems-------------------------------------------------------------------------
  */

  //Drive subsystems

  public final DriveTrainSubsystem sub_driveTrainSubsystem = new DriveTrainSubsystem();
  
  //Feed subsystems

  private final FeedSubsystem sub_feedSubsystem = new FeedSubsystem();

  //Intake subsystems

  private final IntakeSubsystem sub_intakeSubsystem = new IntakeSubsystem();
  
  
  //Shooter subsystems

  private final ShooterSubsystem sub_shooterSubsystem = new ShooterSubsystem();

  //Auto Subsystems

  private final AutoDriveSubsystem sub_autoDriveSubsystem = new AutoDriveSubsystem();

  private final AutoTurnSubsystem sub_autoTurnSubsystem = new AutoTurnSubsystem();



  /*
  ---------------------------------------------------------Commands------------------------------------------------------------------------
  */

  //Feed commands
  private final FeedInManualCommand cmd_feedInManualCommand = new FeedInManualCommand(sub_feedSubsystem);
  private final FeedOutCommand cmd_feedOutCommand = new FeedOutCommand(sub_feedSubsystem);
  private final OrganizeFeedCommand cmd_organizeFeedCommand = new OrganizeFeedCommand(sub_feedSubsystem);


  //Intake commands
  private final IntakeCommand cmd_intakeCommand = new IntakeCommand(sub_intakeSubsystem, sub_feedSubsystem);
  private final RaiseIntakeCommand cmd_raiseIntakeCommand = new RaiseIntakeCommand(sub_intakeSubsystem);
  private final EndOfMatchCommand cmd_endOfMatchCommand = new EndOfMatchCommand(sub_intakeSubsystem);
  private final IntakeOutCommand cmd_intakeOutCommand = new IntakeOutCommand(sub_intakeSubsystem);

  //Shooter commands
  private final AimCommand cmd_aimCommand = new AimCommand(sub_shooterSubsystem);
  private final ShooterCommand cmd_shooterCommand = new ShooterCommand(sub_shooterSubsystem);
  private final BumperShotCommand cmd_bumperShotCommand = new BumperShotCommand(sub_shooterSubsystem);
  private final SafeZoneShotCommand cmd_safeZoneShotCommand = new SafeZoneShotCommand(sub_shooterSubsystem);


  //Auto commands
  private final AutoCommandGroup cmd_autoCommand = new AutoCommandGroup(
    sub_autoDriveSubsystem,
    sub_feedSubsystem,
    sub_intakeSubsystem,
    sub_shooterSubsystem,
    sub_autoTurnSubsystem
    );
    private final EasyAutoCommandGroup cmd_easyAutoCommand = new EasyAutoCommandGroup(
    sub_autoDriveSubsystem,
    sub_shooterSubsystem,
    sub_autoTurnSubsystem,
    sub_feedSubsystem
    );

  /*private final AutoDriveCommand cmd_autoDriveCommand = new AutoDriveCommand(sub_autoDriveSubsystem);
  private final AutoTurnCommand cmd_autoTurnCommand = new AutoTurnCommand(sub_autoDriveSubsystem);*/
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


      CommandScheduler.getInstance().onCommandInitialize(command -> Shuffleboard.addEventMarker("Command initialized", command.getName(), EventImportance.kNormal));
      CommandScheduler.getInstance().onCommandInterrupt(command -> Shuffleboard.addEventMarker("Command interrupted", command.getName(), EventImportance.kNormal));
      CommandScheduler.getInstance().onCommandFinish(command -> Shuffleboard.addEventMarker("Command finished", command.getName(), EventImportance.kNormal));
      CommandScheduler.getInstance().onCommandExecute(command -> Shuffleboard.addEventMarker("Command execute", command.getName(), EventImportance.kNormal));

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

    JoystickButton b_organizeFeedButton = new JoystickButton(buttonsJoystick, Constants.ORGANIZE_FEED_BUTTON);
    b_organizeFeedButton.whenHeld(cmd_organizeFeedCommand, Constants.NOT_INTERRUPTIBLE);
    //Intake buttons!
    JoystickButton b_intakeButton = new JoystickButton(driveJoystick, Constants.INTAKE_BUTTON);
    b_intakeButton.whenHeld(cmd_intakeCommand, Constants.NOT_INTERRUPTIBLE);
    b_intakeButton.whenInactive(cmd_raiseIntakeCommand, Constants.INTERRUPTIBLE);
    JoystickButton b_endOfMatchButton = new JoystickButton(buttonsJoystick, Constants.END_OF_MATCH_BUTTON);
    b_endOfMatchButton.whenPressed(cmd_endOfMatchCommand, Constants.NOT_INTERRUPTIBLE);
    JoystickButton b_outtakeButton = new JoystickButton(driveJoystick, Constants.OUTTAKE_BUTTON);
    b_outtakeButton.whenHeld(cmd_intakeOutCommand, Constants.NOT_INTERRUPTIBLE);

    //Shooter buttons!
    JoystickButton b_shootButton = new JoystickButton(buttonsJoystick, Constants.SHOOT_BUTTON);
    b_shootButton.whileHeld(cmd_shooterCommand, Constants.NOT_INTERRUPTIBLE);
    JoystickButton b_bumperShotButton = new JoystickButton(buttonsJoystick, Constants.BUMPER_SHOT_BUTTON);
    b_bumperShotButton.whileHeld(cmd_bumperShotCommand, Constants.NOT_INTERRUPTIBLE);
    JoystickButton b_safeZoneShotButton = new JoystickButton(buttonsJoystick, Constants.SAFE_ZONE_SHOT_BUTTON);
    b_safeZoneShotButton.whileHeld(cmd_safeZoneShotCommand, Constants.NOT_INTERRUPTIBLE);


    JoystickButton b_aimButton = new JoystickButton(buttonsJoystick, Constants.AIM_BUTTON);
    b_aimButton.whileHeld(cmd_aimCommand, Constants.NOT_INTERRUPTIBLE);


  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return cmd_easyAutoCommand;
  }
}
