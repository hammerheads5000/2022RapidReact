// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FeedSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class FeedInCommand extends CommandBase {
  /** Creates a new FeedInCommand. */
 
  private FeedSubsystem sub_feedSubsystem;
  private IntakeSubsystem sub_intakeSubsystem;
  //first IR sensor is close to flywheel
  private boolean intakeSideIRSensor, shooterSideIRSensor;
  
  public FeedInCommand(FeedSubsystem subsystem, IntakeSubsystem subsystem2) {
    // Use addRequirements() here to declare subsystem dependencies.
    sub_feedSubsystem = subsystem;
    sub_intakeSubsystem = subsystem2;
    addRequirements(sub_feedSubsystem, sub_intakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {   
   
    //firstIRSensor = sub_feedSubsystem.m_getSensor1();
    shooterSideIRSensor = sub_feedSubsystem.m_getShooterSideIRSensor();

    
    if(sub_intakeSubsystem.m_getRunning() && shooterSideIRSensor){
      sub_feedSubsystem.m_intakeSideFeedMotor();
    }else if(!shooterSideIRSensor && sub_intakeSubsystem.m_getRunning()){
      sub_feedSubsystem.m_intakeSideFeedMotor();
      sub_feedSubsystem.m_shooterSideFeedMotor();

    }else{
      sub_feedSubsystem.m_stopFeed();
    }
    
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
