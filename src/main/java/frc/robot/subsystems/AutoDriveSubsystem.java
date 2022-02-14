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
  //private static TalonFX shooterMotor = new TalonFX(Constants.SHOOTER_MOTOR_PORT);
  /*
  
double rpm = 6380;


//limelight isn't currently doing anything
 NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
 NetworkTableEntry ty = table.getEntry("ty");
  */
  public AutoDriveSubsystem() {
    /*shooterMotor.setNeutralMode(NeutralMode.Coast);

    shooterMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, Constants.PID_LOOP_IDX, Constants.TIMEOUT_MS);
    shooterMotor.setSensorPhase(Constants.PHASE_SENSOR);
    shooterMotor.configNominalOutputForward(0, Constants.TIMEOUT_MS);
		shooterMotor.configNominalOutputReverse(0, Constants.TIMEOUT_MS);
		shooterMotor.configPeakOutputForward(Constants.kGains.kPeakOutputShooter, Constants.TIMEOUT_MS);
		shooterMotor.configPeakOutputReverse(-Constants.kGains.kPeakOutputShooter, Constants.TIMEOUT_MS);

		shooterMotor.configAllowableClosedloopError(Constants.PID_LOOP_IDX, (Constants.K_SENSOR_UNITS_PER_ROTATION / 600.0) * Constants.SHOOTER_ERROR, Constants.TIMEOUT_MS);

		shooterMotor.config_kF(Constants.PID_LOOP_IDX, Constants.kGains.kFShooter, Constants.TIMEOUT_MS);  
    shooterMotor.config_kP(Constants.PID_LOOP_IDX, Constants.kGains.kPShooter, Constants.TIMEOUT_MS);
		shooterMotor.config_kI(Constants.PID_LOOP_IDX, Constants.kGains.kIShooter, Constants.TIMEOUT_MS);
    shooterMotor.config_kD(Constants.PID_LOOP_IDX, Constants.kGains.kDShooter, Constants.TIMEOUT_MS);*/

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

    shooterMotor.set(TalonFXControlMode.Velocity, -motorSpeed);

   SmartDashboard.putNumber("RPM", ( (600.0 / Constants.K_SENSOR_UNITS_PER_ROTATION) * shooterMotor.getSelectedSensorVelocity()));
   
   String motorState;
   if(shooterMotor.getSelectedSensorVelocity(Constants.PID_LOOP_IDX) > 0){
     motorState = "forward";
   }else if(shooterMotor.getSelectedSensorVelocity(Constants.PID_LOOP_IDX) == 0){
     motorState = "stopped";
   }else{
     motorState = "reverse";
   }

   SmartDashboard.putString("Motor State", motorState);

  }
  public void m_stopSpinning()
  {
    shooterMotor.set(TalonFXControlMode.PercentOutput, 0.0);
  }

  public void m_zeroEncoder(){
    shooterMotor.setSelectedSensorPosition(0);
  }

  public double m_getPosition(){
    return shooterMotor.getSelectedSensorPosition();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }*/
}
