// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

//package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.AutoConstants;

import com.ctre.phoenix.ErrorCode;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;



 


public class AutoDriveSubsystem extends SubsystemBase {
  /** Creates a new AutoDriveSubsystem. */
  //(x units/100ms) = (rpm * Constants.K_SENSOR_UNITS_PER_ROTATION/600(units/100ms))

  private static Accelerometer accelerometer = new BuiltInAccelerometer();
  private static double prevXAccel = 0;
  private static double prevYAccel = 0;
  private static TalonFX leftFrontDriveMotor = new TalonFX(Constants.LEFT_FRONT_DRIVE_MOTOR_PORT);
  
  private static TalonFX leftBackDriveMotor = new TalonFX(Constants.LEFT_BACK_DRIVE_MOTOR_PORT);
  private static TalonFX rightFrontDriveMotor = new TalonFX(Constants.RIGHT_FRONT_DRIVE_MOTOR_PORT);
  private static TalonFX rightBackDriveMotor = new TalonFX(Constants.RIGHT_BACK_DRIVE_MOTOR_PORT);
  private static boolean hasCollided = false;
  
  
double rpm = 6380;//dont know we'll find that later


//limelight isn't currently doing anything
 NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
 NetworkTableEntry ty = table.getEntry("ty");
 //probably not gonna apply at all ^
  
  public AutoDriveSubsystem() {
    
    
    leftFrontDriveMotor.setNeutralMode(NeutralMode.Brake);
    leftFrontDriveMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.AUTO_TIMEOUT_MS);
    leftFrontDriveMotor.setSensorPhase(Constants.PHASE_SENSOR);
    leftFrontDriveMotor.configNominalOutputForward(0, AutoConstants.AUTO_TIMEOUT_MS);
		leftFrontDriveMotor.configNominalOutputReverse(0, AutoConstants.AUTO_TIMEOUT_MS);
		leftFrontDriveMotor.configPeakOutputForward(AutoConstants.aGains.kPeakOutputAuto, AutoConstants.AUTO_TIMEOUT_MS);
		leftFrontDriveMotor.configPeakOutputReverse(-AutoConstants.aGains.kPeakOutputAuto, AutoConstants.AUTO_TIMEOUT_MS);
		leftFrontDriveMotor.configAllowableClosedloopError(AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.AUTO_ERROR, AutoConstants.AUTO_TIMEOUT_MS);
		leftFrontDriveMotor.config_kF(AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.aGains.kFAuto, AutoConstants.AUTO_TIMEOUT_MS);  
    leftFrontDriveMotor.config_kP(AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.aGains.kPAuto, AutoConstants.AUTO_TIMEOUT_MS);
		leftFrontDriveMotor.config_kI(AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.aGains.kIAuto, AutoConstants.AUTO_TIMEOUT_MS);
    leftFrontDriveMotor.config_kD(AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.aGains.kDAuto, AutoConstants.AUTO_TIMEOUT_MS);
    


