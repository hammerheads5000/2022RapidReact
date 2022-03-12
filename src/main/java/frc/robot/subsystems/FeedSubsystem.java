// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FeedSubsystem extends SubsystemBase {
  /** Creates a new FeedSubsystem. */
 
  private final DigitalInput shooterSideIRSensor;
   //private final DigitalInput irSensor2;

  private static TalonSRX shooterSideFeedMotor = new TalonSRX(Constants.SHOOTER_SIDE_FEED_MOTOR_PORT);
  private static TalonSRX intakeSideFeedMotor = new TalonSRX(Constants.INTAKE_SIDE_FEED_MOTOR_PORT);
  
  public FeedSubsystem() {
    shooterSideIRSensor = new DigitalInput(Constants.IR_SENSOR_1_PORT);
    
    shooterSideFeedMotor.setNeutralMode(NeutralMode.Coast);    
    intakeSideFeedMotor.setNeutralMode(NeutralMode.Coast);

  }
  public void periodic(){
    //SmartDashboard.putBoolean("Shooter Side IR", m_getShooterSideIRSensor());
  }


  public void m_shooterSideFeedMotor(){
    shooterSideFeedMotor.set(TalonSRXControlMode.PercentOutput, Constants.WHILE_INTAKE_FEED_MOTOR_SPEED);
  }

  public void m_intakeSideFeedMotor(){
    intakeSideFeedMotor.set(TalonSRXControlMode.PercentOutput, -Constants.FEED_MOTOR_SPEED);
  }

  public void m_feedInManual(){
    shooterSideFeedMotor.set(TalonSRXControlMode.PercentOutput, -Constants.FEED_MOTOR_SPEED);
    intakeSideFeedMotor.set(TalonSRXControlMode.PercentOutput, -Constants.FEED_MOTOR_SPEED);
  }

  public void m_feedOut(){
    shooterSideFeedMotor.set(TalonSRXControlMode.PercentOutput, Constants.FEED_MOTOR_SPEED);
    intakeSideFeedMotor.set(TalonSRXControlMode.PercentOutput, Constants.FEED_MOTOR_SPEED);
  }

  public void m_stopFeed(){
    shooterSideFeedMotor.set(TalonSRXControlMode.PercentOutput, 0); 
    intakeSideFeedMotor.set(TalonSRXControlMode.PercentOutput, 0);
  }
  

  public boolean m_getShooterSideIRSensor(){
    return shooterSideIRSensor.get();
  }
}
