// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.AutoConstants;
import frc.robot.subsystems.FeedSubsystem;

public class AutoFeedInManualCommand extends CommandBase {
  /** Creates a new FeedInManualCommand. */
  private FeedSubsystem sub_feedSubsystem;
  Timer timer = new Timer();
  public AutoFeedInManualCommand(FeedSubsystem subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    sub_feedSubsystem = subsystem;
    addRequirements(sub_feedSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    //TODO: record auto
    if(timer.get() >= AutoConstants.AUTO_FEED_WAIT_TIME){
      sub_feedSubsystem.m_feedInManual();
    }
    /*
    if (Math.abs(SmartDashboard.getEntry("Actual RPM").getDouble(4500)) > Math.abs(SmartDashboard.getEntry("Requested RPM").getDouble(4500)) - 100){
    sub_feedSubsystem.m_feedInManual();
   }
   */
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    sub_feedSubsystem.m_stopFeed();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //This may not be necessary depending on how parallel command groups work
    if(timer.get() >= AutoConstants.EASY_AUTO_TIME_LIMIT){
      return true;
    }else{
      return false;
    }
  }
}
