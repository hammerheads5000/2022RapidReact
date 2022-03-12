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
    double power = translationPower;

    if (Math.abs(turnPower) <= Constants.TURN_DEADBAND){
      if(translationPower < Constants.TRANSLATION_DEADBAND){

      }else{
        power -= Constants.TRANSLATION_DEADBAND;
        power = power / (1 - Constants.TRANSLATION_DEADBAND); //1 is the max speed of the motor
        power = Math.pow(power, 2);
        ADPower = power * Math.sqrt(2) * 0.5 * (Math.sin(translationAngle) - Math.cos(translationAngle));
        BCPower = power * Math.sqrt(2) * 0.5 * (Math.sin(translationAngle) + Math.cos(translationAngle));

        leftFrontDriveMotor.set(TalonFXControlMode.PercentOutput, ADPower);
        leftBackDriveMotor.set(TalonFXControlMode.PercentOutput, BCPower);
        rightFrontDriveMotor.set(TalonFXControlMode.PercentOutput, -BCPower);
        rightBackDriveMotor.set(TalonFXControlMode.PercentOutput, -ADPower);
      }
    }else{

        //5 is to slow down the motors because turning shouldn't feel like you're an F1 racer
        if(turningScale < 0){
          turningScale += Constants.TURN_DEADBAND;
          turningScale = turningScale / (1 - Constants.TURN_DEADBAND);
        }else{
          turningScale -= Constants.TURN_DEADBAND;
          turningScale = turningScale / (1 - Constants.TURN_DEADBAND); //1 is the max speed of the motor
        }

        leftFrontDriveMotor.set(TalonFXControlMode.PercentOutput, -turningScale / 5.0);
        leftBackDriveMotor.set(TalonFXControlMode.PercentOutput, -turningScale / 5.0);
        rightFrontDriveMotor.set(TalonFXControlMode.PercentOutput, -turningScale / 5.0);
        rightBackDriveMotor.set(TalonFXControlMode.PercentOutput, -turningScale / 5.0);
    }
  }
 
}
