// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
 private static TalonFX leftShooterMotor = new TalonFX(Constants.SHOOTER_LEFT_MOTOR_PORT);
 private static TalonFX rightShooterMotor = new TalonFX(Constants.SHOOTER_RIGHT_MOTOR_PORT);



 static double rpm = 0.0;
//limelight isn't currently doing anything
 NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
 NetworkTableEntry ty = table.getEntry("ty");

  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem() {
    leftShooterMotor.setNeutralMode(NeutralMode.Coast);
    rightShooterMotor.setNeutralMode(NeutralMode.Coast);


    double testF = 0.0;
    double testP = 1.0;
    double testI = 0.0;
    double testD = 0.0;
    double testError = 100;
    SmartDashboard.putNumber("F", testF);
    SmartDashboard.putNumber("P", testP);
    SmartDashboard.putNumber("I", testI);
    SmartDashboard.putNumber("D", testD);
    SmartDashboard.putNumber("Error", testError);



    //left motor specific stuff
    leftShooterMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, Constants.PID_LOOP_IDX, Constants.TIMEOUT_MS);
    leftShooterMotor.setSensorPhase(Constants.PHASE_SENSOR);
    leftShooterMotor.configNominalOutputForward(0, Constants.TIMEOUT_MS);
	  leftShooterMotor.configNominalOutputReverse(0, Constants.TIMEOUT_MS);
		leftShooterMotor.configPeakOutputForward(Constants.SHOOTER_PEAK_OUTPUT, Constants.TIMEOUT_MS);
		leftShooterMotor.configPeakOutputReverse(-Constants.SHOOTER_PEAK_OUTPUT, Constants.TIMEOUT_MS);

		leftShooterMotor.configAllowableClosedloopError(Constants.PID_LOOP_IDX, (2048.0 / 600.0) * testError, Constants.TIMEOUT_MS);

		leftShooterMotor.config_kF(Constants.PID_LOOP_IDX, testF, Constants.TIMEOUT_MS);  
    leftShooterMotor.config_kP(Constants.PID_LOOP_IDX, testP, Constants.TIMEOUT_MS);
		leftShooterMotor.config_kI(Constants.PID_LOOP_IDX, testI, Constants.TIMEOUT_MS);
    leftShooterMotor.config_kD(Constants.PID_LOOP_IDX, testD, Constants.TIMEOUT_MS);


    //right motor specific stuff
    
    rightShooterMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, Constants.PID_LOOP_IDX, Constants.TIMEOUT_MS);
    rightShooterMotor.setSensorPhase(Constants.PHASE_SENSOR);
    rightShooterMotor.configNominalOutputForward(0, Constants.TIMEOUT_MS);
		rightShooterMotor.configNominalOutputReverse(0, Constants.TIMEOUT_MS);
		rightShooterMotor.configPeakOutputForward(Constants.SHOOTER_PEAK_OUTPUT, Constants.TIMEOUT_MS);
		rightShooterMotor.configPeakOutputReverse(-Constants.SHOOTER_PEAK_OUTPUT, Constants.TIMEOUT_MS);

		rightShooterMotor.configAllowableClosedloopError(Constants.PID_LOOP_IDX, (2048.0 / 600.0) * testError, Constants.TIMEOUT_MS);

		rightShooterMotor.config_kF(Constants.PID_LOOP_IDX, testF, Constants.TIMEOUT_MS);  
    rightShooterMotor.config_kP(Constants.PID_LOOP_IDX, testP, Constants.TIMEOUT_MS);
		rightShooterMotor.config_kI(Constants.PID_LOOP_IDX, testI, Constants.TIMEOUT_MS);
    rightShooterMotor.config_kD(Constants.PID_LOOP_IDX, testD, Constants.TIMEOUT_MS);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void m_TurnOnLimelight(){
    table.getEntry("ledMode").setNumber(0); 
  }

  public void m_TurnOffLimelight(){
    table.getEntry("ledMode").setNumber(1);  
  }
  public void m_shoot()
  {
    double y = ty.getDouble(0.0);
    double heading_error = -y;

    rpm = Constants.KP_FLYWHEEL * heading_error; //This will be in a formula later when we have run tests.

    rpm = 5000;
    SmartDashboard.putNumber("rpm", rpm);
    //600 is a modifer to get min to 100 ms and 2048 gets rotations to units 
    //Right now I'm putting the motors at desired rpm for testing purposes 6380 or whatever number is after (2048 / 600) will change to rpm
   leftShooterMotor.set(TalonFXControlMode.Velocity, (2048.0 / 600.0) * rpm);
   rightShooterMotor.set(TalonFXControlMode.Velocity, -((2048.0 / 600.0) * rpm));
 
   SmartDashboard.putNumber("RPM", ((600.0 * leftShooterMotor.getSelectedSensorVelocity()) / 2048.0));
   String motorState;
   if(leftShooterMotor.getSelectedSensorVelocity(Constants.PID_LOOP_IDX) > 0){
     motorState = "forward";
   }else if(leftShooterMotor.getSelectedSensorVelocity(Constants.PID_LOOP_IDX) == 0){
     motorState = "stopped";
   }else{
     motorState = "reverse";
   }

   SmartDashboard.putString("Motor State", motorState);

  }
  public void m_stopSpinning()
  {
    leftShooterMotor.set(TalonFXControlMode.PercentOutput, 0.0);//it's a stray number but you can tell it makes the motor spin at 0%
    rightShooterMotor.set(TalonFXControlMode.PercentOutput, 0.0);
  }

  public void m_zeroEncoder(){
    leftShooterMotor.setSelectedSensorPosition(0);
    rightShooterMotor.setSelectedSensorPosition(0);
  }

  public double m_getPosition(){
    return leftShooterMotor.getSelectedSensorPosition();
  }
}
