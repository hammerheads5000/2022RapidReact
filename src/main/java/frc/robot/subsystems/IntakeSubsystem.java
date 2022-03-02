// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

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
  private static CANSparkMax wheelMotor = new CANSparkMax(Constants.WHEEL_INTAKE_MOTOR_PORT, MotorType.kBrushless);
  
  private static DigitalInput upIR = new DigitalInput(Constants.INTAKE_UPPER_IR_PORT);
  private static DigitalInput downIR = new DigitalInput(Constants.INTAKE_LOWER_IR_PORT);  

  /** Creates a new IntakeSubsystem. */
  public IntakeSubsystem() {
    // Use addRequirements() here to declare subsystem dependencies.
   /*
    lowerMotor.setIdleMode(IdleMode.kBrake);
    wheelMotor.setIdleMode(IdleMode.kBrake);

    lowerMotor.setInverted(false); //change to constants once verified
    wheelMotor.setInverted(false);


    lowerMotor.setOpenLoopRampRate(1); //1 is to be tested then made into a constant
    wheelMotor.setOpenLoopRampRate(1);
    */
    //CANSparkMax might need to be run closed-loop which means PID integration
  }

  public void periodic(){
    wheelMotor.setIdleMode(IdleMode.kBrake);
  }
  public void m_lower(){
   
    lowerMotor.set(Constants.INTAKE_LIFT_SPEED);
  }

  public void m_raise(){
    
    lowerMotor.set(-Constants.INTAKE_LIFT_SPEED);
      
  }

  public void m_intake() {
    wheelMotor.set(Constants.INTAKE_SPEED);
    SmartDashboard.putNumber("Intake Wheel Speed", wheelMotor.get());
  }

  public void m_outtake() {
    wheelMotor.set(-Constants.INTAKE_SPEED);
  }

  public void m_turnOffLower(){
    lowerMotor.set(0);
  }

  public void m_turnOffWheel(){
    wheelMotor.set(0);
  }

  public boolean m_getUpIR(){
    return upIR.get();
  }

  public boolean m_getDownIR(){
    return downIR.get();
  }



}
