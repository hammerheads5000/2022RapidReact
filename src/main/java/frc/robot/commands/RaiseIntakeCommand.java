// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class RaiseIntakeCommand extends CommandBase {
  /** Creates a new RaiseIntakeCommand. */
  private IntakeSubsystem sub_intakeSubsystem;
  public RaiseIntakeCommand(IntakeSubsystem subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    sub_intakeSubsystem = subsystem;
    addRequirements(sub_intakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute(){
    sub_intakeSubsystem.m_raise();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    sub_intakeSubsystem.m_turnOffLower();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(sub_intakeSubsystem.m_getUpIR()){
      return true;
    }else{
      return false;
    }
  }
}
