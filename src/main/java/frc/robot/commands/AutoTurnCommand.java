// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.AutoConstants;
import frc.robot.subsystems.AutoTurnSubsystem;

public class AutoTurnCommand extends CommandBase {
  /** Creates a new AutoDriveCommand. */
  private AutoTurnSubsystem sub_autoTurnSubsystem;
  double setpoint;
  boolean right;

  public AutoTurnCommand(AutoTurnSubsystem subsystem, double angle, boolean right) {
    sub_autoTurnSubsystem = subsystem;
    setpoint = angle;
    this.right = right;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(sub_autoTurnSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    
    
    sub_autoTurnSubsystem.m_zeroEncoder();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    sub_autoTurnSubsystem.m_turn(right, angle);

    
  }

  @Override
  public void end(boolean interrupted){
    sub_autoTurnSubsystem.m_stopSpinning();
    
    sub_autoTurnSubsystem.m_zeroEncoder();

  }


  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(Math.abs(AutoTurnSubsystem.m_getBackLeftPosition()) >= Math.abs(setpoint) - AutoConstants.AUTO_ERROR /*&& AutoTurnSubsystem.m_getBackLeftPosition() <=  || Math.abs(AutoTurnSubsystem.m_getFrontRightPosition()) >= Math.abs(setpoint)*/){
      //SmartDashboard.putString("AutoDone", "Finished");
      return true;

    }else{
      //SmartDashboard.putString("AutoDone", "Not Finished");

      return false;
    }
  }
}
