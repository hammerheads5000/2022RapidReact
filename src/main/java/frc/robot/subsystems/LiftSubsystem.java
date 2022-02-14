// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import java.lang.Math;

public class LiftSubsystem extends SubsystemBase {
  private static TalonFX liftMotor = new TalonFX(Constants.LIFT_MOTOR_PORT);
  public LiftSubsystem() {
    liftMotor.setNeutralMode(NeutralMode.Brake);
  }

  public void m_liftUp(){
    //This finds the number of rotations required to reach the lift distance multiplied by the number of encoder things on the motor
    double numberOfRotations = Constants.LIFT_DISTANCE / (Constants.MOTOR_SHAFT_DIAMETER * Math.PI);
    liftMotor.setSelectedSensorPosition(numberOfRotations * 2048);
  }

  public void m_liftDown(){
    liftMotor.set(TalonFXControlMode.PercentOutput, Constants.LIFT_DOWN_SPEED);
  }
  
}
