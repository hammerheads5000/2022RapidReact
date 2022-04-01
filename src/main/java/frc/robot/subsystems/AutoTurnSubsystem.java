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
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.AutoConstants;

import javax.management.openmbean.OpenMBeanConstructorInfoSupport;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;



 


public class AutoTurnSubsystem extends SubsystemBase {
  /** Creates a new AutoTurnSubsystem. */
  //(x units/100ms) = (rpm * Constants.K_SENSOR_UNITS_PER_ROTATION/600(units/100ms))

  private static ADXRS450_Gyro gyro = new ADXRS450_Gyro();
  private static TalonFX leftFrontDriveMotor = new TalonFX(Constants.LEFT_FRONT_DRIVE_MOTOR_PORT);
  private static TalonFX leftBackDriveMotor = new TalonFX(Constants.LEFT_BACK_DRIVE_MOTOR_PORT);
  private static TalonFX rightFrontDriveMotor = new TalonFX(Constants.RIGHT_FRONT_DRIVE_MOTOR_PORT);
  private static TalonFX rightBackDriveMotor = new TalonFX(Constants.RIGHT_BACK_DRIVE_MOTOR_PORT);
  private static double error = 0;
  private static double output;
  private static double setpoint;
  private static double currentAngle;
  private static double totalError = 0;
  private static double previousError;
  private static double changeInError;
double rpm = 6380;//dont know we'll find that later


//limelight isn't currently doing anything
 NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
 NetworkTableEntry ty = table.getEntry("ty");
 //probably not gonna apply at all ^
  
  public AutoTurnSubsystem() {
    
    leftFrontDriveMotor.setNeutralMode(NeutralMode.Coast);
    leftFrontDriveMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.AUTO_TIMEOUT_MS);
    leftFrontDriveMotor.setSensorPhase(Constants.PHASE_SENSOR);
    leftFrontDriveMotor.configNominalOutputForward(0, AutoConstants.AUTO_TIMEOUT_MS);
		leftFrontDriveMotor.configNominalOutputReverse(0, AutoConstants.AUTO_TIMEOUT_MS);
		leftFrontDriveMotor.configPeakOutputForward(AutoConstants.tGains.kPeakOutputTurn, AutoConstants.AUTO_TIMEOUT_MS);
		leftFrontDriveMotor.configPeakOutputReverse(-AutoConstants.tGains.kPeakOutputTurn, AutoConstants.AUTO_TIMEOUT_MS);
		leftFrontDriveMotor.configAllowableClosedloopError(AutoConstants.AUTO_PID_LOOP_IDX, 2048, AutoConstants.AUTO_TIMEOUT_MS);
		leftFrontDriveMotor.config_kF(AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.tGains.kFTurn, AutoConstants.AUTO_TIMEOUT_MS);  
    leftFrontDriveMotor.config_kP(AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.tGains.kPTurn, AutoConstants.AUTO_TIMEOUT_MS);
		leftFrontDriveMotor.config_kI(AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.tGains.kITurn, AutoConstants.AUTO_TIMEOUT_MS);
    leftFrontDriveMotor.config_kD(AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.tGains.kDTurn, AutoConstants.AUTO_TIMEOUT_MS);
    
