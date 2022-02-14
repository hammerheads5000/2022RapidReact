// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class IntakeSubsystem extends SubsystemBase {
  
  private static CANSparkMax lowerMotor = new CANSparkMax(Constants.LOWER_INTAKE_MOTOR_PORT, MotorType.kBrushless);
  private static CANSparkMax wheelMotor = new CANSparkMax(Constants.WHEEL_INTAKE_MOTOR_PORT, MotorType.kBrushless);
  private static DigitalInput upIR = new DigitalInput(Constants.INTAKE_UPPER_IR_PORT);
  private static DigitalInput downIR = new DigitalInput(Constants.INTAKE_LOWER_IR_PORT);  

  /** Creates a new IntakeSubsystem. */
  public IntakeSubsystem() {
    // Use addRequirements() here to declare subsystem dependencies.
    
  }

  public void m_lower(){
    if (upIR.get()){
      lowerMotor.set(Constants.INTAKE_LIFT_SPEED);
    }
  }

  public void m_raise(){
    if (downIR.get()){
      lowerMotor.set(-Constants.INTAKE_LIFT_SPEED);
    }  
  }

  public void m_intake() {
    wheelMotor.set(Constants.INTAKE_SPEED);
  }

  public void m_outtake() {
    wheelMotor.set(-Constants.INTAKE_SPEED);
  }

  public void periodic(){
    
    if (downIR.get())
      lowerMotor.set(0);
    if (upIR.get())
      wheelMotor.set(0);
  }

}
