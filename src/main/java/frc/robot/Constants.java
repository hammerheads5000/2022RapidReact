// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  
    //TODO: Reorganize constants into system specific stuff (ie: drive system, feed system, etc.)
/*
--------------------------------------------------Shooter Constants-------------------------------------------------------------------
*/
    //Calculating RPM constants
        public static double COMPRESSED_RADIUS = 3.5; //in
        public static double FLYWHEEL_RADIUS = 2.0; //in
        public static double CENTER_SHOOTER_Y = 16.4 / 12.0; //ft, a guess which should be verified
        public static double HOOP_Y = 8.0 + 8.0/12.0; //ft
        public static double Y_TRAVELED = HOOP_Y - CENTER_SHOOTER_Y;
        public static double SHOOTER_HEIGHT_OFF_GROUND = 17.625; //in
        public static double RELEASE_ANGLE = 70.0; //degrees from horizontal
        public static double THETA = Math.toRadians(RELEASE_ANGLE);
        public static double SLIPPERINESS = 0.4;
        public static double LIMELIGHT_HEIGHT_OFF_GROUND = 20.125; //in
        public static double GOAL_HEIGHT = 104; //in
        public static double LIMELIGHT_MOUNT_ANGLE = 35.0; // in degrees
        public static double GRAVITY = -32.174;

    //Motor Ports
        public static int SHOOTER_MOTOR_PORT = 1;

    //PID Constants
        public static int SHOOTER_ERROR = 60;

        //PIDF - IZone - PeakOutput
            public static Gains kGains = new Gains(0.18, 0.0, 0.09, 0.047,  0,  1.0);
            public static double kS = 0.80192;
            public static double kV = 0.09327;
            public static double kA = 0.004018;


/*
----------------------------------------------------Intake Constants-------------------------------------------------------------------
*/

    //Motor Ports
        public static int WHEEL_INTAKE_MOTOR_PORT = 0;
        public static int LOWER_INTAKE_MOTOR_PORT = 2;

    //Motor Speeds
        public static double INTAKE_LIFT_DOWN_SPEED = 0.15;
        public static double INTAKE_LIFT_UP_SPEED = 0.4;
        public static double BRAKE_SPEED = 0.00000000001; //I know this is ridiculous but the lift works well now and if it ain
                                                          //'t broke don't fix it.
        public static double INTAKE_SPEED = 0.3;
        public static double OUTTAKE_SPEED = -0.7;
    
    //Timer
        public static double BRAKE_TIME = 0.5;
 
    //IR Sensors
        public static int INTAKE_UPPER_IR_PORT = 8;
        public static int INTAKE_LOWER_IR_PORT = 7;



/*
----------------------------------------------------------Feed Constants-------------------------------------------------------------
*/

    //Motor Ports
    public static int SHOOTER_SIDE_FEED_MOTOR_PORT = 3;
    public static int INTAKE_SIDE_FEED_MOTOR_PORT = 12;

    //IR Sensors
        public static int IR_SENSOR_1_PORT = 0;
        public static int IR_SENSOR_2_PORT = 2;



 
    //Joystick constants
    public static int DRIVE_JOYSTICK_PORT = 0;
    public static int BUTTONS_JOYSTICK_PORT = 1;
    public static int X = 0;
    public static int Y = 1;
    public static int Z = 2;




    
    //Motor Ports
    public static int LEFT_FRONT_DRIVE_MOTOR_PORT = 26;
    public static int LEFT_BACK_DRIVE_MOTOR_PORT = 23;
    public static int RIGHT_FRONT_DRIVE_MOTOR_PORT = 25;
    public static int RIGHT_BACK_DRIVE_MOTOR_PORT = 24;

    public static double DRIVE_SENSITIVITY_CONSTANT = 2;





    //Other drive constants
    public static double TURN_ADJUST = 0.4;

    //Motor Speeds


    public static double FEED_MOTOR_SPEED = 0.7;


    //Joystick Constants
    public static boolean NOT_INTERRUPTIBLE = false;
    public static boolean INTERRUPTIBLE = true;

    //Drive Joystick Buttons

    public static int INTAKE_BUTTON = 1;
    public static int OUTTAKE_BUTTON = 2;
    
    //Buttons Joystick Buttons

    public static int SHOOT_BUTTON = 1;
    public static int AIM_BUTTON = 2;

    public static int FEED_IN_BUTTON = 3;
    public static int FEED_OUT_BUTTON = 5;

    //PID Constants
    public static double KP_DRIVE_AIM = 0.15;
    public static double MIN_COMMAND_DRIVE_AIM = 0.05;


    //PID shooter constants:
    public static int PID_LOOP_IDX = 0;
    public static int TIMEOUT_MS = 5;

    public static boolean PHASE_SENSOR = false;
    public static boolean INVERTED = true;
    public static double K_SENSOR_UNITS_PER_ROTATION = 2048.0;


}
