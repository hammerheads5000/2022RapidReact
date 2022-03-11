// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/** Add your docs here. */
public class AutoGains {
    
    
    public final double kPAuto;
	public final double kIAuto;
	public final double kDAuto;
	public final double kFAuto;
	public final int kIzoneAuto;
	public final double kPeakOutputAuto;
	
	public AutoGains(double Auto_kP, double Auto_kI, double Auto_kD, double Auto_kF, int Auto_kIzone, 
	double Auto_kPeakOutput){
	
		kPAuto = Auto_kP;
		kIAuto = Auto_kI;
		kDAuto = Auto_kD;
		kFAuto = Auto_kF;
		kIzoneAuto = Auto_kIzone;
		kPeakOutputAuto = Auto_kPeakOutput;
    }

    
    
}
