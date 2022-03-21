// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.CameraSubsystem;

public class SetCameraOneCommand extends CommandBase {
  /** Creates a new SetCameraOne. */
  private CameraSubsystem sub_cameraSubsystem;
  public SetCameraOneCommand(CameraSubsystem subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    sub_cameraSubsystem = subsystem;
    addRequirements(sub_cameraSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    sub_cameraSubsystem.m_cameraOne();
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
