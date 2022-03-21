// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CameraSubsystem extends SubsystemBase {
  /** Creates a new CameraSubsystem. */
  UsbCamera camera1;
  UsbCamera camera2;
  NetworkTableEntry cameraSelection;

  public CameraSubsystem() {}

  public void m_init(){
    camera1 = CameraServer.startAutomaticCapture(0);
   // camera2 = CameraServer.startAutomaticCapture(1);

    cameraSelection = NetworkTableInstance.getDefault().getTable("").getEntry("CameraSelection");
  }

  public void m_cameraOne(){
    cameraSelection.setString(camera1.getName());
  }

  public void m_cameraTwo(){
    cameraSelection.setString(camera2.getName());
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
