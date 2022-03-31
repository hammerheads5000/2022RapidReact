// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.FeedSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterCommand extends CommandBase {

  private ShooterSubsystem sub_shooterSubsystem;
  private FeedSubsystem sub_feedSubsystem;

  /** Creates a new ShootCommand. */
  public ShooterCommand(ShooterSubsystem subsystem, FeedSubsystem subsystem2) {
    sub_shooterSubsystem = subsystem;
    sub_feedSubsystem = subsystem2;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(sub_shooterSubsystem, sub_feedSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    sub_shooterSubsystem.m_TurnOnLimelight();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    sub_shooterSubsystem.m_calculateRPM();
    sub_shooterSubsystem.m_shoot();
    SmartDashboard.putNumber("Actual RPM", sub_shooterSubsystem.m_getActualRPM());
    SmartDashboard.putNumber("Set RPM", sub_shooterSubsystem.m_getSetRPM());
    boolean uhoh = false;
    if(sub_shooterSubsystem.m_getActualRPM() <= sub_shooterSubsystem.m_getSetRPM() + 40 && sub_shooterSubsystem.m_getActualRPM() >= sub_shooterSubsystem.m_getSetRPM() - 40 ){
      sub_feedSubsystem.m_feedInManual();
      uhoh = true;
    }else{
      uhoh = false;
      sub_feedSubsystem.m_stopFeed();
    }
    SmartDashboard.putBoolean("uhoh", uhoh);

  
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    sub_shooterSubsystem.m_stopSpinning();
    sub_shooterSubsystem.m_zeroEncoder();
    ShooterSubsystem.m_resetAverage();
    sub_shooterSubsystem.m_TurnOffLimelight();
    sub_feedSubsystem.m_stopFeed();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
