// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


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

public class ShooterSubsystem extends SubsystemBase {
 private static TalonFX shooterMotor = new TalonFX(Constants.SHOOTER_MOTOR_PORT);
 
 //Calculation stuff
 private double numerator;
 private double denominator;
 private double frac;
 private double circball;
 private double circwheel;
 private double Vi;
 private double xDisplacement = 0;
 private double angleToGoal;
 private double rpsball;
 private double rps_ratio;
 private double rpsflywheel;
 private static double rpm = 0;

//(x units/100ms) = (rpm * Constants.K_SENSOR_UNITS_PER_ROTATION/600(units/100ms))


//limelight isn't currently doing anything
 NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
 NetworkTableEntry tx = table.getEntry("tx");
 NetworkTableEntry ty = table.getEntry("ty");

  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem() {
    shooterMotor.setNeutralMode(NeutralMode.Coast);

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
    shooterMotor.config_kD(Constants.PID_LOOP_IDX, Constants.kGains.kDShooter, Constants.TIMEOUT_MS);
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

  public void m_calculateRPM(){
    angleToGoal = ty.getDouble(0);//the 0 is a constant
    SmartDashboard.putNumber("Angle To Goal", angleToGoal);
    xDisplacement = (Constants.GOAL_HEIGHT - Constants.LIMELIGHT_HEIGHT_OFF_GROUND) / 
        Math.tan(Math.toRadians(angleToGoal) + Math.toRadians(Constants.LIMELIGHT_MOUNT_ANGLE));
    xDisplacement += 10; //Distance between shooter and limelight
    xDisplacement /= 12.0; //To feet
    xDisplacement += 3; //Adding the radius of the hoop

    xDisplacement = 25;

    SmartDashboard.putNumber("DISTANCE", xDisplacement);
    numerator = Constants.GRAVITY * xDisplacement * xDisplacement;
    denominator = 2.0 * (((Constants.GOAL_HEIGHT / 12.0) - (Constants.SHOOTER_HEIGHT_OFF_GROUND / 12.0)) - (xDisplacement * Math.tan(Constants.THETA))) 
        * Math.pow(Math.cos(Constants.THETA), 2);
    
    frac = numerator / denominator;
    Vi = Math.sqrt(frac);

    circball = (2.0 * Math.PI * Constants.COMPRESSED_RADIUS) / 12.0; //ft
    circwheel = (2.0 * Math.PI * Constants.FLYWHEEL_RADIUS) / 12.0; //ft

    rpsball = Vi / circball; //rotations per second

    rps_ratio = (circball / circwheel); //ratio of ball rpm to wheel rpm

    rpsflywheel = rpsball * rps_ratio / Constants.SLIPPERINESS; //rotations per second

    rpm = 60 * rpsflywheel;
    

  }


  public void m_shoot()
  {    
    SmartDashboard.putNumber("rpm", rpm);

    double motorSpeed = (Constants.K_SENSOR_UNITS_PER_ROTATION / 600.0) * rpm;
    //600 is a modifer to get min to 100 ms and 2048 gets rotations to units 

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
}
