// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.IntakeSubsystem;

public class RaiseIntakeCommand extends CommandBase {
  /** Creates a new RaiseIntakeCommand. */
  private IntakeSubsystem sub_intakeSubsystem;
  Timer timer = new Timer();
  private double tempTimer = 0;
  public RaiseIntakeCommand(IntakeSubsystem subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    sub_intakeSubsystem = subsystem;
    addRequirements(sub_intakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.start();
   tempTimer = timer.get();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute(){
    if(!sub_intakeSubsystem.m_getEndOfMatch()){
      if(!sub_intakeSubsystem.m_getDownIR() || timer.get() < tempTimer + Constants.RAISE_UP_TIME){
        sub_intakeSubsystem.m_raise();
      }else if(!sub_intakeSubsystem.m_getUpIR()){
        sub_intakeSubsystem.m_turnOffLower();
      }else{
        sub_intakeSubsystem.m_brakeWayUp();
      }
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
