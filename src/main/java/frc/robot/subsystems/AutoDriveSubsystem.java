// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
/*
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
 */


public class AutoDriveSubsystem extends SubsystemBase {
  /** Creates a new AutoDriveSubsystem. */
  /*private static TalonFX leftFrontDriveMotor = new TalonFX(Constants.LEFT_FRONT_DRIVE_MOTOR_PORT);
  private static TalonFX leftBackDriveMotor = new TalonFX(Constants.LEFT_BACK_DRIVE_MOTOR_PORT);
  private static TalonFX rightFrontDriveMotor = new TalonFX(Constants.RIGHT_FRONT_DRIVE_MOTOR_PORT);
  private static TalonFX rightBackDriveMotor = new TalonFX(Constants.RIGHT_BACK_DRIVE_MOTOR_PORT);*/

  /*
  
double rpm = 6380;


//limelight isn't currently doing anything
 NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
 NetworkTableEntry ty = table.getEntry("ty");
  */
  public AutoDriveSubsystem() {
    /*leftFrontDriveMotor.setNeutralMode(NeutralMode.Coast);

    leftFrontDriveMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, Constants.AUTO_PID_LOOP_IDX, ConstAutoConstants_AUTO_TIMEOUT_MS);
    leftFrontDriveMotor.setSensorPhase(Constants.PHASE_SENSOR);
    leftFrontDriveMotor.configNominalOutputForward(0, AutoConstants.AUTO_TIMEOUT_MS);
		leftFrontDriveMotor.configNominalOutputReverse(0, AutoConstants.AUTO_TIMEOUT_MS);
		leftFrontDriveMotor.configPeakOutputForward(Constants.kGains.kPeakOutputShooter, AutoConstants.AUTO_TIMEOUT_MS);
		leftFrontDriveMotor.configPeakOutputReverse(-Constants.kGains.kPeakOutputShooter, AutoConstants.AUTO_TIMEOUT_MS);

		leftFrontDriveMotor.configAllowableClosedloopError(AutoConstants.AUTO_PID_LOOP_IDX, (Constants.K_SENSOR_UNITS_PER_ROTATION / 600.0) * Constants.SHOOTER_ERROR, AutoConstants.AUTO_TIMEOUT_MS);

		leftFrontDriveMotor.config_kF(AutoConstants.AUTO_PID_LOOP_IDX, Constants.kGains.kFShooter, AutoConstants.AUTO_TIMEOUT_MS);  
    leftFrontDriveMotor.config_kP(AutoConstants.AUTO_PID_LOOP_IDX, Constants.kGains.kPShooter, AutoConstants.AUTO_TIMEOUT_MS);
		leftFrontDriveMotor.config_kI(AutoConstants.AUTO_PID_LOOP_IDX, Constants.kGains.kIShooter, AutoConstants.AUTO_TIMEOUT_MS);
    leftFrontDriveMotor.config_kD(AutoConstants.AUTO_PID_LOOP_IDX, Constants.kGains.kDShooter, AutoConstants.AUTO_TIMEOUT_MS);*/

  }
  /*public void m_shoot()
  {
    double y = ty.getDouble(0.0);
    double heading_error = -y;

    //rpm = some funky equation
    
    SmartDashboard.putNumber("rpm", rpm);

    double motorSpeed = (Constants.K_SENSOR_UNITS_PER_ROTATION / 600.0) * rpm;
    //600 is a modifer to get min to 100 ms and 2048 gets rotations to units 
    //Right now I'm putting the motors at desired rpm for testing purposes 6380 or whatever number is after (2048 / 600) will change to rpm

    leftFrontDriveMotor.set(TalonFXControlMode.Velocity, -motorSpeed);

   SmartDashboard.putNumber("RPM", ( (600.0 / Constants.K_SENSOR_UNITS_PER_ROTATION) * leftFrontDriveMotor.getSelectedSensorVelocity()));
   
   String motorState;
   if(leftFrontDriveMotor.getSelectedSensorVelocity(AutoConstants.AUTO_PID_LOOP_IDX) > 0){
     motorState = "forward";
   }else if(leftFrontDriveMotor.getSelectedSensorVelocity(AutoConstants.AUTO_PID_LOOP_IDX) == 0){
     motorState = "stopped";
   }else{
     motorState = "reverse";
   }

   SmartDashboard.putString("Motor State", motorState);

  }
  public void m_stopSpinning()
  {
    leftFrontDriveMotor.set(TalonFXControlMode.PercentOutput, 0.0);
  }

  public void m_zeroEncoder(){
    leftFrontDriveMotor.setSelectedSensorPosition(0);
  }

  public double m_getPosition(){
    return leftFrontDriveMotor.getSelectedSensorPosition();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }*/
}
