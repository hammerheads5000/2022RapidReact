// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

 
public class DriveTrainSubsystem extends SubsystemBase {
  //adapted from Team 6624

  //Motors
  private static TalonFX leftFrontDriveMotor = new TalonFX(Constants.LEFT_FRONT_DRIVE_MOTOR_PORT);
  private static TalonFX leftBackDriveMotor = new TalonFX(Constants.LEFT_BACK_DRIVE_MOTOR_PORT);
  private static TalonFX rightFrontDriveMotor = new TalonFX(Constants.RIGHT_FRONT_DRIVE_MOTOR_PORT);
  private static TalonFX rightBackDriveMotor = new TalonFX(Constants.RIGHT_BACK_DRIVE_MOTOR_PORT);



  public DriveTrainSubsystem(){
    leftFrontDriveMotor.setNeutralMode(NeutralMode.Brake);
    leftBackDriveMotor.setNeutralMode(NeutralMode.Brake);
    rightFrontDriveMotor.setNeutralMode(NeutralMode.Brake);
    rightBackDriveMotor.setNeutralMode(NeutralMode.Brake);
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
      leftFrontDriveMotor.set(TalonFXControlMode.PercentOutput, ADPower);
      leftBackDriveMotor.set(TalonFXControlMode.PercentOutput, BCPower);
      rightFrontDriveMotor.set(TalonFXControlMode.PercentOutput, -BCPower);
      rightBackDriveMotor.set(TalonFXControlMode.PercentOutput, -ADPower);
    }else{
      leftFrontDriveMotor.set(TalonFXControlMode.PercentOutput, (ADPower - turningScale) / turningScale);
      leftBackDriveMotor.set(TalonFXControlMode.PercentOutput, (BCPower - turningScale) / turningScale);
      rightFrontDriveMotor.set(TalonFXControlMode.PercentOutput, (BCPower + turningScale) / turningScale);
      rightBackDriveMotor.set(TalonFXControlMode.PercentOutput, (ADPower + turningScale) / turningScale);
    }

    //set the motors, and divide them by turning Scale to make sure none of them go over the top, which would alter the translation angles
  /*
    leftFrontDriveMotor.set(TalonFXControlMode.PercentOutput, (ADPower - turningScale) / turningScale);
    leftBackDriveMotor.set(TalonFXControlMode.PercentOutput, (BCPower - turningScale) / turningScale);
    rightFrontDriveMotor.set(TalonFXControlMode.PercentOutput, (BCPower + turningScale) / turningScale);
    rightBackDriveMotor.set(TalonFXControlMode.PercentOutput, (ADPower + turningScale) / turningScale);
    */
  }
 
}
