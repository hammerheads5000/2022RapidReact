// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/** Add your docs here. */
public class AutoConstants {
    public static int AUTO_PID_LOOP_IDX = 0;//change maybe
    public static int AUTO_TIMEOUT_MS = 5;//change maybe
    public static AutoGains aGains = new AutoGains(0.0, 0.0, 0.0, 0.0,  0,  0.0);//all at 0 for now
    public static int AUTO_ERROR = 60;//definitely will be changed
    public static double TOP_PATH = 57.8;
    public static double MAIN_TOP_PATH = 302.4;
    public static double TOP_MIDDLE_PATH = 96;
    public static double BOTTOM_MIDDLE_PATH = 62.4;
    public static double MAIN_MIDDLE_PATH = 187.2;
    public static double BOTTOM_PATH = 57.8;
    public static double MAIN_BOTTOM_PATH = 289.6;
}
