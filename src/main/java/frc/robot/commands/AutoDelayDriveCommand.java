// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.AutoConstants;
import frc.robot.subsystems.AutoDriveSubsystem;

public class AutoDelayDriveCommand extends CommandBase {
  /** Creates a new AutoDelayDriveCommand. */
  private AutoDriveSubsystem sub_autoDriveSubsystem;
  Timer timer = new Timer();
  private double setpoint;
  public AutoDelayDriveCommand(AutoDriveSubsystem subsystem, double distance) {
    sub_autoDriveSubsystem = subsystem;
    setpoint = distance;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(sub_autoDriveSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    sub_autoDriveSubsystem.m_zeroEncoder();  
    timer.reset();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putString("AutoDone", "In progress");

    SmartDashboard.putNumber("Encoder", AutoDriveSubsystem.m_getBackLeftPosition());
    if(timer.get() >= AutoConstants.AUTO_FEED_WAIT_TIME){
      sub_autoDriveSubsystem.m_drive(setpoint);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    SmartDashboard.putString("AutoDone", "Ended");
    sub_autoDriveSubsystem.m_zeroEncoder();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(Math.abs(AutoDriveSubsystem.m_getBackLeftPosition()) >= Math.abs(setpoint) - AutoConstants.AUTO_ERROR){
      return true;

    }else{
      SmartDashboard.putString("AutoDone", "Not Finished");

      return false;
    }
   
    
  }
  
}
