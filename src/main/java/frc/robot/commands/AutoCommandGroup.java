// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.AutoDriveSubsystem;
import frc.robot.subsystems.FeedSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoCommandGroup extends SequentialCommandGroup {
  /** Creates a new AutoCommandGroup. */

  private final AutoDriveSubsystem sub_autoDriveSubsystem;
  private final FeedSubsystem sub_feedSubsystem;
  private final IntakeSubsystem sub_intakeSubsystem;
  private final ShooterSubsystem sub_shooterSubsystem;

  public AutoCommandGroup(AutoDriveSubsystem autoSub, FeedSubsystem feedSub, IntakeSubsystem intakeSub, ShooterSubsystem shootSub) {
    sub_autoDriveSubsystem = autoSub;
    sub_feedSubsystem = feedSub;
    sub_intakeSubsystem = intakeSub;
    sub_shooterSubsystem = shootSub;

    addRequirements(sub_autoDriveSubsystem, sub_feedSubsystem, sub_intakeSubsystem, sub_shooterSubsystem);

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
