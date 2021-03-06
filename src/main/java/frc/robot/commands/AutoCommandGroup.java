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
import frc.robot.subsystems.AutoTurnSubsystem;
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

  
  public AutoCommandGroup(AutoDriveSubsystem sub_autoDriveSubsystem, FeedSubsystem sub_feedSubsystem, IntakeSubsystem sub_intakeSubsystem, ShooterSubsystem sub_shooterSubsystem, AutoTurnSubsystem sub_autoTurnSubsystem) {
    /*
    super(
    new SequentialCommandGroup(
    //new AutoTurnCommand(sub_autoTurnSubsystem, AutoConstants.TOP_PATH_FIRST_TURN, AutoConstants.TURN_LEFT), 
    new ParallelDeadlineGroup(
      new AutoDriveCommand(sub_autoDriveSubsystem, AutoConstants.TOP_PATH),
      new AutoIntakeCommand(sub_intakeSubsystem, sub_feedSubsystem)
    ),
    new AutoTurnCommand(sub_autoTurnSubsystem, AutoConstants.TOP_PATH_SECOND_TURN, AutoConstants.TURN_LEFT), 
    new ParallelDeadlineGroup(
      new AutoShootCommand(sub_shooterSubsystem, AutoConstants.TOP_PATH_RPM),
      new AutoFeedInManualCommand(sub_feedSubsystem),
      new AutoFeedInManualCommand(sub_feedSubsystem)
    ),
    new AutoTurnCommand(sub_autoTurnSubsystem, AutoConstants.TOP_PATH_THIRD_TURN, AutoConstants.TURN_RIGHT),
    new AutoDriveCommand(sub_autoDriveSubsystem, AutoConstants.MAIN_TOP_PATH)  
    )
    );*/
    
    /*super(
    //new AutoTurnCommand(sub_autoDriveSubsystem, AutoConstants.BOTTOM_PATH_FIRST_TURN, AutoConstants.TURN_RIGHT),
    new SequentialCommandGroup(

    new ParallelDeadlineGroup( 
      new AutoDriveCommand(sub_autoDriveSubsystem, AutoConstants.BOTTOM_PATH),
      new AutoIntakeCommand(sub_intakeSubsystem, sub_feedSubsystem)
    ),

    new AutoTurnCommand(sub_autoTurnSubsystem, AutoConstants.BOTTOM_PATH_SECOND_TURN, AutoConstants.TURN_LEFT), 
    
    new ParallelDeadlineGroup( 
      new AutoShootCommand(sub_shooterSubsystem, AutoConstants.BOTTOM_PATH_RPM),
      new AutoFeedInManualCommand(sub_feedSubsystem),
      new AutoFeedInManualCommand(sub_feedSubsystem)
      ),

    new AutoTurnCommand(sub_autoTurnSubsystem, AutoConstants.BOTTOM_PATH_THIRD_TURN, AutoConstants.TURN_LEFT),
    
    new AutoDriveCommand(sub_autoDriveSubsystem, AutoConstants.MAIN_BOTTOM_PATH)
    ));*/
    
    /*
    super(
    //new AutoTurnCommand(sub_autoTurnSubsystem, AutoConstants.TOP_MIDDLE_PATH_FIRST_TURN, AutoConstants.TURN_LEFT),
    new SequentialCommandGroup(
    new ParallelDeadlineGroup( 
      new AutoDriveCommand(sub_autoDriveSubsystem, AutoConstants.TOP_MIDDLE_PATH),
      new AutoIntakeCommand(sub_intakeSubsystem, sub_feedSubsystem)
    ),
    new AutoTurnCommand(sub_autoTurnSubsystem, AutoConstants.TOP_MIDDLE_PATH_SECOND_TURN, AutoConstants.TURN_LEFT), 
    new ParallelDeadlineGroup(
      new AutoShootCommand(sub_shooterSubsystem, AutoConstants.MIDDLE_TOP_PATH_RPM),
      new AutoFeedInManualCommand(sub_feedSubsystem),
      new AutoFeedInManualCommand(sub_feedSubsystem)
    ),
    new AutoTurnCommand(sub_autoTurnSubsystem, AutoConstants.MIDDLE_PATH_THIRD_TURN, AutoConstants.TURN_LEFT),
    new AutoDriveCommand(sub_autoDriveSubsystem, AutoConstants.MAIN_MIDDLE_PATH)  
    ));
    */
    
    /*super(
    //new AutoTurnCommand(sub_autoTurnSubsystem, AutoConstants.BOTTOM_MIDDLE_PATH_FIRST_TURN, AutoConstants.TURN_RIGHT),
    new SequentialCommandGroup(
    new ParallelDeadlineGroup(  
      new AutoDriveCommand(sub_autoDriveSubsystem, AutoConstants.BOTTOM_MIDDLE_PATH),
      new AutoIntakeCommand(sub_intakeSubsystem, sub_feedSubsystem)
    ),
    new AutoTurnCommand(sub_autoTurnSubsystem, AutoConstants.BOTTOM_MIDDLE_PATH_SECOND_TURN, AutoConstants.TURN_RIGHT), 
    new ParallelDeadlineGroup(  
      new AutoShootCommand(sub_shooterSubsystem, AutoConstants.MIDDLE_BOTTOM_PATH_RPM),
      new AutoFeedInManualCommand(sub_feedSubsystem),
      new AutoFeedInManualCommand(sub_feedSubsystem)
    ),
    new AutoTurnCommand(sub_autoTurnSubsystem, AutoConstants.MIDDLE_PATH_THIRD_TURN, AutoConstants.TURN_LEFT),
    new AutoDriveCommand(sub_autoDriveSubsystem, AutoConstants.MAIN_MIDDLE_PATH)  
    ));*/
    
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
