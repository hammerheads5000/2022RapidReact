// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/** Add your docs here. */
public class AutoConstants {
    public static double ENCODER_TICKS_PER_FOOT = 8732;

    public static int AUTO_PID_LOOP_IDX = 0;
    public static int AUTO_TIMEOUT_MS = 2;
    public static AutoGains aGains = new AutoGains(0.05, 0.0, 0.4, 0.0,  0,  0.2);
    public static AutoTurnGains tGains = new AutoTurnGains(0.05, 0.0, 0.6, 0.0,  0,  0.2);
    public static int AUTO_ERROR = 1000;//temporary
    public static double EASY_AUTO_TIME_LIMIT = 5;
    public static double AUTO_FEED_WAIT_TIME = 1;
    public static double AUTO_DRIVE_DELAY = 1;


    public static double MAIN_TOP_PATH = (120.4335532 / 12.0)*ENCODER_TICKS_PER_FOOT;
    public static double TOP_MIDDLE_PATH = (71.892 / 12.0)*ENCODER_TICKS_PER_FOOT;
    public static double BOTTOM_MIDDLE_PATH = (46.8 / 12.0)*ENCODER_TICKS_PER_FOOT;
    public static double MAIN_MIDDLE_PATH =( 140.5396742 / 12.0)*ENCODER_TICKS_PER_FOOT;
    public static double BOTTOM_PATH = (30 / 12.0)*ENCODER_TICKS_PER_FOOT;
    public static double MAIN_BOTTOM_PATH = (217.3292433 / 12.0)*ENCODER_TICKS_PER_FOOT;
    public static double ONE_DEGREE = 25616 / 90;

    public static double TOP_PATH_FIRST_TURN = 1.397 * ONE_DEGREE;
    public static double TOP_PATH_SECOND_TURN = 180 * ONE_DEGREE;
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
    public static double EASY_PATH_DISTANCE = -3 * ENCODER_TICKS_PER_FOOT;
    public static double OTHER_EASY_PATH_DISTANCE = 3 * ENCODER_TICKS_PER_FOOT;
    public static double MOVE_CLOSER = 2 * ENCODER_TICKS_PER_FOOT;
    public static double THIRD_BALL_DISTANCE = -8 * ENCODER_TICKS_PER_FOOT;

    //If you're as discriminating as I am, it can be tough to figure out what to put for the RPM.
    //FENDER TO BALL IS 10 FEET
    public static int EASY_PATH_RPM = 0;
    public static int MAXIMUM_JERK_AUTO = 1000;
    public static double NINETY_DEGREES = 90 * ONE_DEGREE;
    public static double FORTY_FIVE_DEGREES = 45 * ONE_DEGREE;
    public static double ZERO_DEGREES = 0 * ONE_DEGREE;
    public static double ONE_EIGHTY_DEGREES = 180 * ONE_DEGREE;


//Both numbers were decreased by 20, then close was raised by 10 
    public static double CLOSE_TO_TERMINAL = (130.0 / 12.0) * ENCODER_TICKS_PER_FOOT;
    public static double FAR_TO_TERMINAL = (230.0 / 12.0) * ENCODER_TICKS_PER_FOOT;
    //was 166 earlier
    public static double CLOSE_ANGLE_TO_TERMINAL = 154.0 * ONE_DEGREE;
    //94.5 before
    public static double FAR_ANGLE_TO_TERMINAL = 98 * ONE_DEGREE;
    public static double DRIVE_TO_SECOND_BALL = (54 / 12.0)*ENCODER_TICKS_PER_FOOT;

}
