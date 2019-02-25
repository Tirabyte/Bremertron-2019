/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  //Motor Assignments
  //Drive Train Assignments
  public static int Front_Left_Motor = 0;
  public static int Front_Right_Motor = 1;
  public static int Rear_Left_Motor = 2;
  public static int Rear_Right_Motor = 3;

  //Gripper Assignments
  public static int Panel_Intake_Motor = 6;

  //Launcher Assignments
  public static int Launcher_IntakeOutakeMotor1 = 4;
  public static int Launcher_IntakeOutakeMotor2 = 5;
  public static int Launcher_RotationalMotor1 = 7;
  public static int Launcher_RotationalMotor2 = 8;


  //Piston Assignments
  public static int Front_Wheel_PistonsA = 2;// Fore Legs Retract
  public static int Front_Wheel_PistonsB = 3;// Fore Legs Extend
  public static int Rear_Wheel_PistonsA = 0; //Rear Legs Retract
  public static int Rear_Wheel_PistonsB = 1; // Rear Legs Extend
  // public static int Launcher_Piston = 2;
  public static int Hatch_PistonA = 6; //Hatch Extend
  public static int Hatch_PistonB = 7; //Hatch Retract
  public static int Hatch_Valve_In = 4; // Vacuum Breaker 1
  public static int Hatch_Valve_Out = 5; // Vacuum Breaker 2

  //Encoder Assignments (DIO)
  public static int LF_EncoderA = 0;
  public static int LF_EncoderB = 1;
  public static int RF_EncoderA = 2;
  public static int RF_EncoderB = 3;
  public static int LB_EncoderA = 4;
  public static int LB_EncoderB = 5;
  public static int RB_EncoderA = 6;
  public static int RB_EncoderB = 7;
  public static int Launcher_EncoderA = 8;
  public static int Launcher_EncoderB = 9;

  //Analog Input
  public static int Front_Height_Ultra = 0;
  public static int Rear_Height_Ultra = 1;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
