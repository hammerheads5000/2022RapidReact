// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.ShooterSubsystem;


public class AutoShootCommand extends CommandBase {
  private ShooterSubsystem sub_shooterSubsystem;
  int rpm;
  /** Creates a new AutoShootCommand. */
  public AutoShootCommand(ShooterSubsystem subsystem, int rpm) {
    sub_shooterSubsystem = subsystem;
    this.rpm = rpm;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(sub_shooterSubsystem);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    ShooterSubsystem.setRPM(rpm);
    sub_shooterSubsystem.m_shoot();
    sub_shooterSubsystem.m_stopSpinning();
    sub_shooterSubsystem.m_zeroEncoder();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
