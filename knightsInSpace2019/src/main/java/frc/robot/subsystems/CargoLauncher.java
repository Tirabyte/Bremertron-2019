/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class CargoLauncher extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public Solenoid m_LiftPiston = new Solenoid(RobotMap.Launcher_Piston);

  public static Talon m_LaunchIOMotor1 = new Talon(RobotMap.Launcher_IntakeOutakeMotor1);
  public static Talon m_LaunchIOMotor2 = new Talon(RobotMap.Launcher_IntakeOutakeMotor2);
  public static Talon m_LaunchRMotor1 = new Talon(RobotMap.Launcher_RotationalMotor1);
  public static Talon m_LaunchRMotor2 = new Talon(RobotMap.Launcher_RotationalMotor2);

  public void setRPosition(int position){
    
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
