/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class HatchGripper extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private double m_speed = 0.5;
  private static Talon m_IntakeMotor = new Talon(RobotMap.Panel_Intake_Motor);

  private static DoubleSolenoid m_panelExtender = new DoubleSolenoid(RobotMap.Hatch_PistonA, RobotMap.Hatch_PistonB);

  public void gripPanel(boolean direction){
    if(direction = true){
      m_IntakeMotor.set(m_speed);
    }else{
      m_IntakeMotor.set(0);
    }
  }

  public void extendPiston(boolean extended){
     if(extended){
      m_panelExtender.set(Value.kForward);
     }else {
      m_panelExtender.set(Value.kReverse);
     }
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
