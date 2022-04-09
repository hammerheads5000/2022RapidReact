// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.AutoConstants;
import frc.robot.subsystems.AutoDriveSubsystem;
import frc.robot.subsystems.AutoTurnSubsystem;
import frc.robot.subsystems.FeedSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ThreeBallAutoFarCommandGroup extends SequentialCommandGroup {
  /** Creates a new ThreeBallAutoCloseCommandGroup. */
  //TODO: Get rid of TOP_PATH_RPM parameter in autoshoot
  public ThreeBallAutoFarCommandGroup(AutoDriveSubsystem sub_autoDriveSubsystem, FeedSubsystem sub_feedSubsystem, IntakeSubsystem sub_intakeSubsystem, ShooterSubsystem sub_shooterSubsystem, AutoTurnSubsystem sub_autoTurnSubsystem) {
    super(
      new SequentialCommandGroup(
      //new AutoTurnCommand(sub_autoTurnSubsystem, AutoConstants.TOP_PATH_FIRST_TURN, AutoConstants.TURN_LEFT), 
      new ParallelDeadlineGroup(
        new AutoDelayDriveCommand(sub_autoDriveSubsystem, AutoConstants.DRIVE_TO_SECOND_BALL),
        new AutoIntakeCommand(sub_intakeSubsystem, sub_feedSubsystem)
  
      ),
        new AutoRaiseCommand(sub_intakeSubsystem, sub_feedSubsystem),
      new AutoTurnCommand(sub_autoTurnSubsystem, AutoConstants.ONE_EIGHTY_DEGREES, AutoConstants.TURN_LEFT), 
      new ParallelDeadlineGroup(
        new AutoFeedInManualCommand(sub_feedSubsystem),
        new AutoShootCommand(sub_shooterSubsystem, AutoConstants.TOP_PATH_RPM)
      ),
      new AutoTurnCommand(sub_autoTurnSubsystem, AutoConstants.FAR_ANGLE_TO_TERMINAL, AutoConstants.TURN_RIGHT),
      
      new ParallelDeadlineGroup(
        new AutoDelayDriveCommand(sub_autoDriveSubsystem, AutoConstants.FAR_TO_TERMINAL),
        new AutoIntakeCommand(sub_intakeSubsystem, sub_feedSubsystem)
      ),

      new AutoDriveCommand(sub_autoDriveSubsystem, AutoConstants.THIRD_BALL_DISTANCE),
      new AutoTurnCommand(sub_autoTurnSubsystem, AutoConstants.NINETY_DEGREES, AutoConstants.TURN_LEFT),
      new ParallelDeadlineGroup(
        new AutoFeedInManualCommand(sub_feedSubsystem),
        new AutoShootCommand(sub_shooterSubsystem, AutoConstants.TOP_PATH_RPM)
      )
      
      //shoot
    //  new AutoTurnCommand(sub_autoTurnSubsystem, AutoConstants.TOP_PATH_THIRD_TURN, AutoConstants.TURN_RIGHT),
      //new AutoDriveCommand(sub_autoDriveSubsystem, AutoConstants.MAIN_TOP_PATH)  
      )
      );
  }
}
