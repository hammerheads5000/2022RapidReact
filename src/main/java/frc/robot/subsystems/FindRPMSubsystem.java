// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FindRPMSubsystem extends SubsystemBase {
  /** Creates a new FindRPMSubsystem. */
  static double rpm = 0.0;
  public FindRPMSubsystem() {}


  public void calculateRPM(){
    //Here we will use limelight to calculate the rpm, for now it will just set a value.
    rpm = 5500;
  }

  public double getRPM(){
    return rpm;
  }
}
