// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoCommandGroup extends SequentialCommandGroup {
  /** Creates a new AutoCommandGroup. */
  public AutoCommandGroup() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    
    /* Top Path
    addCommands(
      Turn x degrees,
      Move forward approximately 3.9 feet,
      Intake the ball,
      Turn 180 degrees,
      Shoot the ball,
      Turn approximately 113.3 degrees,
      Move forward approximately 18.9 feet
    );
    */

    /* Top-Middle Path
    addCommands(
      Turn x degrees,
      Move forward approximately 6 feet,
      Intake the ball,
      Turn 180 degrees,
      Shoot the ball,
      Turn approximately 110.4 degrees,
      Move forward approximately 11.7 feet
    );
    */

    /* Bottom-Middle Path
    addCommands(
      Turn x degrees,
      Move forward approximately 3.9 feet,
      Intake the ball,
      Turn 180 degrees,
      Shoot the ball,
      Turn approximately 162.3 degrees,
      Move forward approximately 11.7 feet
    );
    */

    /* Bottom Path
    addCommands(
      Turn x degrees,
      Move forward approximately 3.6 feet,
      Intake the ball,
      Turn 180 degrees,
      Shoot the ball,
      Turn approximately  83.7 degrees,
      Move forward approximately 18.1 feet
    );
    */
  }
}