    rightFrontDriveMotor.setNeutralMode(NeutralMode.Brake);
    rightFrontDriveMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.AUTO_TIMEOUT_MS);
    rightFrontDriveMotor.setSensorPhase(Constants.PHASE_SENSOR);
    rightFrontDriveMotor.configNominalOutputForward(0, AutoConstants.AUTO_TIMEOUT_MS);
		rightFrontDriveMotor.configNominalOutputReverse(0, AutoConstants.AUTO_TIMEOUT_MS);
		rightFrontDriveMotor.configPeakOutputForward(AutoConstants.aGains.kPeakOutputAuto, AutoConstants.AUTO_TIMEOUT_MS);
		rightFrontDriveMotor.configPeakOutputReverse(-AutoConstants.aGains.kPeakOutputAuto, AutoConstants.AUTO_TIMEOUT_MS);
		rightFrontDriveMotor.configAllowableClosedloopError(AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.AUTO_ERROR, AutoConstants.AUTO_TIMEOUT_MS);
		rightFrontDriveMotor.config_kF(AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.aGains.kFAuto, AutoConstants.AUTO_TIMEOUT_MS);  
    rightFrontDriveMotor.config_kP(AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.aGains.kPAuto, AutoConstants.AUTO_TIMEOUT_MS);
		rightFrontDriveMotor.config_kI(AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.aGains.kIAuto, AutoConstants.AUTO_TIMEOUT_MS);
    rightFrontDriveMotor.config_kD(AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.aGains.kDAuto, AutoConstants.AUTO_TIMEOUT_MS);
  
    leftBackDriveMotor.setNeutralMode(NeutralMode.Brake);
    leftBackDriveMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.AUTO_TIMEOUT_MS);
    leftBackDriveMotor.setSensorPhase(Constants.PHASE_SENSOR);
    leftBackDriveMotor.configNominalOutputForward(0, AutoConstants.AUTO_TIMEOUT_MS);
		leftBackDriveMotor.configNominalOutputReverse(0, AutoConstants.AUTO_TIMEOUT_MS);
		leftBackDriveMotor.configPeakOutputForward(AutoConstants.aGains.kPeakOutputAuto, AutoConstants.AUTO_TIMEOUT_MS);
	  leftBackDriveMotor.configPeakOutputReverse(-AutoConstants.aGains.kPeakOutputAuto, AutoConstants.AUTO_TIMEOUT_MS);
		leftBackDriveMotor.configAllowableClosedloopError(AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.AUTO_ERROR, AutoConstants.AUTO_TIMEOUT_MS);
		leftBackDriveMotor.config_kF(AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.aGains.kFAuto, AutoConstants.AUTO_TIMEOUT_MS);  
    leftBackDriveMotor.config_kP(AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.aGains.kPAuto, AutoConstants.AUTO_TIMEOUT_MS);
		leftBackDriveMotor.config_kI(AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.aGains.kIAuto, AutoConstants.AUTO_TIMEOUT_MS);
    leftBackDriveMotor.config_kD(AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.aGains.kDAuto, AutoConstants.AUTO_TIMEOUT_MS);
  
    rightBackDriveMotor.setNeutralMode(NeutralMode.Brake);
    rightBackDriveMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.AUTO_TIMEOUT_MS);
    rightBackDriveMotor.setSensorPhase(Constants.PHASE_SENSOR);
    rightBackDriveMotor.configNominalOutputForward(0, AutoConstants.AUTO_TIMEOUT_MS);
		rightBackDriveMotor.configNominalOutputReverse(0, AutoConstants.AUTO_TIMEOUT_MS);
		rightBackDriveMotor.configPeakOutputForward(AutoConstants.aGains.kPeakOutputAuto, AutoConstants.AUTO_TIMEOUT_MS);
		rightBackDriveMotor.configPeakOutputReverse(-AutoConstants.aGains.kPeakOutputAuto, AutoConstants.AUTO_TIMEOUT_MS);
		rightBackDriveMotor.configAllowableClosedloopError(AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.AUTO_ERROR, AutoConstants.AUTO_TIMEOUT_MS);
		rightBackDriveMotor.config_kF(AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.aGains.kFAuto, AutoConstants.AUTO_TIMEOUT_MS);  
    rightBackDriveMotor.config_kP(AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.aGains.kPAuto, AutoConstants.AUTO_TIMEOUT_MS);
		rightBackDriveMotor.config_kI(AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.aGains.kIAuto, AutoConstants.AUTO_TIMEOUT_MS);
    rightBackDriveMotor.config_kD(AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.aGains.kDAuto, AutoConstants.AUTO_TIMEOUT_MS);
  }
  public void m_drive(double setpoint)
  {


    leftFrontDriveMotor.set(TalonFXControlMode.Position, setpoint);
    rightFrontDriveMotor.set(TalonFXControlMode.Position, -setpoint);
    leftBackDriveMotor.set(TalonFXControlMode.Position, setpoint);
    rightBackDriveMotor.set(TalonFXControlMode.Position, -setpoint);
  

  }
  
  public void m_stopSpinning()
  {
    leftFrontDriveMotor.set(TalonFXControlMode.PercentOutput, 0.0);
    rightFrontDriveMotor.set(TalonFXControlMode.PercentOutput, 0.0);
    leftBackDriveMotor.set(TalonFXControlMode.PercentOutput, 0.0);
    rightBackDriveMotor.set(TalonFXControlMode.PercentOutput, 0.0);
  }

  public void m_zeroEncoder(){
    ErrorCode error =
    leftFrontDriveMotor.setSelectedSensorPosition(0, AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.AUTO_TIMEOUT_MS);
    rightFrontDriveMotor.setSelectedSensorPosition(0, AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.AUTO_TIMEOUT_MS);
    leftBackDriveMotor.setSelectedSensorPosition(0, AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.AUTO_TIMEOUT_MS);
    rightBackDriveMotor.setSelectedSensorPosition(0, AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.AUTO_TIMEOUT_MS);
    SmartDashboard.putString("Error code", " " + error);
  }

  public static boolean getCollided(){
    return hasCollided;
  }

  public static double m_getFrontLeftPosition(){
    return leftFrontDriveMotor.getSelectedSensorPosition();
  }

  public static double m_getFrontRightPosition(){
    return rightFrontDriveMotor.getSelectedSensorPosition();
  }

  public static double m_getBackLeftPosition(){
    return leftBackDriveMotor.getSelectedSensorPosition();
  }

  public static double m_getBackRightPosition(){
    return rightBackDriveMotor.getSelectedSensorPosition();
  }

  @Override
  public void periodic() {
    //SmartDashboard.putString("LFMode",""+leftFrontDriveMotor.getControlMode());
    /*
    double xAccel = accelerometer.getX();

    double yAccel = accelerometer.getY();

    // Calculates the jerk in the X and Y directions
    // Divides by .02 because default loop timing is 20ms
    double xJerk = (xAccel - prevXAccel)/.02;
    double yJerk = (yAccel - prevYAccel)/.02;    
    SmartDashboard.putNumber("X Jerk", xJerk);
    SmartDashboard.putNumber("Y Jerk", yJerk);

    prevXAccel = xAccel;
    prevYAccel = yAccel;
    if (xJerk > AutoConstants.MAXIMUM_JERK_AUTO || yJerk > AutoConstants.MAXIMUM_JERK_AUTO){
      hasCollided = true;
    }*/
    
  }
}
