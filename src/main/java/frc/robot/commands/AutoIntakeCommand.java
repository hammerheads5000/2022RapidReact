// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;


import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.FeedSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
public class AutoIntakeCommand extends CommandBase {
  private IntakeSubsystem sub_intakeSubsystem;
  private FeedSubsystem sub_feedSubsystem;

  private boolean shooterSideIRSensor;
  /** Creates a new AutoIntakeCommand. */
  public AutoIntakeCommand(IntakeSubsystem subsystem, FeedSubsystem subsystem2) {
    sub_intakeSubsystem = subsystem;
    sub_feedSubsystem = subsystem2;
    addRequirements(sub_intakeSubsystem, sub_feedSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooterSideIRSensor = sub_feedSubsystem.m_getShooterSideIRSensor();

    if(!shooterSideIRSensor){
      sub_feedSubsystem.m_intakeSideFeedMotor();
    }else if(shooterSideIRSensor){
      sub_feedSubsystem.m_intakeSideFeedMotor();
      sub_feedSubsystem.m_shooterSideFeedMotor();

    }else{
      sub_feedSubsystem.m_stopFeed();
    }

    if(!sub_intakeSubsystem.m_getUpIR()){
      sub_intakeSubsystem.m_lower();
    }else if(!sub_intakeSubsystem.m_getDownIR()){
      sub_intakeSubsystem.m_turnOffLower();
      sub_intakeSubsystem.m_intake();
    }else{
      sub_intakeSubsystem.m_brakeWayDown();
    }
    sub_intakeSubsystem.m_turnOffWheel();
    sub_feedSubsystem.m_stopFeed();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
