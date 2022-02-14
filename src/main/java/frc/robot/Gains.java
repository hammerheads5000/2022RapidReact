package frc.robot;

public class Gains{
    public final double kPShooter;
	public final double kIShooter;
	public final double kDShooter;
	public final double kFShooter;
	public final int kIzoneShooter;
	public final double kPeakOutputShooter;
	
	public Gains(double shooter_kP, double shooter_kI, double shooter_kD, double shooter_kF, int shooter_kIzone, 
	double shooter_kPeakOutput){
	
		kPShooter = shooter_kP;
		kIShooter = shooter_kI;
		kDShooter = shooter_kD;
		kFShooter = shooter_kF;
		kIzoneShooter = shooter_kIzone;
		kPeakOutputShooter = shooter_kPeakOutput;
	}
}