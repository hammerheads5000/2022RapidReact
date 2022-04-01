// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/** Add your docs here. */
public class AutoConstants {
    public static double ENCODER_TICKS_PER_FOOT = 8732;

    public static int AUTO_PID_LOOP_IDX = 0;
    public static int AUTO_TIMEOUT_MS = 5;
    public static AutoGains aGains = new AutoGains(0.1, 0.00002, 0.6, 0.0,  0,  0.3);
    public static AutoTurnGains tGains = new AutoTurnGains(0.2, 0.00002, 0.6, 0.0,  0,  0.3);
    public static int AUTO_ERROR = 1000;//temporary

    public static double EASY_AUTO_TIME_LIMIT = 5;
    public static double AUTO_INTAKE_TIME = 10;

    public static double AUTO_FEED_WAIT_TIME = 2;

    public static double TOP_PATH = 20 * (43.35 / (2 * Math.PI * 6));
    public static double MAIN_TOP_PATH = 20 * (226.4335532 / (2 * Math.PI * 6));
    public static double TOP_MIDDLE_PATH = 20 * (71.892 / (2 * Math.PI * 6));
    public static double BOTTOM_MIDDLE_PATH = 20 * (46.8 / (2 * Math.PI * 6));
    public static double MAIN_MIDDLE_PATH = 20 * (140.5396742 / (2 * Math.PI * 6));
    public static double BOTTOM_PATH = 20 * (30 / (2 * Math.PI * 6)); //6 is radius of wheel
    public static double MAIN_BOTTOM_PATH = 20 * (217.3292433 / (2 * Math.PI * 6));
    public static double ONE_DEGREE = 25616 / 90;

    public static double TOP_PATH_FIRST_TURN = 1.397 * ONE_DEGREE;
    public static double TOP_PATH_SECOND_TURN = 168.531 * ONE_DEGREE;
    public static double TOP_PATH_THIRD_TURN = 101.861 * ONE_DEGREE;

    public static double TOP_MIDDLE_PATH_FIRST_TURN = 1.684 * ONE_DEGREE;
    public static double BOTTOM_MIDDLE_PATH_FIRST_TURN = 2.077 * ONE_DEGREE;
    public static double TOP_MIDDLE_PATH_SECOND_TURN = 139.696 * ONE_DEGREE;
    public static double BOTTOM_MIDDLE_PATH_SECOND_TURN = 168.391 * ONE_DEGREE;
    public static double MIDDLE_PATH_THIRD_TURN = 150.685 * ONE_DEGREE;

    public static double BOTTOM_PATH_FIRST_TURN = 1.146 * ONE_DEGREE;
    public static double BOTTOM_PATH_SECOND_TURN = 170.91 * ONE_DEGREE; 
    public static double BOTTOM_PATH_THIRD_TURN = 92.75 * ONE_DEGREE; 

    public static int TOP_PATH_RPM = 0;
    public static int MIDDLE_TOP_PATH_RPM = 0;
    public static int MIDDLE_BOTTOM_PATH_RPM = 0;
    public static int BOTTOM_PATH_RPM = 0;

    public static int RPM_IN_AUTO = 4000;
    public static boolean TURN_RIGHT = true;
    public static boolean TURN_LEFT = false;
    public static int GYRO_PORT = 0;
    public static double EASY_PATH_DISTANCE = -1.5 * ENCODER_TICKS_PER_FOOT;

    //If you're as discriminating as I am, it can be tough to figure out what to put for the RPM.
    public static int EASY_PATH_RPM = 0;
    public static int MAXIMUM_JERK_AUTO = 1000;
    public static double NINETY_DEGREES = 90 * ONE_DEGREE;
    public static double FORTY_FIVE_DEGREES = 45 * ONE_DEGREE;
    
}
