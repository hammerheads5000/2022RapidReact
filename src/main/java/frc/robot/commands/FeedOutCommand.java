// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FeedSubsystem;

public class FeedOutCommand extends CommandBase {
  /** Creates a new FeedOutCommand. */
  private FeedSubsystem sub_feedSubsystem;  
  public FeedOutCommand(FeedSubsystem subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    sub_feedSubsystem = subsystem;
    addRequirements(sub_feedSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    sub_feedSubsystem.m_feedOut();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
