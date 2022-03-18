// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/** Add your docs here. */
public class AutoConstants {
    public static int AUTO_PID_LOOP_IDX = 0;
    public static int AUTO_TIMEOUT_MS = 5;
    public static AutoGains aGains = new AutoGains(0.1, 0.0, 0.05, 0.0,  0,  0.4);
    public static AutoTurnGains tGains = new AutoTurnGains(0.1, 0.0, 0.0, 0.0,  0,  0.4);
    public static int AUTO_ERROR = 0;//temporary
    public static double TOP_PATH = 20 * (43.35 / (2 * Math.PI * 6));
    public static double MAIN_TOP_PATH = 20 * (226.4335532 / (2 * Math.PI * 6));
    public static double TOP_MIDDLE_PATH = 20 * (71.892 / (2 * Math.PI * 6));
    public static double BOTTOM_MIDDLE_PATH = 20 * (46.8 / (2 * Math.PI * 6));
    public static double MAIN_MIDDLE_PATH = 20 * (140.5396742 / (2 * Math.PI * 6));
    public static double BOTTOM_PATH = 20 * (30 / (2 * Math.PI * 6)); //6 is radius of wheel
    public static double MAIN_BOTTOM_PATH = 20 * (217.3292433 / (2 * Math.PI * 6));
    public static double TOP_PATH_FIRST_TURN = 7.947377778;//1.397
    public static double TOP_PATH_SECOND_TURN = 958.7541333;//168.531 angle //958.7541333 amount of spinning the motor must do
    public static double TOP_PATH_THIRD_TURN = 579.4759111;//101.861 //579.4759111
    public static double TOP_MIDDLE_PATH_FIRST_TURN = 9.580088889;//1.684
    public static double BOTTOM_MIDDLE_PATH_FIRST_TURN = 11.81582222;//2.077
    public static double TOP_MIDDLE_PATH_SECOND_TURN = 794.7150222;//139.696 //794.7150222
    public static double BOTTOM_MIDDLE_PATH_SECOND_TURN = 957.9576889;//168.391 //957.9576889
    public static double MIDDLE_PATH_THIRD_TURN = 857.2302222;//150.685 
    public static double BOTTOM_PATH_FIRST_TURN = 6.519466667;//1.146
    public static double BOTTOM_PATH_SECOND_TURN = 972.288;//170.91 //972.288
    public static double BOTTOM_PATH_THIRD_TURN = 527.6444444;//92.75 //527.6444444 
    public static int TOP_PATH_RPM = 0;
    public static int MIDDLE_TOP_PATH_RPM = 0;
    public static int MIDDLE_BOTTOM_PATH_RPM = 0;
    public static int BOTTOM_PATH_RPM = 0;
    public static int RPM_IN_AUTO = 6380;
    public static boolean TURN_RIGHT = true;
    public static boolean TURN_LEFT = false;
}
