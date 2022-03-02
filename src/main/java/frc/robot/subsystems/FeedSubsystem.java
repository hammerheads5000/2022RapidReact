// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FeedSubsystem extends SubsystemBase {
  /** Creates a new FeedSubsystem. */
 
 // private final DigitalInput irSensor1;
  // private final DigitalInput irSensor2;

  private static TalonSRX firstFeedMotor = new TalonSRX(Constants.FIRST_FEED_MOTOR_PORT);
  private static TalonSRX secondFeedMotor = new TalonSRX(Constants.SECOND_FEED_MOTOR_PORT);

  public FeedSubsystem() {
   /*
     commented out because the lack of physical ir sensors could cause safety issues
    irSensor1 = new DigitalInput(Constants.IR_SENSOR_1_PORT);
    irSensor2 = new DigitalInput(Constants.IR_SENSOR_2_PORT);
    */
    firstFeedMotor.setNeutralMode(NeutralMode.Coast);
  }

  public void m_feedFirstBallIn(){
    firstFeedMotor.set(TalonSRXControlMode.PercentOutput, Constants.FEED_MOTOR_SPEED);
  }

  public void m_feedInManual(){
    firstFeedMotor.set(TalonSRXControlMode.PercentOutput, Constants.FEED_MOTOR_SPEED);
    secondFeedMotor.set(TalonSRXControlMode.PercentOutput, Constants.FEED_MOTOR_SPEED);
  }
  public void m_feedOut(){
    firstFeedMotor.set(TalonSRXControlMode.PercentOutput, -Constants.FEED_MOTOR_SPEED);
    secondFeedMotor.set(TalonSRXControlMode.PercentOutput, -Constants.FEED_MOTOR_SPEED);
  }
  public void m_stopFeed(){
    firstFeedMotor.set(TalonSRXControlMode.PercentOutput, 0); //I couldn't figure out how to get it to brake so I just did this
    secondFeedMotor.set(TalonSRXControlMode.PercentOutput, 0);
  }
  /*
  commented out because the lack of physical ir sensors could cause safety issues

  public boolean m_getSensor1(){
    return irSensor1.get();
  }

  public boolean m_getSensor2(){
    return irSensor2.get();
  }
*/

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
}
