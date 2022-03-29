// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.AutoConstants;
import frc.robot.subsystems.AutoDriveSubsystem;

public class AutoDriveCommand extends CommandBase {
  /** Creates a new AutoDriveCommand. */
  private AutoDriveSubsystem sub_autoDriveSubsystem;
  private double setpoint;
  public AutoDriveCommand(AutoDriveSubsystem subsystem, double distance) {
    sub_autoDriveSubsystem = subsystem;
    setpoint = distance;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(sub_autoDriveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    sub_autoDriveSubsystem.m_zeroEncoder();  


  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putNumber("Encoder", AutoDriveSubsystem.m_getBackLeftPosition());
    sub_autoDriveSubsystem.m_drive(setpoint);

  }
  @Override
  public void end(boolean interrupted) {
    SmartDashboard.putString("AutoDone", "Ended");

    sub_autoDriveSubsystem.m_stopSpinning();
    sub_autoDriveSubsystem.m_zeroEncoder();  

    }

  @Override
  public boolean isFinished() {
    /*
    if (AutoDriveSubsystem.getCollided()){
      return true;
    }else 
    */
    
    
    if(Math.abs(AutoDriveSubsystem.m_getBackLeftPosition()) >= Math.abs(setpoint) - AutoConstants.AUTO_ERROR /*&& AutoDriveSubsystem.m_getBackLeftPosition() <=  || Math.abs(AutoDriveSubsystem.m_getFrontRightPosition()) >= Math.abs(setpoint)*/){
      SmartDashboard.putString("AutoDone", "Finished");
      return true;

    }else{
      SmartDashboard.putString("AutoDone", "Not Finished");

      return false;
    }
   
 
    
  }
}             

