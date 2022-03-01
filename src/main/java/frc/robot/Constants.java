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
  
    //Joystick constants
    public static int DRIVE_JOYSTICK_PORT = 0;
    public static int BUTTONS_JOYSTICK_PORT = 1;
    public static int X = 0;
    public static int Y = 1;
    public static int Z = 2;
    public static int S = 3;

    //IR Sensors
    public static int IR_SENSOR_1_PORT = 8;
    public static int IR_SENSOR_2_PORT = 9;
    
    //Motor Ports
    public static int LEFT_FRONT_DRIVE_MOTOR_PORT = 26;
    public static int LEFT_BACK_DRIVE_MOTOR_PORT = 23;
    public static int RIGHT_FRONT_DRIVE_MOTOR_PORT = 25;
    public static int RIGHT_BACK_DRIVE_MOTOR_PORT = 24;

    public static int LIFT_MOTOR_PORT = 4;

    public static int WHEEL_INTAKE_MOTOR_PORT = 5;
    public static int LOWER_INTAKE_MOTOR_PORT = 6;
    public static int INTAKE_UPPER_IR_PORT = 7;
    public static int INTAKE_LOWER_IR_PORT = 8;

    public static int FIRST_FEED_MOTOR_PORT = 9;
    public static int SECOND_FEED_MOTOR_PORT = 10;

    public static int SHOOTER_MOTOR_PORT = 1;

    //Other drive constants
    public static double TURN_ADJUST = 0.4;

    //Motor Speeds
    public static double LIFT_UP_SPEED = 0.1;
    public static double LIFT_DOWN_SPEED = -0.1;

    public static double INTAKE_LIFT_SPEED = 0.5;
    public static double INTAKE_SPEED = 1.0;
    public static double OUTTAKE_SPEED = -1.0;

    public static double FEED_MOTOR_SPEED = 1.0;


    //Joystick Constants
    public static boolean NOT_INTERRUPTIBLE = false;
    public static boolean INTERRUPTIBLE = true;

    //Drive Joystick Buttons
    public static int LIFT_UP_BUTTON = 7;
    public static int LIFT_DOWN_BUTTON = 2;

    public static int FEED_IN_BUTTON = 3;
    public static int FEED_OUT_BUTTON = 4;

    public static int INTAKE_BUTTON = 5;
    public static int OUTTAKE_BUTTON = 6;

    public static int AIM_BUTTON = 1;
    
    //Buttons Joystick Buttons
    public static int SHOOT_BUTTON = 1;

    //PID Constants
    public static double KP_DRIVE_AIM = 0.15;
    public static double MIN_COMMAND_DRIVE_AIM = 0.05;

    public static double KP_FLYWHEEL = 0.85;

    //PID shooter constants:
    public static int PID_LOOP_IDX = 0;
    public static int TIMEOUT_MS = 5;

    public static boolean PHASE_SENSOR = false;
    public static boolean INVERTED = true;
    public static double K_SENSOR_UNITS_PER_ROTATION = 2048.0;

    public static int SHOOTER_ERROR = 60;


    //PIDF - IZone - PeakOutput
    public static Gains kGains = new Gains(0.18, 0.0, 0.09, 0.047,  0,  1.0);


    public static double kS = 0.80192;
    public static double kV = 0.09327;
    public static double kA = 0.004018;

    //Lift Constants
    public static double LIFT_DISTANCE = 1000.0; //I don't know the actual distance it'll need to go up so I'm guessing it'll be a meter for now
    public static double MOTOR_SHAFT_DIAMETER = 6.0;
}
