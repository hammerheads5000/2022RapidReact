// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCommand extends CommandBase {

  private IntakeSubsystem sub_intakeSubsystem;
  /** Creates a new IntakeCommand. */

  private final Timer timer = new Timer();
  private double tempTimer;
  
  public IntakeCommand(IntakeSubsystem subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    sub_intakeSubsystem = subsystem;
    addRequirements(sub_intakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //sub_intakeSubsystem.m_intake();
  
    if(sub_intakeSubsystem.m_getUpIR()){
      sub_intakeSubsystem.m_lower();
      timer.start();
      tempTimer = timer.get();
    }else if(sub_intakeSubsystem.m_getDownIR() && timer.get() >= tempTimer + Constants.BRAKE_TIME){
      sub_intakeSubsystem.m_brake();
    }else{
      sub_intakeSubsystem.m_turnOffLower();
      //sub_intakeSubsystem.m_intake();
    }
   
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {    
    //sub_intakeSubsystem.m_turnOffWheel();
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
