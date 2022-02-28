// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.AutoDriveSubsystem;
import frc.robot.subsystems.FeedSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.AutoConstants;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoCommandGroup extends SequentialCommandGroup {
  /** Creates a new AutoCommandGroup. */

  /*private final AutoDriveSubsystem sub_autoDriveSubsystem;
  private final FeedSubsystem sub_feedSubsystem;
  private final IntakeSubsystem sub_intakeSubsystem;
  private final ShooterSubsystem sub_shooterSubsystem;*/

  
  public AutoCommandGroup(AutoDriveSubsystem sub_autoDriveSubsystem, FeedSubsystem sub_feedSubsystem, IntakeSubsystem sub_intakeSubsystem, ShooterSubsystem sub_shooterSubsystem) {
    super(
    new AutoTurnCommand(sub_autoDriveSubsystem, AutoConstants.TOP_PATH_FIRST_TURN, AutoConstants.TURN_LEFT), 
    new AutoDriveCommand(sub_autoDriveSubsystem, AutoConstants.TOP_PATH),
    new IntakeCommand(sub_intakeSubsystem),
    new AutoTurnCommand(sub_autoDriveSubsystem, AutoConstants.TOP_PATH_SECOND_TURN, AutoConstants.TURN_LEFT), 
    new FeedInManualCommand(sub_feedSubsystem),
    new ShooterCommand(sub_shooterSubsystem),
    new ShooterCommand(sub_shooterSubsystem),
    new AutoTurnCommand(sub_autoDriveSubsystem, AutoConstants.TOP_PATH_THIRD_TURN, AutoConstants.TURN_RIGHT),
    new AutoDriveCommand(sub_autoDriveSubsystem, AutoConstants.MAIN_TOP_PATH)  
    );
    /**
    super(
    new AutoTurnCommand(sub_autoDriveSubsystem, AutoConstants.BOTTOM_PATH_FIRST_TURN, AutoConstants.TURN_RIGHT), 
    new AutoDriveCommand(sub_autoDriveSubsystem, AutoConstants.BOTTOM_PATH),
    new IntakeCommand(sub_intakeSubsystem),
    new AutoTurnCommand(sub_autoDriveSubsystem, AutoConstants.BOTTOM_PATH_SECOND_TURN, AutoConstants.TURN_LEFT), 
    new FeedInManualCommand(sub_feedSubsystem),
    new ShooterCommand(sub_shooterSubsystem),
    new ShooterCommand(sub_shooterSubsystem),
    new AutoTurnCommand(sub_autoDriveSubsystem, AutoConstants.BOTTOM_PATH_THIRD_TURN, AutoConstants.TURN_LEFT),
    new AutoDriveCommand(sub_autoDriveSubsystem, AutoConstants.MAIN_BOTTOM_PATH)  
    );
    super(
    new AutoTurnCommand(sub_autoDriveSubsystem, AutoConstants.MIDDLE_TOP_PATH_FIRST_TURN, AutoConstants.TURN_LEFT), 
    new AutoDriveCommand(sub_autoDriveSubsystem, AutoConstants.MIDDLE_TOP_PATH),
    new IntakeCommand(sub_intakeSubsystem),
    new AutoTurnCommand(sub_autoDriveSubsystem, AutoConstants.MIDDLE_TOP_PATH_SECOND_TURN, AutoConstants.TURN_LEFT), 
    new FeedInManualCommand(sub_feedSubsystem),
    new ShooterCommand(sub_shooterSubsystem),
    new ShooterCommand(sub_shooterSubsystem),
    new AutoTurnCommand(sub_autoDriveSubsystem, AutoConstants.MIDDLE_PATH_THIRD_TURN, AutoConstants.TURN_LEFT),
    new AutoDriveCommand(sub_autoDriveSubsystem, AutoConstants.MAIN_MIDDLE_PATH)  
    );
    super(
    new AutoTurnCommand(sub_autoDriveSubsystem, AutoConstants.MIDDLE_BOTTOM_PATH_FIRST_TURN, AutoConstants.TURN_RIGHT), 
    new AutoDriveCommand(sub_autoDriveSubsystem, AutoConstants.MIDDLE_BOTTOM_PATH),
    new IntakeCommand(sub_intakeSubsystem),
    new AutoTurnCommand(sub_autoDriveSubsystem, AutoConstants.MIDDLE_BOTTOM_PATH_SECOND_TURN, AutoConstants.TURN_RIGHT), 
    new FeedInManualCommand(sub_feedSubsystem),
    new ShooterCommand(sub_shooterSubsystem),
    new ShooterCommand(sub_shooterSubsystem),
    new AutoTurnCommand(sub_autoDriveSubsystem, AutoConstants.MIDDLE_PATH_THIRD_TURN, AutoConstants.TURN_LEFT),
    new AutoDriveCommand(sub_autoDriveSubsystem, AutoConstants.MAIN_MIDDLE_PATH)  
    );
     * 
     * 
     * 
     * 
     * 
     */
    /* Top Path
    addCommands(
      Turn x degrees,
      new ParallelDeadlineGroup
      (
        Move forward approximately 3.9 feet,
        new IntakeCommand(sub_intakeSubsystem)
      ),
      Turn 180 degrees,
      new ShooterCommand(sub_shootSubsystem),
      new ShooterCommand(sub_shootSubsystem),
      Turn approximately 113.3 degrees,
      Move forward approximately 18.9 feet
    );
    */

    /* Top-Middle Path
    addCommands(
      Turn x degrees,
      new ParallelDeadlineGroup
      (
        Move forward approximately 6 feet,
        new IntakeCommand(sub_intakeSubsystem)
      ),
      Turn 180 degrees,
      new ShooterCommand(sub_shootSubsystem),
      new ShooterCommand(sub_shootSubsystem),
      Turn approximately 110.4 degrees,
      Move forward approximately 11.7 feet
    );
    */

    /* Bottom-Middle Path
    addCommands(
      Turn x degrees,
      new ParallelDeadlineGroup
      (
        Move forward approximately 3.9 feet,
        new IntakeCommand(sub_intakeSubsystem)
      ),
      Turn 180 degrees,
      new ShooterCommand(sub_shootSubsystem),
      new ShooterCommand(sub_shootSubsystem),
      Turn approximately 162.3 degrees,
      Move forward approximately 11.7 feet
    );
    */

    /* Bottom Path
    addCommands(
      Turn x degrees,
      new ParallelDeadlineGroup
      (
        Move forward approximately 3.6 feet,
        new IntakeCommand(sub_intakeSubsystem)
      ),
      Turn 180 degrees,
      new ShooterCommand(sub_shootSubsystem),
      new ShooterCommand(sub_shootSubsystem),
      Turn approximately  83.7 degrees,
      Move forward approximately 18.1 feet
    );
    */
  }
  
}
