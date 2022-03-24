// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.AutoDriveSubsystem;

public class AutoDriveCommand extends CommandBase {
  /** Creates a new AutoDriveCommand. */
  private AutoDriveSubsystem sub_autoDriveSubsystem;
  double distance;
  double setpoint;
  public AutoDriveCommand(AutoDriveSubsystem subsystem, double distance) {
    sub_autoDriveSubsystem = subsystem;
    this.distance = distance;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(sub_autoDriveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }


 



  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    sub_autoDriveSubsystem.m_stopSpinning();
    sub_autoDriveSubsystem.m_zeroEncoder();  

    }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    setpoint = distance;

    sub_autoDriveSubsystem.m_drive(setpoint);

    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    /*
    if (AutoDriveSubsystem.getCollided()){
      return true;
    }else 
    */
    if(AutoDriveSubsystem.m_getBackLeftPosition() == setpoint || AutoDriveSubsystem.m_getFrontRightPosition() == setpoint){
      return true;

    }else{
      return false;
    }

    
    
  }
}

