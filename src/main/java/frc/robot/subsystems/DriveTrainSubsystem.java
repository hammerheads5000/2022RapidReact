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
    double ADPower;
    double BCPower;

    double turningScale = turnPower;
    //0.3 and 0.4 are deadband values
    if (Math.abs(turnPower) <= 0.3){ //TODO: Make deadbands variables
      if(translationPower < 0.4){
        leftFrontDriveMotor.set(TalonFXControlMode.PercentOutput, 0);
        leftBackDriveMotor.set(TalonFXControlMode.PercentOutput, 0);
        rightFrontDriveMotor.set(TalonFXControlMode.PercentOutput, 0);
        rightBackDriveMotor.set(TalonFXControlMode.PercentOutput, 0);
      }else{
        translationPower -= 0.4;
        ADPower = translationPower * Math.sqrt(2) * 0.5 * (Math.sin(translationAngle) - Math.cos(translationAngle));
        BCPower = translationPower * Math.sqrt(2) * 0.5 * (Math.sin(translationAngle) + Math.cos(translationAngle));

      leftFrontDriveMotor.set(TalonFXControlMode.PercentOutput, ADPower);
      leftBackDriveMotor.set(TalonFXControlMode.PercentOutput, BCPower);
      rightFrontDriveMotor.set(TalonFXControlMode.PercentOutput, -BCPower);
      rightBackDriveMotor.set(TalonFXControlMode.PercentOutput, -ADPower);
      }
    }else{
      //5 is to slow down the motors because turning shouldn't feel like you're an F1 racer
      leftFrontDriveMotor.set(TalonFXControlMode.PercentOutput, -turningScale / 5.0);
      leftBackDriveMotor.set(TalonFXControlMode.PercentOutput, -turningScale / 5.0);
      rightFrontDriveMotor.set(TalonFXControlMode.PercentOutput, -turningScale / 5.0);
      rightBackDriveMotor.set(TalonFXControlMode.PercentOutput, -turningScale / 5.0);
    }
  }
 
}
