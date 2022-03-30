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
import frc.robot.AutoConstants;
import frc.robot.Constants;

 
public class DriveTrainSubsystem extends SubsystemBase {
  //adapted from Team 6624

  //Motors
  private static TalonFX leftFrontDriveMotor = new TalonFX(Constants.LEFT_FRONT_DRIVE_MOTOR_PORT);
  private static TalonFX leftBackDriveMotor = new TalonFX(Constants.LEFT_BACK_DRIVE_MOTOR_PORT);
  private static TalonFX rightFrontDriveMotor = new TalonFX(Constants.RIGHT_FRONT_DRIVE_MOTOR_PORT);
  private static TalonFX rightBackDriveMotor = new TalonFX(Constants.RIGHT_BACK_DRIVE_MOTOR_PORT);

  public void DriveTrainSubsystemInit(){
    leftFrontDriveMotor.configPeakOutputForward(1.0, AutoConstants.AUTO_TIMEOUT_MS);
    leftFrontDriveMotor.configPeakOutputReverse(-1.0, AutoConstants.AUTO_TIMEOUT_MS);
    rightFrontDriveMotor.configPeakOutputForward(1.0, AutoConstants.AUTO_TIMEOUT_MS);
    rightFrontDriveMotor.configPeakOutputReverse(-1.0, AutoConstants.AUTO_TIMEOUT_MS);
    leftBackDriveMotor.configPeakOutputForward(1.0, AutoConstants.AUTO_TIMEOUT_MS);
    leftBackDriveMotor.configPeakOutputReverse(-1.0, AutoConstants.AUTO_TIMEOUT_MS);
    rightBackDriveMotor.configPeakOutputForward(1.0, AutoConstants.AUTO_TIMEOUT_MS);
    rightBackDriveMotor.configPeakOutputReverse(-1.0, AutoConstants.AUTO_TIMEOUT_MS);
    leftFrontDriveMotor.setNeutralMode(NeutralMode.Coast);
    leftBackDriveMotor.setNeutralMode(NeutralMode.Coast);
    rightFrontDriveMotor.setNeutralMode(NeutralMode.Coast);
    rightBackDriveMotor.setNeutralMode(NeutralMode.Coast);
  }

  public DriveTrainSubsystem(){
    leftFrontDriveMotor.configPeakOutputForward(1.0, AutoConstants.AUTO_TIMEOUT_MS);
    leftFrontDriveMotor.configPeakOutputReverse(-1.0, AutoConstants.AUTO_TIMEOUT_MS);
    rightFrontDriveMotor.configPeakOutputForward(1.0, AutoConstants.AUTO_TIMEOUT_MS);
    rightFrontDriveMotor.configPeakOutputReverse(-1.0, AutoConstants.AUTO_TIMEOUT_MS);
    leftBackDriveMotor.configPeakOutputForward(1.0, AutoConstants.AUTO_TIMEOUT_MS);
    leftBackDriveMotor.configPeakOutputReverse(-1.0, AutoConstants.AUTO_TIMEOUT_MS);
    rightBackDriveMotor.configPeakOutputForward(1.0, AutoConstants.AUTO_TIMEOUT_MS);
    rightBackDriveMotor.configPeakOutputReverse(-1.0, AutoConstants.AUTO_TIMEOUT_MS);
    leftFrontDriveMotor.setNeutralMode(NeutralMode.Coast);
    leftBackDriveMotor.setNeutralMode(NeutralMode.Coast);
    rightFrontDriveMotor.setNeutralMode(NeutralMode.Coast);
    rightBackDriveMotor.setNeutralMode(NeutralMode.Coast);
  }
  public static void setMecanumDrive(double translationAngle, double translationPower, double turnPower){
    //A is front left, b is front right, c is back left, d is back right
    // calculate motor power
    //Math.sqrt(2) * 0.5 comes from sin(45) and cos(45) (trig is necessary to get the power in mecanum)

    SmartDashboard.putNumber("Translation Angle", translationAngle);
    SmartDashboard.putNumber("Translation Power", translationPower);
    SmartDashboard.putNumber("turn power", turnPower);
    double ADPower;
    double BCPower;

    double turningScale = turnPower;
    double power = translationPower;

    SmartDashboard.putNumber("DrivePosition", leftFrontDriveMotor.getSelectedSensorPosition());


    if(translationPower > Constants.TRANSLATION_DEADBAND || Math.abs(turningScale) > Constants.TURN_DEADBAND){
      power -= Constants.TRANSLATION_DEADBAND;
      power = power / (1 - Constants.TRANSLATION_DEADBAND); //1 is the max speed of the motor
      ADPower = power * (Math.sin(translationAngle) - Math.cos(translationAngle));
      BCPower = power * (Math.sin(translationAngle) + Math.cos(translationAngle));
      if(turningScale > 0){
        leftFrontDriveMotor.set(TalonFXControlMode.PercentOutput, ADPower * (1 + Math.abs(turningScale)));
        leftBackDriveMotor.set(TalonFXControlMode.PercentOutput, BCPower * (1 + Math.abs(turningScale)));
        rightFrontDriveMotor.set(TalonFXControlMode.PercentOutput, -BCPower * Math.abs(turningScale));
        rightBackDriveMotor.set(TalonFXControlMode.PercentOutput, -ADPower * Math.abs(turningScale));
      }else if(turningScale < 0){
        leftFrontDriveMotor.set(TalonFXControlMode.PercentOutput, ADPower * Math.abs(turningScale));
        leftBackDriveMotor.set(TalonFXControlMode.PercentOutput, BCPower * Math.abs(turningScale));
        rightFrontDriveMotor.set(TalonFXControlMode.PercentOutput, -BCPower * (1 + Math.abs(turningScale)));
        rightBackDriveMotor.set(TalonFXControlMode.PercentOutput, -ADPower * (1 + Math.abs(turningScale)));
      }else{
        leftFrontDriveMotor.set(TalonFXControlMode.PercentOutput, ADPower);
        leftBackDriveMotor.set(TalonFXControlMode.PercentOutput, BCPower);
        rightFrontDriveMotor.set(TalonFXControlMode.PercentOutput, -BCPower);
        rightBackDriveMotor.set(TalonFXControlMode.PercentOutput, -ADPower);
      }

      leftFrontDriveMotor.set(TalonFXControlMode.PercentOutput, ADPower);
      leftBackDriveMotor.set(TalonFXControlMode.PercentOutput, BCPower);
      rightFrontDriveMotor.set(TalonFXControlMode.PercentOutput, -BCPower);
      rightBackDriveMotor.set(TalonFXControlMode.PercentOutput, -ADPower);
    }
  }

}
