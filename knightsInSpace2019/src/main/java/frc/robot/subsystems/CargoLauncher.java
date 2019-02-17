/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
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
  private static double m_speed = 0.5;
  private static double m_launchSpeed = 0.7;

  public Solenoid m_LauncherPiston = new Solenoid(RobotMap.Launcher_Piston);
  
  public static Talon m_LaunchIOMotor1 = new Talon(RobotMap.Launcher_IntakeOutakeMotor1);
  public static Talon m_LaunchIOMotor2 = new Talon(RobotMap.Launcher_IntakeOutakeMotor2);
  public static Talon m_LaunchRMotor1 = new Talon(RobotMap.Launcher_RotationalMotor1);
  public static Talon m_LaunchRMotor2 = new Talon(RobotMap.Launcher_RotationalMotor2);

  public static Encoder m_LauncherREncoder = new Encoder(RobotMap.Launcher_EncoderA, RobotMap.Launcher_EncoderB);

  public void setPosition(boolean direction){ //true for clockwise, false for counterclockwise
    if(direction = true){
      m_LaunchRMotor1.set(-m_speed);
      m_LaunchRMotor2.set(m_speed);
    }else {
      m_LaunchRMotor1.set(m_speed);
      m_LaunchRMotor2.set(-m_speed);
    }
  }

  public void cargoIO(boolean direction){ //true for Intake, false for outtake
    if(direction = true){
      m_LaunchIOMotor1.set(-m_launchSpeed);
      m_LaunchIOMotor2.set(-m_launchSpeed);
    }else{
      m_LaunchIOMotor1.set(m_launchSpeed);
      m_LaunchIOMotor2.set(m_launchSpeed);
    }
    
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
