// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.*;


import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

 
public class DriveTrainSubsystem extends SubsystemBase {
  //adapted from Team 6624

  //Motors
  private static TalonFX LEFT_FRONT_DRIVE_MOTOR;
  private static TalonFX LEFT_BACK_DRIVE_MOTOR;
  private static TalonFX RIGHT_FRONT_DRIVE_MOTOR;
  private static TalonFX RIGHT_BACK_DRIVE_MOTOR;

/*

  public DriveTrainSubsystem(){
    //Motors
    LEFT_FRONT_DRIVE_MOTOR = new TalonFX(Constants.LEFT_FRONT_DRIVE_MOTOR_PORT);
    LEFT_BACK_DRIVE_MOTOR = new TalonFX(Constants.LEFT_BACK_DRIVE_MOTOR_PORT);
    RIGHT_FRONT_DRIVE_MOTOR = new TalonFX(Constants.RIGHT_FRONT_DRIVE_MOTOR_PORT);
    RIGHT_BACK_DRIVE_MOTOR = new TalonFX(Constants.RIGHT_BACK_DRIVE_MOTOR_PORT);


  }
  public static void setMecanumDrive(double translationAngle, double translationPower, double turnPower){
    //A is front left, b is front right, c is back left, d is back right
    // calculate motor power
    //Math.sqrt(2) * 0.5 comes from sin(45) and cos(45) (trig is necessary to get the power in mecanum)
    double ADPower = translationPower * Math.sqrt(2) * 0.5 * (Math.sin(translationAngle) + Math.cos(translationAngle));
    double BCPower = translationPower * Math.sqrt(2) * 0.5 * (Math.sin(translationAngle) - Math.cos(translationAngle));

    //check if turning power will interfere with normal translation
    //check ADPower to see if trying to apply turnPower would put motor power over 1.0 or under -1.0
    double turningScale = Math.max(Math.abs(ADPower + turnPower), Math.abs(ADPower - turnPower));
    //check BCPower to see if trying to apply turnPower would put motor power over 1.0 or under -1.0
    turningScale = Math.max(turningScale, Math.max(Math.abs(BCPower + turnPower), Math.abs(BCPower - turnPower)));

    //adjust turn power scale correctly --- 1.0 is the max power of the motor.
    if (Math.abs(turningScale) < 1.0){
      turningScale = 1.0;
    }

    //set the motors, and divide them by turning Scale to make sure none of them go over the top, which would alter the translation angles
    LEFT_FRONT_DRIVE_MOTOR.set(TalonFXControlMode.PercentOutput, (ADPower - turningScale) / turningScale);
    LEFT_BACK_DRIVE_MOTOR.set(TalonFXControlMode.PercentOutput, (BCPower - turningScale) / turningScale);
    RIGHT_FRONT_DRIVE_MOTOR.set(TalonFXControlMode.PercentOutput, (BCPower + turningScale) / turningScale);
    RIGHT_BACK_DRIVE_MOTOR.set(TalonFXControlMode.PercentOutput, (ADPower + turningScale) / turningScale);
  }
*/
}
