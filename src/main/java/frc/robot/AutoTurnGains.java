// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/** Add your docs here. */
public class AutoTurnGains {
    
    public final double kPTurn;
	public final double kITurn;
	public final double kDTurn;
	public final double kFTurn;
	public final int kIzoneTurn;
	public final double kPeakOutputTurn;
	
	public AutoTurnGains(double Turn_kP, double Turn_kI, double Turn_kD, double Turn_kF, int Turn_kIzone, 
	double Turn_kPeakOutput){
	
		kPTurn = Turn_kP;
		kITurn = Turn_kI;
		kDTurn = Turn_kD;
		kFTurn = Turn_kF;
		kIzoneTurn = Turn_kIzone;
		kPeakOutputTurn = Turn_kPeakOutput;
    }





}
