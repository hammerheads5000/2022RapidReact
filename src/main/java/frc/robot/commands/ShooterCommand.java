// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterCommand extends CommandBase {

  private ShooterSubsystem sub_shooterSubsystem;


  /** Creates a new ShootCommand. */
  public ShooterCommand(ShooterSubsystem subsystem) {
    sub_shooterSubsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(sub_shooterSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    sub_shooterSubsystem.m_calculateRPM();
    sub_shooterSubsystem.m_shoot();
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    sub_shooterSubsystem.m_stopSpinning();
    sub_shooterSubsystem.m_zeroEncoder();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