    rightFrontDriveMotor.setNeutralMode(NeutralMode.Coast);
    rightFrontDriveMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.AUTO_TIMEOUT_MS);
    rightFrontDriveMotor.setSensorPhase(Constants.PHASE_SENSOR);
    rightFrontDriveMotor.configNominalOutputForward(0, AutoConstants.AUTO_TIMEOUT_MS);
		rightFrontDriveMotor.configNominalOutputReverse(0, AutoConstants.AUTO_TIMEOUT_MS);
		rightFrontDriveMotor.configPeakOutputForward(AutoConstants.tGains.kPeakOutputTurn, AutoConstants.AUTO_TIMEOUT_MS);
		rightFrontDriveMotor.configPeakOutputReverse(-AutoConstants.tGains.kPeakOutputTurn, AutoConstants.AUTO_TIMEOUT_MS);
		rightFrontDriveMotor.configAllowableClosedloopError(AutoConstants.AUTO_PID_LOOP_IDX, 2048, AutoConstants.AUTO_TIMEOUT_MS);
		rightFrontDriveMotor.config_kF(AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.tGains.kFTurn, AutoConstants.AUTO_TIMEOUT_MS);  
    rightFrontDriveMotor.config_kP(AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.tGains.kPTurn, AutoConstants.AUTO_TIMEOUT_MS);
		rightFrontDriveMotor.config_kI(AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.tGains.kITurn, AutoConstants.AUTO_TIMEOUT_MS);
    rightFrontDriveMotor.config_kD(AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.tGains.kDTurn, AutoConstants.AUTO_TIMEOUT_MS);
  
    leftBackDriveMotor.setNeutralMode(NeutralMode.Coast);
    leftBackDriveMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.AUTO_TIMEOUT_MS);
    leftBackDriveMotor.setSensorPhase(Constants.PHASE_SENSOR);
    leftBackDriveMotor.configNominalOutputForward(0, AutoConstants.AUTO_TIMEOUT_MS);
		leftBackDriveMotor.configNominalOutputReverse(0, AutoConstants.AUTO_TIMEOUT_MS);
		leftBackDriveMotor.configPeakOutputForward(AutoConstants.tGains.kPeakOutputTurn, AutoConstants.AUTO_TIMEOUT_MS);
	  leftBackDriveMotor.configPeakOutputReverse(-AutoConstants.tGains.kPeakOutputTurn, AutoConstants.AUTO_TIMEOUT_MS);
		leftBackDriveMotor.configAllowableClosedloopError(AutoConstants.AUTO_PID_LOOP_IDX, 2048, AutoConstants.AUTO_TIMEOUT_MS);
		leftBackDriveMotor.config_kF(AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.tGains.kFTurn, AutoConstants.AUTO_TIMEOUT_MS);  
    leftBackDriveMotor.config_kP(AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.tGains.kPTurn, AutoConstants.AUTO_TIMEOUT_MS);
		leftBackDriveMotor.config_kI(AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.tGains.kITurn, AutoConstants.AUTO_TIMEOUT_MS);
    leftBackDriveMotor.config_kD(AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.tGains.kDTurn, AutoConstants.AUTO_TIMEOUT_MS);
    
    rightBackDriveMotor.setNeutralMode(NeutralMode.Coast);
    rightBackDriveMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.AUTO_TIMEOUT_MS);
    rightBackDriveMotor.setSensorPhase(Constants.PHASE_SENSOR);
    rightBackDriveMotor.configNominalOutputForward(0, AutoConstants.AUTO_TIMEOUT_MS);
		rightBackDriveMotor.configNominalOutputReverse(0, AutoConstants.AUTO_TIMEOUT_MS);
		rightBackDriveMotor.configPeakOutputForward(AutoConstants.tGains.kPeakOutputTurn, AutoConstants.AUTO_TIMEOUT_MS);
		rightBackDriveMotor.configPeakOutputReverse(-AutoConstants.tGains.kPeakOutputTurn, AutoConstants.AUTO_TIMEOUT_MS);
		rightBackDriveMotor.configAllowableClosedloopError(AutoConstants.AUTO_PID_LOOP_IDX, 2048, AutoConstants.AUTO_TIMEOUT_MS);
		rightBackDriveMotor.config_kF(AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.tGains.kFTurn, AutoConstants.AUTO_TIMEOUT_MS);  
    rightBackDriveMotor.config_kP(AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.tGains.kPTurn, AutoConstants.AUTO_TIMEOUT_MS);
		rightBackDriveMotor.config_kI(AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.tGains.kITurn, AutoConstants.AUTO_TIMEOUT_MS);
    rightBackDriveMotor.config_kD(AutoConstants.AUTO_PID_LOOP_IDX, AutoConstants.tGains.kDTurn, AutoConstants.AUTO_TIMEOUT_MS);
  }
 
  
  public void m_turn(boolean right, double degrees)
  {
    double setpoint = degrees;

    if (right){
    leftFrontDriveMotor.set(TalonFXControlMode.Position, setpoint);
    rightFrontDriveMotor.set(TalonFXControlMode.Position, setpoint);
    leftBackDriveMotor.set(TalonFXControlMode.Position, setpoint);
    rightBackDriveMotor.set(TalonFXControlMode.Position, setpoint);
    }
    else{
    leftFrontDriveMotor.set(TalonFXControlMode.Position, -setpoint);
    rightFrontDriveMotor.set(TalonFXControlMode.Position, -setpoint);
    leftBackDriveMotor.set(TalonFXControlMode.Position, -setpoint);
    rightBackDriveMotor.set(TalonFXControlMode.Position, -setpoint);
    }

  }
  
  public void m_stopSpinning()
  {
    leftFrontDriveMotor.set(TalonFXControlMode.PercentOutput, 0.0);
    rightFrontDriveMotor.set(TalonFXControlMode.PercentOutput, 0.0);
    leftBackDriveMotor.set(TalonFXControlMode.PercentOutput, 0.0);
    rightBackDriveMotor.set(TalonFXControlMode.PercentOutput, 0.0);
  }

  public void m_zeroEncoder(){
    leftFrontDriveMotor.setSelectedSensorPosition(0);
    rightFrontDriveMotor.setSelectedSensorPosition(0);
    leftBackDriveMotor.setSelectedSensorPosition(0);
    rightBackDriveMotor.setSelectedSensorPosition(0);
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
    /*
    currentAngle = gyro.getAngle();
    previousError = error;
    error = (setpoint - currentAngle) / 360;
    changeInError = error - previousError;
    totalError += error;

    output = AutoConstants.tGains.kPTurn * error + AutoConstants.tGains.kITurn * totalError + AutoConstants.tGains.kDTurn * changeInError;
    leftFrontDriveMotor.set(TalonFXControlMode.Position, output);
    rightFrontDriveMotor.set(TalonFXControlMode.Position, output);
    leftBackDriveMotor.set(TalonFXControlMode.Position, output);
    rightBackDriveMotor.set(TalonFXControlMode.Position, output);
    */
  }
}

