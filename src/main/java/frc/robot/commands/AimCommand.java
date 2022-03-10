// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;

public class AimCommand extends CommandBase {
  /** Creates a new AimCommand. */
  private final ShooterSubsystem sub_ShooterSubsystem;
  public AimCommand(ShooterSubsystem subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    sub_ShooterSubsystem = subsystem;
    addRequirements(sub_ShooterSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    sub_ShooterSubsystem.m_TurnOnLimelight();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    sub_ShooterSubsystem.m_aim();
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
