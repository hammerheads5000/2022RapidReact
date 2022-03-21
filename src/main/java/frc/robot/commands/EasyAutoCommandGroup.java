// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.AutoDriveSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.AutoConstants;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class EasyAutoCommandGroup extends SequentialCommandGroup {
  
  /** Creates a new EasyAutoCommandGroup. */
  public EasyAutoCommandGroup(AutoDriveSubsystem sub_autoDriveSubsystem, ShooterSubsystem sub_shooterSubsystem) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new AutoDriveCommand(sub_autoDriveSubsystem, AutoConstants.EASY_PATH_DISTANCE),
      new AutoShootCommand(sub_shooterSubsystem, AutoConstants.EASY_PATH_RPM)
    );
  }
}
