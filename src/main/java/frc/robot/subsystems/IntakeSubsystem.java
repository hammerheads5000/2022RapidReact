// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class IntakeSubsystem extends SubsystemBase {
  
  private static CANSparkMax lowerMotor = new CANSparkMax(Constants.LOWER_INTAKE_MOTOR_PORT, MotorType.kBrushless);

  private static TalonFX wheelMotor = new TalonFX(Constants.WHEEL_INTAKE_MOTOR_PORT);

  private static DigitalInput upIR = new DigitalInput(Constants.INTAKE_UPPER_IR_PORT);
  private static DigitalInput downIR = new DigitalInput(Constants.INTAKE_LOWER_IR_PORT);  

  private static boolean endOfMatch = false;

  /** Creates a new IntakeSubsystem. */
  public IntakeSubsystem() {
    wheelMotor.setNeutralMode(NeutralMode.Coast);
    lowerMotor.setIdleMode(IdleMode.kBrake);
  }

  public void periodic(){
    //SmartDashboard.putBoolean("Down IR", m_getDownIR());
    //SmartDashboard.putBoolean("Up IR", m_getUpIR());
  }

  public void m_atTheEnd(){
    endOfMatch = true;
  }

  public void m_atTheEndTwo(){
    endOfMatch = false;
  }

  public boolean m_getEndOfMatch(){
    return endOfMatch;
  }

  public void m_lower(){
   
    lowerMotor.set(Constants.INTAKE_LIFT_DOWN_SPEED);
  }

  public void m_brakeWayDown(){
    lowerMotor.set(-Constants.BRAKE_SPEED);
  }

  public void m_brakeWayUp(){
    lowerMotor.set(Constants.BRAKE_SPEED);
  }

  public void m_raise(){
    
    lowerMotor.set(-Constants.INTAKE_LIFT_UP_SPEED);
  }

  public void m_intake() {
   wheelMotor.set(TalonFXControlMode.PercentOutput, Constants.INTAKE_SPEED);
  }

  public void m_outtake() {
    wheelMotor.set(TalonFXControlMode.PercentOutput, -Constants.INTAKE_SPEED);
  }

  public void m_turnOffLower(){
    lowerMotor.set(0);
  }

  public void m_turnOffWheel(){
    wheelMotor.set(TalonFXControlMode.PercentOutput, 0);
  }

  public boolean m_getUpIR(){
    return upIR.get();
  }

  public boolean m_getDownIR(){
    return downIR.get();
  }



}
