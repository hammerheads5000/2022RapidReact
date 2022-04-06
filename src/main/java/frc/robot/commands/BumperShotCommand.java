// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.FeedSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class BumperShotCommand extends CommandBase {
  /** Creates a new BumperShotCommand. */
  private ShooterSubsystem sub_shooterSubsystem;
  private FeedSubsystem sub_feedSubsystem;
  public BumperShotCommand(ShooterSubsystem subsystem, FeedSubsystem subsystem2) {
    // Use addRequirements() here to declare subsystem dependencies.
    sub_shooterSubsystem = subsystem;
    sub_feedSubsystem = subsystem2;
    addRequirements(sub_shooterSubsystem, sub_feedSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    sub_shooterSubsystem.m_bumperShot();
    
    if(sub_shooterSubsystem.m_getActualRPM() <= Constants.BUMPER_RPM + 40 && sub_shooterSubsystem.m_getActualRPM() >= Constants.BUMPER_RPM - 40){
      sub_feedSubsystem.m_feedInManual();
      //uhoh = true;
    }else{
      //uhoh = false;
      sub_feedSubsystem.m_stopFeed();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    sub_shooterSubsystem.m_stopSpinning();
    sub_feedSubsystem.m_stopFeed();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
